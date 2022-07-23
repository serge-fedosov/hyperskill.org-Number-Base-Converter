package converter;

import java.util.Scanner;

public class Converter {

    static Scanner scanner = new Scanner(System.in);

    public void decimalTo() {

        System.out.print("Enter number in decimal system: ");
        int number = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter target base: ");
        int base = Integer.parseInt(scanner.nextLine().trim());

        StringBuilder result = new StringBuilder();
        do {

            int remainder = number % base;
            if (remainder > 9) {
                result.append((char) ((remainder - 10) + 'a'));
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

    public void toDecimal() {

        System.out.print("Enter source number: ");
        String number = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter source base: ");
        int base = Integer.parseInt(scanner.nextLine().trim());

        int result = 0;
        int power = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            char symbol = number.charAt(i);
            int num = 0;

            if (symbol >= '0' && symbol <= '9') {
                num = (int) (symbol - '0');
            } else {
                num = (int) (symbol - 'a' + 10);
            }

            result += num * Math.pow(base,power);
            power++;
        }

        System.out.println("Conversion to decimal result: " + result);

    }

    public void menu() {

        System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
        String command = scanner.nextLine().trim();

        while (!command.equals("/exit")) {

            switch (command) {
                case "/from":
                    decimalTo();
                    break;
                case "/to":
                    toDecimal();
                    break;
                default:
                    break;
            }

            System.out.println();
            System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
            command = scanner.nextLine().trim();
        }

        scanner.close();
    }

}
