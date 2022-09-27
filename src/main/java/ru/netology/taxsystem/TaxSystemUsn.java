package ru.netology.taxsystem;

public class TaxSystemUsn {

    public static int usnIncome (int income) {
        return income * 6/100;
    }

    public static int usnIncomeMinusSpending (int income, int spending) {
        return (income - spending) > 0 ? (income - spending) * 15/100 : 0;
    }

    public static int bestTax(int tax1, int tax2) {
        return Math.min(tax1, tax2);
    }

    public static int worstTax(int tax1, int tax2){
            return Math.max(tax1, tax2);
    }

    public static void bestTaxUsnSystem (int taxUsnIncome, int taxUsnIncMinSpend){
        int taxBest = bestTax(taxUsnIncome, taxUsnIncMinSpend);
        int taxWorst = worstTax(taxUsnIncome, taxUsnIncMinSpend);

        if (taxUsnIncome > taxUsnIncMinSpend) {
            System.out.println("Мы советуем вам систему налогоблажения УСН на доходы минус расходы");
        } else {
            System.out.println("Мы советуем вам систему налогоблажения УСН на доходы");
        }
        System.out.println("Ваш налог составит: " + taxBest + " руб.");
        System.out.println("Ваш налог по другой системе: " + taxWorst + " руб.");
        System.out.println("Экономия: " + (taxWorst - taxBest) + " руб.");
    }
}
