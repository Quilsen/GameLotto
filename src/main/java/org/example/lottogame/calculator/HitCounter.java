package org.example.lottogame.calculator;

import java.util.Set;

public class HitCounter {

    public int getHitCount(Set<Integer> userNumbers, Set<Integer> randomNumbers) {
        int hitCount = 0;
        for (Integer randomNumber : randomNumbers) {
            for (Integer userNumber : userNumbers) {
                if (randomNumber.equals(userNumber))
                    hitCount++;
            }
        }
        return hitCount;
    }
}
