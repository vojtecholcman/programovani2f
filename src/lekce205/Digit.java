class Digit {
    public static int reverse(int number) {
        boolean negative;
        if (number < 0) {
            negative = true;
        } else {
            negative = false;
        }
        long n = Math.abs((long) number);
        long result = 0;
        while (n != 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        if (negative) {
            return (int) -result;
        } else {
            return (int) result;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(10005));
        System.out.println(reverse(-123));
        System.out.println(reverse(-10005));
    }
}