package com.b3soft.photon;

public class Sorting {

    public static void main(String[] args) {
        byte[] a = {6, 1, 3, 9, 15, 4, 10};
        byte l = 0;
        byte h = (byte) ((a.length) - 1);
        quickSort(a, l, h);

        for ( int i = 0; i < a.length; i++ ) {
            System.out.print(a[i] + " ");
        }
    }

    public static int partition(byte a[], byte l, byte h) {
        byte i = (byte) (l + 1);
        byte j = h;
        byte c = l;
        byte temp;

        while (i <= j) {
            while ( i <= h && a[i] < a[c] ) {
                i++;
            }

            while ( a[j] > a[c] && j > l) {
                j--;
            }

            if ( i < j ) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            } else {
                break;
            }
        }
        temp = a[l];
        a[l] = a[j];
        a[j] = temp;
        return j;
    }

    public static byte[] quickSort(byte[] a, byte l, byte h) {
        int j = 0;
        if ( l < h ) {
            j = partition(a, l, h);
            quickSort(a, l, (byte) (j - 1));
            quickSort(a, (byte) (j + 1), h);
        }
        return a;
    }
}
