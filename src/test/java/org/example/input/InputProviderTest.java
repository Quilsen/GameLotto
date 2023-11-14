package org.example.input;

import org.example.output.ConsolePrinter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class InputProviderTest {
    InputProvider inputProvider = new InputProvider();
    ConsolePrinter consolePrinter = new ConsolePrinter();

    @DisplayName("Validator and bounds chceck")
    @ParameterizedTest
    @MethodSource("provideTestData")
    void shouldReturnValidatedUserNumbers(String string) {
        //given
        Scanner scannerMock = mockScannerInput(string);
        //when
        Set<Integer> userNumbers = inputProvider.getUserNumbers(scannerMock, consolePrinter);
        //then
        assertThat(userNumbers).contains(1, 2, 3, 4, 5, 6);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("1\n 2\n 3\n 4\n 5\n 6\n"),
                Arguments.of("a\n 1\n b\n 2\n c\n 3\n d\n 4\n e\n 5\n f\n 6\n"),
                Arguments.of("50\n 1\n 51\n 2\n 52\n 3\n 53\n 4\n 54\n 5\n 55\n 6\n")
        );
    }

    private Scanner mockScannerInput(String string) {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream(string.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(inputStream);
        return scanner;
    }

}