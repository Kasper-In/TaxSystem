package ru.netology.taxsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TaxSystemUsnTest {

    @DisplayName("Проверка подсчета налога на доходы")
    @ParameterizedTest
    @MethodSource("getArgumentsTaxIncomeSystem")
    void usnIncome(int income, int taxUsn) {
        Assertions.assertEquals(taxUsn, TaxSystemUsn.usnIncome(income));
    }

    @DisplayName("Проверка подсчета налога на доходы минус расходы")
    @ParameterizedTest
    @MethodSource("getArgumentsTaxIncomeMinusSpendingSystem")
    void usnIncomeMinusSpending(int income, int spending, int taxUsn) {
        Assertions.assertEquals(taxUsn, TaxSystemUsn.usnIncomeMinusSpending(income, spending));
    }

    @DisplayName("Проверка более выгодного налога")
    @ParameterizedTest
    @MethodSource("getArgumentsTaxBest")
    void bestTax(int usnIncome, int usnIncomeMinusSpending, int bestTax) {
        Assertions.assertEquals(bestTax, TaxSystemUsn.bestTax(usnIncome, usnIncomeMinusSpending));
    }

    @DisplayName("Проверка менее выгодного налога")
    @ParameterizedTest
    @MethodSource("getArgumentsTaxWorst")
    void worDstTax(int usnIncome, int usnIncomeMinusSpending, int worstTax) {
        Assertions.assertEquals(worstTax, TaxSystemUsn.worstTax(usnIncome, usnIncomeMinusSpending));
    }

    private static Stream<Arguments> getArgumentsTaxIncomeSystem(){
        return Stream.of(
                Arguments.of(1000, 60),
                Arguments.of(553, 33),
                Arguments.of(0, 0)
        );
    }

    private static Stream<Arguments> getArgumentsTaxIncomeMinusSpendingSystem(){
        return Stream.of(
                Arguments.of(1000, 600, 60),
                Arguments.of(553, 700, 0),
                Arguments.of(100, 100, 0),
                Arguments.of(846, 800, 6)
        );
    }

    private static Stream<Arguments> getArgumentsTaxBest(){
        return Stream.of(
                Arguments.of(1000, 2000, 1000),
                Arguments.of(26, 15, 15),
                Arguments.of(100, 100, 100)
                );
    }

    private static Stream<Arguments> getArgumentsTaxWorst(){
        return Stream.of(
                Arguments.of(1000, 2000, 2000),
                Arguments.of(26, 15, 26),
                Arguments.of(100, 100, 100)
        );
    }
}