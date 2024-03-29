package com.regexgame.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
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

    public void start(int port, boolean start_local) throws IOException {
        if (start_local) {
            server = InProcessServerBuilder.forName("regexgame_server")
                    .addService(new RegexGameImpl())
                    .build()
                    .start();
        } else {
            server = ServerBuilder.forPort(port)
                    .addService(new RegexGameImpl())
                    .build()
                    .start();
        }

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
