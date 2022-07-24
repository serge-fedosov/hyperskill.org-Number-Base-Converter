import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal bigDecimal1 = new BigDecimal(scanner.nextLine().trim());
        BigDecimal bigDecimal2 = new BigDecimal(scanner.nextLine().trim());

        System.out.println(bigDecimal1.multiply(bigDecimal2));
    }
}