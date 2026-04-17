
class Primes {

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        int max = (int) Math.sqrt(number);
        for (int i = 2; i <= max; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int findSecondLargestPrimeNumberLessThan(int number) {
        // -------------- zde odstrihnout --------------------------------------
        int hledane = 0;
        for (int i = 0; hledane < number; i++) {
            if (isPrime(hledane) == true && hledane < number) {
                hledane++;

            } else if (isPrime(hledane) == false) {
                hledane++;
            }
        }
        return hledane--;
        // -------------- zde odstrihnout --------------------------------------
    }

    public static void main(String[] args) {
        System.out.println(findSecondLargestPrimeNumberLessThan(2));   // 0
        System.out.println(findSecondLargestPrimeNumberLessThan(10));  // 5
        System.out.println(findSecondLargestPrimeNumberLessThan(100)); // 89
    }
}
