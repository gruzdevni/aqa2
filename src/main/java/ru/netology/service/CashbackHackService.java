package ru.netology.service;

public class CashbackHackService {
    private static final int boundary = 1000;

    public static int remain(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        }

        boolean isNeedMore = amount % boundary != 0;
        if (!isNeedMore) {
            return 0;
        }

        int remain = boundary - amount % boundary;
        return remain;
    }
}