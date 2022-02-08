package com.b3soft.photon;

public class ServerThread implements Runnable {
    static {
        System.loadLibrary("photon");
    }

    @Override
    public void run() {
        String output = ServerInstance.startServer("7878");
        System.out.println(output);
    }
}
