package org.example.random;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import static org.example.LottoGame.LOTTO_NR_COUNT;
import static org.example.LottoGame.UPPER_BOUND;

public class RandomGenerator {

    public Set<Integer> getRandomNumbers() {
        Random random = new Random();
        Set<Integer> randomNumbers = new LinkedHashSet<>();
        while (randomNumbers.size() < LOTTO_NR_COUNT) {
            int randomNumber = random.nextInt(UPPER_BOUND + 1);
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }
}
