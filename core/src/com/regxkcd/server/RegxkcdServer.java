package com.regxkcd.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class RegxkcdServer {

    private Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        RegxkcdServer regxkcdServer = new RegxkcdServer();
        regxkcdServer.start();
        regxkcdServer.blockUntilShutdown();
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private void start() throws IOException {
        server = ServerBuilder.forPort(6001)
                .addService(new RegxkcdImpl())
                .build()
                .start();

        System.out.println("Started server");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                RegxkcdServer.this.stop();
                super.run();
            }
        });
    }
}
