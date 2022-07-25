package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Converter {

    static Scanner scanner = new Scanner(System.in);
    static int scale = 100;


    private char intToChar(int value) {
        if (value > 9) {
            return ((char) ((value - 10) + 'a'));
        } else {
            return (char) (value + '0');
        }
    }

    public String decimalTo(BigInteger number, int targetBase) {

        BigInteger base = BigInteger.valueOf(targetBase);
        StringBuilder result = new StringBuilder();
        do {

            result.append(intToChar(number.mod(base).intValue()));
            number = number.divide(base);

        } while (number.compareTo(base) >= 0);

        int remainder = number.mod(base).intValue();
        if (remainder != 0) {
            result.append(intToChar(remainder));
        }
        result.reverse();

        return result.toString();
    }

    public String decimalFractionTo(BigDecimal fraction, int targetBase) {

        BigDecimal base = BigDecimal.valueOf(targetBase);
        StringBuilder result = new StringBuilder();

        do {

            fraction = fraction.multiply(base);

            int integer = fraction.intValue();
            result.append(intToChar(integer));

            fraction = fraction.subtract(BigDecimal.valueOf(integer));

        } while (!fraction.equals(BigDecimal.ZERO) && result.length() < scale);

        return result.toString();
    }

    private int charToInt(char value) {
        if (value >= '0' && value <= '9') {
            return (int) (value - '0');
        } else {
            return (int) (value - 'a' + 10);
        }
    }

    public BigInteger toDecimal(String number, int fromBase) {

        number = number.trim().toLowerCase();
        BigInteger base = BigInteger.valueOf(fromBase);

        BigInteger result = BigInteger.ZERO;
        BigInteger power = BigInteger.ZERO;
        for (int i = number.length() - 1; i >= 0; i--) {
            int num = charToInt(number.charAt(i));

            if (power.equals(BigInteger.ZERO)) {
                result = result.add(BigInteger.valueOf(num));
                power = power.add(base);
            } else {
                result = result.add(BigInteger.valueOf(num).multiply(power));
                power = power.multiply(base);
            }
        }

        return result;
    }

    public BigDecimal toDecimalFraction(String number, int fromBase) {

        number = number.trim().toLowerCase();
        BigDecimal base = BigDecimal.valueOf(fromBase);

        BigDecimal result = BigDecimal.ZERO;
        BigDecimal power = BigDecimal.valueOf(fromBase);
        for (int i = 0; i < number.length(); i++) {
            int num = charToInt(number.charAt(i));

            result = result.add(BigDecimal.valueOf(num).divide(power, scale, RoundingMode.FLOOR));
            power = power.multiply(base);
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

                String result = null;
                if (number.contains(".")) {
                    BigInteger integer = toDecimal(number.substring(0, number.indexOf('.')), sourceBase);
                    BigDecimal fraction = toDecimalFraction(number.substring(number.indexOf('.') + 1), sourceBase);
                    fraction = fraction.setScale(5, RoundingMode.HALF_UP);
                    String resultInteger = decimalTo(integer, targetBase);
                    String resultFraction = decimalFractionTo(fraction, targetBase);
                    resultFraction = resultFraction.substring(0, 5);
                    result = resultInteger + "." + resultFraction;
                } else {
                    BigInteger value = toDecimal(number, sourceBase);
                    result = decimalTo(value, targetBase);
                }

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
