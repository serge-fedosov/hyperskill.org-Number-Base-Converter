package converter;

import java.math.BigInteger;
import java.util.Scanner;

public class Converter {

    static Scanner scanner = new Scanner(System.in);

    public String decimalTo(BigInteger number, int targetBase) {

        BigInteger base = BigInteger.valueOf(targetBase);
        StringBuilder result = new StringBuilder();
        do {

            int remainder = number.mod(base).intValue();
            if (remainder > 9) {
                result.append((char) ((remainder - 10) + 'a'));
            } else {
                result.append(remainder);
            }

            number = number.divide(base);

        } while (number.compareTo(base) >= 0);

        int remainder = number.mod(base).intValue();
        if (remainder != 0) {
            if (remainder > 9) {
                result.append((char) ((remainder - 10) + 'a'));
            } else {
                result.append(remainder);
            }
        }
        result.reverse();

        return result.toString();
    }

    public BigInteger toDecimal(String number, int fromBase) {

        number = number.trim().toLowerCase();
        BigInteger base = BigInteger.valueOf(fromBase);

        BigInteger result = BigInteger.ZERO;
        int power = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            char symbol = number.charAt(i);
            int num = 0;

            if (symbol >= '0' && symbol <= '9') {
                num = (int) (symbol - '0');
            } else {
                num = (int) (symbol - 'a' + 10);
            }

            BigInteger bi = BigInteger.valueOf(num);
            for (int j = 1; j <= power; j++) {
                bi = bi.multiply(base);
            }

            result = result.add(bi);
            power++;
        }

        return result;
    }

    public void menu() {

        int sourceBase = 0;
        int targetBase = 0;

        System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
        String command = scanner.nextLine().trim();

        while (!command.equals("/exit")) {

            String[] cmd = command.split("\\s");
            sourceBase = Integer.parseInt(cmd[0]);
            targetBase = Integer.parseInt(cmd[1]);

            while (true) {
                System.out.printf("Enter number in base %d to convert to base %d (To go back type /back) ", sourceBase, targetBase);
                String number = scanner.nextLine().trim();

                if (number.equals("/back")) {
                    break;
                }

                BigInteger value = toDecimal(number, sourceBase);
                String result = decimalTo(value, targetBase);

                System.out.println("Conversion result: " + result);
                System.out.println();
            }

            System.out.println();
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            command = scanner.nextLine().trim();
        }

        scanner.close();
    }

}
