import java.io.IOException;
public class Calc {
    public static void calc(String input) throws IOException {
        String[] str = input.split(" ");
        if (str.length != 3) {
            throw new IOException("Требуется ввести корректное выражение.");
        }
        String[] array = {"I", "II", "III", "VI", "V", "VI", "VII", "VIII", "XI", "X"};
        int a, b;
        boolean c = false;
        boolean d = false;
        for (String i : array) {
            if (i.equals(str[0])) {
                c = true;
                break;
            }
        }
        for (String i : array) {
            if (i.equals(str[2])) {
                d = true;
                break;
            }
        }
        if (c && d) {
            try {
                a = Roman.valueOf(str[0]).ordinal();
                b = Roman.valueOf(str[2]).ordinal();
                int count = operation(a, b, str);
                    try {
                        if(count < 1) {
                            throw new ArrayIndexOutOfBoundsException("Недопустимый результат.");
                        }
                        System.out.println(Roman.values()[count]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new ArrayIndexOutOfBoundsException("Недопустимый результат.");
                    }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Неккоректный ввод.");
            }
        } else {
            try {
                a = Integer.parseInt(str[0]);
                b = Integer.parseInt(str[2]);
                System.out.println(operation(a, b, str));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Неккоректный ввод.");
            }
        }
        if ((a < 1) || (b < 1) || (a > 10) || (b > 10)) {
            throw new IOException("Числa не должны быть меньше 1 либо превышать 10.");
        }
        if ((!str[1].contains("/")) && (!str[1].contains("+")) && (!str[1].contains("*")) && (!str[1].contains("-"))) {
            throw new IOException("Некорректный знак.");
        }
    }
        static int operation(int a, int b, String[] str) {
        int result = 0;
        if (str[1].contains("+")) {
            result = a + b;
        } else if (str[1].contains("-")) {
            result = a - b;
        } else if (str[1].contains("*")) {
            result = a * b;
        } else if (str[1].contains("/")) {
            result = a / b;
        }
        return result;
    }
}

