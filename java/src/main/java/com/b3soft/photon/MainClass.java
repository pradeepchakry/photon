package com.b3soft.photon;

public class MainClass {

    private int state;

    public MainClass(int state) {
        this.state = state;
    }

    public static void main(String[] args) {
        try {
            int arg1 = Integer.parseInt(args[1]);
            int arg2 = Integer.parseInt(args[2]);
            int result = new MainClass(arg1).timesRust(arg2);
            System.out.println(arg1 + "x" + arg2 + " = " + result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Arguments must be ints");
        }
    }

    public native int timesRust(int input);

    static {
        System.load("/Users/discovery/work/librust/target/debug/liblibrust.dylib");
    }
}
