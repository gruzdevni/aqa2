package ru.netology.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/DataForTests.csv", numLinesToSkip = 1)
    void shouldReturnCorrectFigureIfAmountMoreThanZero(int amount, int expected, String message) {
        int actual = CashbackHackService.remain(amount);
        assertEquals(expected, actual, message);
    }

    @Test
    void shouldThrowExceptionIfAmountLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> CashbackHackService.remain(-100));

        /*Usage of try-catch in tests is not good practice
        boolean thrown = false;
        try {
            ;
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);*/
    }
}