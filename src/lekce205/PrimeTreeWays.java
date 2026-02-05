/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

/**
 *
 * @author vojta
 */
public class PrimeTreeWays {

    public static void main(String[] args) {
        if (args.length == 0) {
            runAll(10_000_000);
        } else {
            for (int i = 0; i < args.length; i++) {
                int limit = Integer.parseInt(args[i]);
                runAll(limit);
            }
        }
    }

    private static void runAll(int limit) {
        System.out.println("Počet prvočísel od 2 do " + limit + " stanovených");

        long t0, t1;

        //eratosthenes
        t0 = System.nanoTime();
        int a = EratosthenesWay(limit);
        t1 = System.nanoTime();
        System.out.println("    Eratostenovým sítem: " + a + " za " + (t1 - t0) + " ns");

        //postupne testovano
        t0 = System.nanoTime();
        int b = SimpleWay(limit);
        t1 = System.nanoTime();
        System.out.println("    postupným testováním: " + b + " za " + (t1 - t0) + " ns");

        //vlakna
        int thread = 4;
        t0 = System.nanoTime();
        int c = ThreadsWay(limit, thread);
        t1 = System.nanoTime();
        System.out.println("    rozdělením do vláken: " + c + " za " + (t1 - t0) + " ns");

        //shoda?
        if (a == b && b == c) {
            System.out.println("Všechny tři metody dávají stejné výsledky");
        } else {
            System.out.println("!!! Metody nedávají stejné výsledky !!!");
        }
        System.out.println("");
    }

    public static int EratosthenesWay(int size) {
        if (size < 2) {
            return 0;
        }

        boolean[] sieve = new boolean[size + 1];
        sieve[0] = true;
        sieve[1] = true;

        int max = (int) Math.sqrt(size);

        for (int i = 2; i <= max; i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= size; j += i) {
                    sieve[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= size; i++) {
            if (!sieve[i]) {
                count++;
            }
        }
        return count;
    }

    public static int SimpleWay(int size) {
        int count = 0;

        for (int i = 2; i <= size; i++) {
            boolean prime = true;

            if (i == 2) {
                prime = true;
            } else if (i < 2 || i % 2 == 0) {
                prime = false;
            } else {
                for (int n = 3; n <= Math.sqrt(i); n += 2) {
                    if (i % n == 0) {
                        prime = false;
                        break;
                    }
                }
            }
            if (prime) {
                count++;
            }
        }
        return count;
    }

    public static int ThreadsWay(int limit, int threads) {
        if (limit < 2) {
            return 0;
        }
        if (threads < 1) {
            threads = 1;
        }

        Thread[] t = new Thread[threads];
        int[] partial = new int[threads];

        int from = 2;
        int numbers = limit - from + 1;
        int chunk = numbers / threads;

        for (int k = 0; k < threads; k++) {
            int start = from + k * chunk;
            int end;

            if (k == threads - 1) {
                end = limit;
            } else {
                end = start + chunk - 1;

            }

            final int idx = k;
            final int s = start;
            final int e = end;

            t[k] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int c = 0;

                    for (int x = s; x <= e; x++) {
                        if (isPrimeSimple(x)) {
                            c++;
                        }
                    }

                    partial[idx] = c;
                    System.out.println("    " + s + " - " + e + ": " + c);
                }
            });
            t[k].start();
        }

        for (int k = 0; k < threads; k++) {
            try {
                t[k].join();
            } catch (InterruptedException e) {
                System.out.println("Vláklno bylo přerušeno: " + e);
            }
        }

        int total = 0;
        for (int j = 0; j < threads; j++) {
            total += partial[j];
        }
        return total;
    }

    public static boolean isPrimeSimple(int n) {
        if (n == 2) {
            return true;
        }
        if (n < 2 || n % 2 == 0) {
            return false;
        }
        for (int d = 3; d <= Math.sqrt(n); d += 2) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }

}
