package com.regexgame.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

class RegexGameServer {
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

    void start() throws IOException {
        server = ServerBuilder.forPort(6001)
                .addService(new RegexGameImpl())
                .build()
                .start();

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
