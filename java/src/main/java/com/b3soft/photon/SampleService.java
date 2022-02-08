package com.b3soft.photon;

public class SampleService {
    private static native String hello(String name);

    protected static String callHelloService(String name) {
        return SampleService.hello(name);
    }
}
