package com.kmsoft.service;

import java.util.Random;

public class ArrayPractice {
    static int[] chiffres = new int[] {100, 5, 10, 75, 8, 7};
    static String[] signes = new String[] {"+", "-", "*", "/"};
    static int totalToFound = 465;

    public static void main(String[] args) {
        int j = 0;
        int[] newchiffre = new int[6];
        add(newchiffre);
        System.out.println("\n");
        for (int i = 0; i < newchiffre.length; i++) {
            System.out.print(newchiffre[i] + " ");

        }
    }

    private static void add(int[] newchiffre) {
        for (int i = 0; i < newchiffre.length; i++) {
            int val = chiffres[getIndex(0, chiffres.length - 1)];
            if (!contains(newchiffre, val)) {
                if (newchiffre[i] == 0) {
                    newchiffre[i] = val;
                }
            }
        }

        if (contains(newchiffre, 0)) {
            add(newchiffre);
        }

    }

    private static boolean contains(int[] newchiffre, int val) {
        for (int i = 0; i < newchiffre.length; i++) {
            if ((newchiffre[i] == val)) {
                return true;
            }
        }
        return false;

    }

    public static int getIndex(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static int getcombination(int k, int n) {
        if (k == n)
            return 1;
        if (k > n / 2)
            k = n - k;
        int res = n - k + 1;

        for (int i = 2; i <= k; i++) {
            res = res * (n - k + i) / i;
        }
        return res;

    }

}