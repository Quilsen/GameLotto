package org.example.lottogame.input;

import org.example.lottogame.output.ConsolePrinter;

import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import static org.example.lottogame.LottoGame.*;
import static org.example.lottogame.message.MessageProvider.*;

public class InputProvider {

    public Set<Integer> getUserNumbers(Scanner scanner, ConsolePrinter consolePrinter) {
        Set<Integer> userNumbers = new LinkedHashSet<>();
        consolePrinter.printLine(String.format(PROVIDE_NUMBERS, LOTTO_NR_COUNT, LOWER_BOUND, UPPER_BOUND));
        while (userNumbers.size() < LOTTO_NR_COUNT) {
            getValidatedUserNumber(scanner, consolePrinter, userNumbers);
        }
        scanner.close();
        return userNumbers;
    }

    private void getValidatedUserNumber(Scanner scanner, ConsolePrinter consolePrinter, Set<Integer> userNumbers) {
        consolePrinter.printLine(String.format(READ_NUMER, userNumbers.size() + 1));
        try {
            int userNumber = getInt(scanner);
            validateNumber(consolePrinter, userNumber, userNumbers);
        } catch (InputMismatchException e) {
            consolePrinter.printLine(EXCEPITON_INFO);
        }
    }

    private void validateNumber(ConsolePrinter consolePrinter, int userNumber, Set<Integer> userNumbers) {
        if (userNumber >= LOWER_BOUND && userNumber <= UPPER_BOUND) {
            userNumbers.add(userNumber);
        } else {
            consolePrinter.printLine(String.format(INVALID_NUMBER, LOWER_BOUND, UPPER_BOUND));
        }
    }

    private int getInt(Scanner scanner) {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }
}
