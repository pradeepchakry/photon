package com.b3soft.photon;

public class Demo {

    static {
        System.loadLibrary("photon");
    }

    public static void main(String[] args) {
//        ServerStarter.startServer();
//
//        System.out.println(SampleService.callHelloService("Disha, Darling"));

        byte[] a = {6, 1, 3, 9, 15, 4, 10};
        System.out.println(GenericLibrary.callSortGivenArray(a));

    }
}
