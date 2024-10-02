import measurefunc.calc;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calc calc = new calc();

        double a;
        double b;
        double result;
        boolean error;
        String first_com;
        String second_com;

        while (true) {
            System.out.print("Через пробел введите данную единицу измерения длины, " +
                    "данное значение и желаемую единицу измерения длины. Команда --help для справки\n");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            if (tokens.length == 0) {
                continue;
            }

            first_com = tokens[0];

            if (first_com.equals("--help")) {
                System.out.println("km - километры\nmile - мили\nfoot - футы\nm - метры\nexit - выход");
            } else if (first_com.equals("exit")) {
                System.out.println("Программа завершена.");
                break;
            } else if (tokens.length > 3) {
                System.out.println("Ошибка: слишком много аргументов.");
            } else if (tokens.length < 3) {
                System.out.println("Ошибка: недостаточно аргументов.");
            } else {
                    a = Double.parseDouble(tokens[1]);
                    b = 0;
                    result = 0;
                    error = false;
                    second_com = tokens[2];

                switch (first_com) {
                    case "km" -> b = calc.km_to_m(a);
                    case "mile" -> b = calc.mile_to_m(a);
                    case "foot" -> b = calc.foot_to_m(a);
                    case "m" -> b = a;
                    default -> {
                        error = true;
                        System.out.println("Неизвестная команда.");
                        continue;
                    }
                }
                switch (second_com) {
                    case "km" -> result = calc.m_to_km(b);
                    case "mile" -> result = calc.m_to_mile(b);
                    case "foot" -> result = calc.m_to_foot(b);
                    case "m" -> result = b;
                    default -> {
                        error = true;
                        System.out.println("Неизвестная команда.");
                        continue;
                    }
                }

                if (!error) {
                    System.out.println("Результат: " + a + " " + first_com + " = " + result + " " + second_com);
                }
            }
        }

        scanner.close();

    }
}