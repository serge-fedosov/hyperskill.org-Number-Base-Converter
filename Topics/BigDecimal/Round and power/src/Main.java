import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine().trim());
        int scale = Integer.parseInt(scanner.nextLine().trim());
        BigDecimal number = new BigDecimal(scanner.nextLine().trim());

        number = number.setScale(scale, RoundingMode.FLOOR);
        number = number.pow(power);

        System.out.println(number);
    }
}