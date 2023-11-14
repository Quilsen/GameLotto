package org.example.lottogame.random;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import static org.example.lottogame.LottoGame.LOTTO_NR_COUNT;
import static org.example.lottogame.LottoGame.UPPER_BOUND;

public class RandomGenerator {
    private final Random random = new Random();

    public Set<Integer> getRandomNumbers() {
        Set<Integer> randomNumbers = new LinkedHashSet<>();
        while (randomNumbers.size() < LOTTO_NR_COUNT) {
            int randomNumber = random.nextInt(UPPER_BOUND + 1);
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }
}
