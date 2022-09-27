import ru.netology.taxsystem.TaxSystemUsn;
import java.util.Scanner;

public class Main {

    public static void mainMenu () {
        System.out.println("Выберите операцию и введите её номер:");
        System.out.println("1. Добавить новый доход");
        System.out.println("2. Добавить новый расход");
        System.out.println("3. Выбрать ситему налогооблажения");
        System.out.println("//Для завершения введите 'end'");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean next = true;

        int incomeSum = 0;
        int spendingSum = 0;

        while (next) {

            mainMenu();
            String input = scanner.next();

            switch (input) {
                case "end":
                    System.out.println("Программа завершена! До свидания!");
                    next = false;
                    break;
                case "1":
                    System.out.println("Введите сумму дохода:");
                    int income = scanner.nextInt();
                    System.out.println();
                    incomeSum += income;
                    break;
                case "2":
                    System.out.println("Введите сумму расхода:");
                    int spending = scanner.nextInt();
                    spendingSum += spending;
                    System.out.println();
                    break;
                case "3":
                    int taxUsnIncome = TaxSystemUsn.usnIncome(incomeSum);
                    int taxUsnIncMinSpend = TaxSystemUsn.usnIncomeMinusSpending(incomeSum, spendingSum);
                    if (taxUsnIncome == taxUsnIncMinSpend) {
                        System.out.println("Можно выбрать любую систему налогоблажения. Налог по ним одинаковый");
                        System.out.println("Ваш налог составит: " + taxUsnIncome + " руб.");
                    } else {
                        TaxSystemUsn.bestTaxUsnSystem(taxUsnIncome, taxUsnIncMinSpend);
                    }

                    boolean exit = false;
                    while (!exit) {
                        System.out.println();
                        System.out.println("Введите номер операции:");
                        System.out.println("1. Продолжить текущий расчет");
                        System.out.println("2. Начать новый расчет");
                        System.out.println("//Для завершения введите 'end'");

                        String n = scanner.next();
                        switch (n) {
                            case "1":
                                exit = true;
                                break;
                            case "2":
                                incomeSum = 0;
                                spendingSum = 0;
                                exit = true;
                                break;
                            case "end":
                                System.out.println("Программа завершена! До свидания!");
                                next = false;
                                exit = true;
                                break;
                            default:
                                System.out.println("!!!Неверная команда. Попробуйте снова!!!");
                         }
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("!!!Введена неверная команда. Попробуйте снова!!!");
                    System.out.println();

            }

        }

    }
}
