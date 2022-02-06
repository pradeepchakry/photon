package com.b3soft.photon;

public class Sorting {

    public static void main(String[] args) {
        int[] a = {6, 1, 3, 9, 15, 4, 10};
        int l = 0;
        int h = a.length - 1;
        quickSort(a, l, h);

        for ( int i = 0; i < a.length; i++ ) {
            System.out.print(a[i] + " ");
        }
    }

    public static int partition(int a[], int l, int h) {
        int i = l + 1;
        int j = h;
        int c = l;
        int temp;

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

    public static void quickSort(int[] a, int l, int h) {
        int j = 0;
        if ( l < h ) {
            j = partition(a, l, h);
            quickSort(a, l, j - 1);
            quickSort(a,j + 1, h);
        }
    }
}
