package org.example;

import org.example.lottoGame.LottoGame;
import org.example.lottoGame.calculator.HitCounter;
import org.example.lottoGame.input.InputProvider;
import org.example.lottoGame.output.ConsolePrinter;
import org.example.lottoGame.random.RandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LottoGameTest {
    private final HitCounter hitCounter = new HitCounter();
    private final Scanner scanner = new Scanner(System.in);
    @Mock
    private InputProvider inputProviderMock;
    @Mock
    private RandomGenerator randomGeneratorMock;
    @Mock
    private ConsolePrinter consolePrinterMock;
    @InjectMocks
    private LottoGame lottoGame = new LottoGame(inputProviderMock, hitCounter, randomGeneratorMock, consolePrinterMock, scanner);
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @DisplayName("Should return correct message")
    @ParameterizedTest(name = "For this numbers {0}, should return this message: {1}")
    @MethodSource("provideTestData")
    void shouldReturnCorrectMessage(Set<Integer> userNumbers, String expectedResultString) {
        //given
        when(inputProviderMock.getUserNumbers(scanner, consolePrinterMock)).thenReturn(userNumbers);
        Set<Integer> randomNumbers = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        when(randomGeneratorMock.getRandomNumbers()).thenReturn(randomNumbers);
        //when
        lottoGame.run();
        //then
        verify(consolePrinterMock, times(2)).printLine(stringArgumentCaptor.capture());
        List<String> allValues = stringArgumentCaptor.getAllValues();
        assertThat(allValues.get(1)).isEqualTo(expectedResultString);

    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new LinkedHashSet<>(Arrays.asList(11, 12, 13, 14, 15, 16)),
                        "You get 0 hits. Winning numbers: [1, 2, 3, 4, 5, 6] vs Your numbers: [11, 12, 13, 14, 15, 16] ."),
                Arguments.of(new LinkedHashSet<>(Arrays.asList(1, 12, 13, 14, 15, 16)),
                        "You get 1 hits. Winning numbers: [1, 2, 3, 4, 5, 6] vs Your numbers: [1, 12, 13, 14, 15, 16] ."),
                Arguments.of(new LinkedHashSet<>(Arrays.asList(1, 2, 13, 14, 15, 16)),
                        "You get 2 hits. Winning numbers: [1, 2, 3, 4, 5, 6] vs Your numbers: [1, 2, 13, 14, 15, 16] ."),
                Arguments.of(new LinkedHashSet<>(Arrays.asList(1, 2, 3, 14, 15, 16)),
                        "You get 3 hits. Winning numbers: [1, 2, 3, 4, 5, 6] vs Your numbers: [1, 2, 3, 14, 15, 16] ."),
                Arguments.of(new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 15, 16)),
                        "You get 4 hits. Winning numbers: [1, 2, 3, 4, 5, 6] vs Your numbers: [1, 2, 3, 4, 15, 16] ."),
                Arguments.of(new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 16)),
                        "You get 5 hits. Winning numbers: [1, 2, 3, 4, 5, 6] vs Your numbers: [1, 2, 3, 4, 5, 16] ."),
                Arguments.of(new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        "You get 6 hits. Winning numbers: [1, 2, 3, 4, 5, 6] vs Your numbers: [1, 2, 3, 4, 5, 6] .")
        );
    }
}