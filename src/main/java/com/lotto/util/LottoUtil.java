package com.lotto.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoUtil {
    private static final int NUMBER_OF_LOTTO = 6;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final Random RANDOM = new Random();

    public static Set<Integer> extractRandomLottoNumbers() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < NUMBER_OF_LOTTO) {
            int number = selectNumber();

            if (numbers.contains(number)) {
                continue;
            }

            numbers.add(number);
        }

        return numbers;
    }

    private static int selectNumber() {
        return RANDOM.nextInt(MAXIMUM_LOTTO_NUMBER) + 1;
    }
}
