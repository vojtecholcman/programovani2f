import java.util.Arrays;

class Fibonacci {
    public static void fill(int[] series) {
        for (int i = 0; i < series.length; i++) {
            if (i == 0) {
                series[i] = 0;
            } else if (i == 1) {
                series[i] = 1;
            } else {
                series[i] = series[i - 2] + series[i - 1];
            }
        }
    }

    public static void main(String[] args) {
        int[] fib5 = new int[5];
        int[] fib10 = new int[10];
        fill(fib5);
        fill(fib10);
        System.out.println(Arrays.toString(fib5));
        System.out.println(Arrays.toString(fib10));
    }
}