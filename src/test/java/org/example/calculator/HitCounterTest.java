package org.example.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HitCounterTest {
    HitCounter hitCounter = new HitCounter();

    @DisplayName("Should return matching number count")
    @ParameterizedTest(name = "For this numbers {0}, hitcount should be {1}")
    @MethodSource("provideTestData")
    void shouldReturnMatchingNumberCount(Set<Integer> userNumbers, int expectedHitCount) {
        //given
        Set<Integer> randomNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        //when
        int hitCount = hitCounter.getHitCount(userNumbers, randomNumbers);
        //then
        assertThat(hitCount).isEqualTo(expectedHitCount);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(1, 12, 13, 14, 15, 16)), 1),
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 13, 14, 15, 16)), 2),
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 14, 15, 16)), 3),
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 15, 16)), 4),
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 16)), 5),
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 6)
        );
    }

}