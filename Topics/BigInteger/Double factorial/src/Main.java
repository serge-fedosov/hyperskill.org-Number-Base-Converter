import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        int first = 1;
        if (n % 2 == 0) {
            first++;
        }

        BigInteger fact = BigInteger.ONE;
        for (int i = first; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));

            i++;
        }

        return fact;
    }
}