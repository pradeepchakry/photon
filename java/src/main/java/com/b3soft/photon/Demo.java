package com.b3soft.photon;

public class Demo {
    public static void main(String[] args) {
        ServerStarter.startServer();

        System.out.println(SampleService.callHelloService("Disha, Darling"));
    }
}
