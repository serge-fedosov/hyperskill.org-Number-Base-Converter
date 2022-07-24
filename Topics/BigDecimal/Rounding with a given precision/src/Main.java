import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal number = new BigDecimal(scanner.nextLine().trim());
        int newScale = scanner.nextInt();

        number = number.setScale(newScale, RoundingMode.HALF_DOWN);
        System.out.println(number);
    }   
}