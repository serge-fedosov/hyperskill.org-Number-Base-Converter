import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger m = new BigInteger(scanner.nextLine());

        if (BigInteger.ZERO.equals(m) || BigInteger.ONE.equals(m)) {
            System.out.println(0);
            return;
        }

        BigInteger fact = BigInteger.TWO;
        long n = 2;
        while (true) {
            if (fact.compareTo(m) != -1) {
                System.out.println(n);
                return;
            }

            n++;
            fact = fact.multiply(BigInteger.valueOf(n));
        }

    }
}