/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

/**
 *
 * @author vojtech.holcman.s
 */
public class Eratosthenes {

    public static void main(String[] args) {
        int size = 1000;
        Eratosthenes era = new Eratosthenes(size);
        int c = 0;

        for (int i = 0; i < size; i++) {
            if (era.isPrime(i)) {
                c++;
            }
        }

        System.out.println(c);
    }

    private final boolean[] sieve;

    public Eratosthenes(int size) {
        sieve = new boolean[size];

        if (size == 0) {
            return;
        }
        sieve[0] = true;

        if (size == 1) {
            return;
        }
        sieve[1] = true;

        int max = (int) Math.sqrt(size);

        for (int i = 2; i <= max; i++) {
            if (!sieve[i]) {
                for (int j = i * i; j < size; j += i) {
                    sieve[j] = true;
                }
            }
        }
    }

    public boolean isPrime(int n) {
        if (n < 0 || n >= sieve.length) {
            throw new IllegalArgumentException();
        }
        return !sieve[n];
    }
}
