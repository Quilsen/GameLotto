package org.example.lottogame;

import lombok.AllArgsConstructor;
import org.example.lottogame.calculator.HitCounter;
import org.example.lottogame.input.InputProvider;
import org.example.lottogame.output.ConsolePrinter;
import org.example.lottogame.random.RandomGenerator;

import java.util.Scanner;
import java.util.Set;

import static org.example.lottogame.message.MessageProvider.RESULT_INFO;
import static org.example.lottogame.message.MessageProvider.WELCOME_MSG;

@AllArgsConstructor
public class LottoGame {
    public static final int LOTTO_NR_COUNT = 6;
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 49;

    private InputProvider inputProvider;
    private HitCounter hitCounter;
    private RandomGenerator randomGenerator;
    private ConsolePrinter consolePrinter;
    private Scanner scanner;

    public void run() {
        consolePrinter.printLine(String.format(WELCOME_MSG));
        Set<Integer> userNumbers = inputProvider.getUserNumbers(scanner, consolePrinter);
        Set<Integer> randomNumbers = randomGenerator.getRandomNumbers();
        int hitCount = hitCounter.getHitCount(userNumbers, randomNumbers);
        consolePrinter.printLine(String.format(RESULT_INFO, hitCount, randomNumbers, userNumbers));
    }
}
