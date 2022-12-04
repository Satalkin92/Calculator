import java.io.*;
import java.util.Scanner;

public class Main {
   public static void main (String[] args) throws IOException {
        System.out.println("Введите выражение:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Calc.calc(input);
    }
}
