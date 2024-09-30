import measurefunc.calc;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calc calc = new calc();
        while (true) {
            System.out.print("Через пробел введите данную единицу измерения длины, " +
                    "данное значение и желаемую единицу измерения длины. Команда --help для справки\n");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            if (tokens.length == 0) {
                continue;
            } else if (tokens.length > 3) {
                System.out.println("Ошибка: слишком много аргументов.");
            } else if (tokens.length < 3) {
                System.out.println("Ошибка: недостаточно аргументов.");
            }

            String first_com = tokens[0];
            String second_com = tokens[2];

            if (first_com.equals("--help")) {
                System.out.println("km - километры\nmile - мили\nfoot - футы\nm - метры\nexit - выход");
            } else if (first_com.equals("exit")) {
                System.out.println("Программа завершена.");
                break;
            } else if (tokens.length > 3) {
                System.out.println("Ошибка: слишком много аргументов.");
            } else {
                    double a = Double.parseDouble(tokens[1]);
                    double b = 0;
                    double result = 0;

                switch (first_com) {
                    case "km" -> b = calc.km_to_m(a);
                    case "mile" -> b = calc.mile_to_m(a);
                    case "foot" -> b = calc.foot_to_m(a);
                    case "m" -> b = a;
                    default -> {
                        result = -1;
                        System.out.println("Неизвестная команда.");
                        continue;
                    }
                }
                switch (second_com) {
                    case "km" -> result = calc.m_to_km(b);
                    case "mile" -> result = calc.m_to_mile(b);
                    case "foot" -> result = calc.m_to_foot(b);
                    case "m" -> result = b;
                }

                    System.out.println("Результат: " + a + " " + first_com + " = " + result + " " + second_com);
            }
        }

        scanner.close();

    }
}