package com.regexgame.server;

import java.io.IOException;

public class ServerLauncher {
    public static void main(String[] args) throws IOException, InterruptedException {
        RegexGameServer regexGameServer = new RegexGameServer();
        regexGameServer.start();
        regexGameServer.blockUntilShutdown();
    }
}
