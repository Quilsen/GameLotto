package org.example;

import org.example.calculator.HitCounter;
import org.example.input.InputProvider;
import org.example.output.ConsolePrinter;
import org.example.random.RandomGenerator;

import java.util.Random;
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
        LottoGame lottoGame = new LottoGame(inputProvider, hitCounter, randomGenerator, consolePrinter, scanner);
        return lottoGame;
    }
}
