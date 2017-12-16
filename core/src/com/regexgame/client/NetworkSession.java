package com.regexgame.client;

import com.badlogic.gdx.Gdx;
import com.regexgame.*;
import com.regexgame.CreateMatchReply;
import com.regexgame.CreateMatchRequest;
import com.regexgame.FindMatchReply;
import com.regexgame.GameAction;
import com.regexgame.JoinMatchReply;
import com.regexgame.JoinMatchRequest;
import com.regexgame.LoginReply;
import com.regexgame.LoginRequest;
import com.regexgame.RegexGameGrpc;
import com.regexgame.game.Player;
import com.regexgame.server.RegexGameServer;
import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.okhttp.OkHttpChannelBuilder;

import java.io.IOException;

public class NetworkSession {
    private ManagedChannel channel;
    private RegexGameGrpc.RegexGameStub stub;
    private RegexGameGrpc.RegexGameBlockingStub blockingStub;
    private long sessionToken;

    NetworkSession(String address, int port, boolean startLocalServer) {
        if (startLocalServer) {
            RegexGameServer server = new RegexGameServer();
            try {
                server.start(port, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            channel = InProcessChannelBuilder.forName("regexgame_server").usePlaintext(true).build();
        } else {
            channel = OkHttpChannelBuilder.forAddress(address, port).usePlaintext(true).build();
        }
        stub = RegexGameGrpc.newStub(channel);
        blockingStub = RegexGameGrpc.newBlockingStub(channel);

        long start = System.currentTimeMillis();
        LoginReply reply = blockingStub.login(LoginRequest.getDefaultInstance());
        long end = System.currentTimeMillis();
        sessionToken = reply.getSessionToken();
        Gdx.app.log("INFO", "Logged in with token: " + sessionToken + ", in " + (end - start) / 1000.0 + "s");
    }

    public RegexGameGrpc.RegexGameStub getStub() {
        return stub;
    }

    public RegexGameGrpc.RegexGameBlockingStub getBlockingStub() {
        return blockingStub;
    }

    public long getSessionToken() {
        return sessionToken;
    }

    public long findMatch() {
        FindMatchReply reply = blockingStub.findMatch(
                com.regexgame.FindMatchRequest.newBuilder().setSessionToken(sessionToken).build());
        return reply.getMatchId();
    }

    public long createMatch() {
        CreateMatchReply reply = blockingStub.createMatch(
                CreateMatchRequest.newBuilder().setSessionToken(sessionToken).build());
        return reply.getMatchId();
    }

    public MatchConnection joinMatch(long matchId) {
        JoinMatchReply reply = blockingStub.joinMatch(JoinMatchRequest.newBuilder()
                .setSessionToken(sessionToken)
                .setMatchId(matchId).build());
        Player player = Player.getByIndex(reply.getPlayerId());
        return new MatchConnection(this, matchId, player);
    }
}
