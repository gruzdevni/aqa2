package ru.netology.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @Test
    void shouldReturn0IfAmount1000() {
        int actual = CashbackHackService.remain(1000);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/DataForTests.csv", numLinesToSkip = 1)
    void shouldReturnCorrectFigureIfAmountMoreThanZero(int amount, int expected, String message) {
        int actual = CashbackHackService.remain(amount);
        assertEquals(expected, actual, message);
    }

    @Test
    void shouldThrowExceptionIfAmountLessThanZero() {
        boolean thrown = false;
        try {
            CashbackHackService.remain(-100);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}