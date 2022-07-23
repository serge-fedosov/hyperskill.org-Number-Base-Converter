package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number in decimal system: ");
        int number = scanner.nextInt();

        System.out.print("Enter target base: ");
        int base = scanner.nextInt();

        StringBuilder result = new StringBuilder();
        do {

            int remainder = number % base;
            if (remainder > 9) {
                result.append((char) ((remainder - 10) + 'A'));
            } else {
                result.append(remainder);
            }

            number = number / base;

        } while (number >= base);

        if (number % base != 0) {
            result.append(number % base);
        }
        result.reverse();

        System.out.println("Conversion result: " + result.toString());
    }
}
