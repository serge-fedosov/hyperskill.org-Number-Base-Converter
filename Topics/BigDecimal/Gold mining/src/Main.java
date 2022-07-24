import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal dwarfDwalin = new BigDecimal(scanner.nextLine().trim());
        BigDecimal dwarfBalin = new BigDecimal(scanner.nextLine().trim());
        BigDecimal dwarfThorin = new BigDecimal(scanner.nextLine().trim());

        System.out.println(dwarfDwalin.add(dwarfBalin).add(dwarfThorin));
    }
}