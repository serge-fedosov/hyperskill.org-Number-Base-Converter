import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal startingAmount = new BigDecimal(scanner.nextLine().trim());
        BigDecimal yearlyPercent = new BigDecimal(scanner.nextLine().trim());
        int years = Integer.parseInt(scanner.nextLine());

        BigDecimal finalAmount = yearlyPercent.divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE)
                .pow(years).multiply(startingAmount).setScale(2, RoundingMode.CEILING);

        System.out.println("Amount of money in the account: " + finalAmount);
    }
}