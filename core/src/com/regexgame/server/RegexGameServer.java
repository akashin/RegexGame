package com.regexgame.server;

import io.grpc.Server;
import io.grpc.inprocess.InProcessServerBuilder;

import java.io.IOException;

public class RegexGameServer {
    private Server server;

    void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public void start(int port) throws IOException {
        server = InProcessServerBuilder.forName("regexgame_server")
                .addService(new RegexGameImpl())
                .build()
                .start();

//        server = ServerBuilder.forPort(port)
//                .addService(new RegexGameImpl())
//                .build()
//                .start();

        System.out.println("Started server");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                RegexGameServer.this.stop();
                super.run();
            }
        });
    }
}
