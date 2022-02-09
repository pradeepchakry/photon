package com.b3soft.photon;

public class GenericLibrary {
    private static native byte[] sortGivenArray(byte[] a);

    protected static byte[] callSortGivenArray(byte[] a) {
        return GenericLibrary.sortGivenArray(a);
    }
}
