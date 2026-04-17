class Convertor {
    private final char[] digits;

    public Convertor(char[] digits) {
        if (digits.length < 2) {
            throw new IllegalArgumentException();
        }
        this.digits = digits;
    }

    public String convert(int value) {
        if (value == 0) {
            return String.valueOf(digits[0]);
        }
        boolean negative = value < 0;
        long n = Math.abs((long) value);
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, digits[(int)(n % digits.length)]);
            n /= digits.length;
        }
        if (negative) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }

    private static void test(char[] digits, int value, String check) {
        String result = new Convertor(digits).convert(value);
        System.out.println(value + "[" + String.valueOf(digits) + "] = " + result
                + (check.equals(result) ? " OK" : " BAD " + check));
    }

    public static void main(String[] args) {
        test(new char[]{'0', '1'}, 20, "10100");
        test(new char[]{'0', '1', '2', '3', '4', '5', '6', '7'}, 63, "77");
        test(new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}, 1234, "1234");
    }
}