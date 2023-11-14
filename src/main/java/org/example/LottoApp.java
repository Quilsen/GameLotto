package org.example;

import org.example.lottogame.LottoGame;
import org.example.lottogame.calculator.HitCounter;
import org.example.lottogame.input.InputProvider;
import org.example.lottogame.output.ConsolePrinter;
import org.example.lottogame.random.RandomGenerator;

import java.util.Scanner;

public class LottoApp {
    public static void main(String[] args) {
        LottoGame lottoGame = getLottoGame();
        lottoGame.run();
    }

    private static LottoGame getLottoGame() {
        HitCounter hitCounter = new HitCounter();
        InputProvider inputProvider = new InputProvider();
        ConsolePrinter consolePrinter = new ConsolePrinter();
        RandomGenerator randomGenerator = new RandomGenerator();
        Scanner scanner = new Scanner(System.in);
        return new LottoGame(inputProvider, hitCounter, randomGenerator, consolePrinter, scanner);
    }
}
