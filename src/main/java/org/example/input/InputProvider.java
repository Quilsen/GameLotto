package org.example.input;

import org.example.output.ConsolePrinter;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import static org.example.LottoGame.*;
import static org.example.message.MessageProvider.*;

public class InputProvider {

    public Set<Integer> getUserNumbers(Scanner scanner, ConsolePrinter consolePrinter) {
        Set<Integer> userNumbers = new LinkedHashSet<>();
        consolePrinter.printLine(String.format(PROVIDE_NUMBERS, LOTTO_NR_COUNT));
        while (userNumbers.size() < LOTTO_NR_COUNT) {
            consolePrinter.printLine(String.format(READ_NUMER, userNumbers.size() + 1));
            int userNumber = getUserNumber(scanner);
            validateNumber(consolePrinter, userNumber, userNumbers);
        }
        scanner.close();
        return userNumbers;
    }

    private int getUserNumber(Scanner scanner) {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    private void validateNumber(ConsolePrinter consolePrinter, int userNumber, Set<Integer> userNumbers) {
        if (userNumber >= LOWER_BOUND && userNumber <= UPPER_BOUND) {
            userNumbers.add(userNumber);
        } else {
            consolePrinter.printLine(String.format(INVALID_NUMBER, LOWER_BOUND, UPPER_BOUND));
        }
    }
}
