package com.b3soft.photon;

public class ServerStarter {
    public static void startServer() {
        ServerThread serverThread = new ServerThread();
        Thread thread = new Thread(serverThread);
        thread.start();
    }
}
