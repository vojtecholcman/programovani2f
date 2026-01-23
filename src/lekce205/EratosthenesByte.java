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
public class EratosthenesByte {

    public static void main(String[] args) {
        int size = 1000000000;
        EratosthenesByte era = new EratosthenesByte(size);
        int c = 0;

        for (int i = 0; i < size; i++) {
            if (era.isPrime(i)) {
                c++;
            }
        }

        System.out.println(c);
    }

    private final byte[] sieve;
    private final int size;

    public EratosthenesByte(int size) {
        this.size = size;
        sieve = new byte[(size + 7) / 8];

        if (size == 0) {
            return;
        }

        sieve[0] = 0b00000011;

        int max = (int) Math.sqrt(size);
        for (int i = 2; i <= max; i++) {
            if (isPrime(i)) {
                for (int j = i * i; j < size; j += i) {
                    sieve[j / 8] |= (1 << (j % 8));
                }
            }
        }
    }

    public boolean isPrime(int n) {
        if (n < 0 || n >= size) {
            throw new IllegalArgumentException();
        }
        return (sieve[n / 8] & (1 << (n % 8))) == 0;
    }
}
