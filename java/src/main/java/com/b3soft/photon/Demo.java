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

        // call Rust Library
        byte[] rustRes = GenericLibrary.callSortGivenArray(a);
        for(byte b : rustRes){
            System.out.print(+ b);
            System.out.print(" ");
        }

        // call Java code
        byte h = (byte) (a.length - 1);
        byte l = 0;
        byte[] javaCodeRes = Sorting.quickSort(a, l, h);

        for(byte b : javaCodeRes) {
            System.out.print(+ b);
            System.out.print(" ");
        }

    }
}
