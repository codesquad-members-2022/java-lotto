package model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import utils.InputValidator;
import view.InputView;

public class ManualLottoMakerTest {
    ManualLottoMaker manualLottoMaker;
    Scanner sc;


    @BeforeEach
    void init() {
        manualLottoMaker = new ManualLottoMaker();
    }

    @DisplayName("사용자 매뉴얼 로또 입력 1개 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void test_input(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        sc = new Scanner(System.in);
        InputView.setSc(sc);

        List<Integer> lotto = manualLottoMaker.createLotto();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(list.containsAll(lotto)).isTrue();
    }

    @DisplayName("6개 입력이 아니면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6, 7", "1, 2, 3, 4", "1, 2, 3, 4, 5, "})
    void exception(String input) {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            InputValidator.validateNumberOfLotto(input);
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 적합하지 않은 갯수입니다. 6개를 입력하세요.");
    }

    @DisplayName("사용자 매뉴얼 로또 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6\n", "7, 8, 9, 10, 11, 12"})
    void test(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        sc = new Scanner(System.in);
        InputView.setSc(sc);

        List<Integer> lotto = manualLottoMaker.createLotto();
        assertThat(lotto.size()).isEqualTo(6);
    }


    @DisplayName("method source 활용 테스트")
    @ParameterizedTest
    @MethodSource("provideContinuousInput")
    void usingMethodSource(String input) {
        InputStream in = createInputStream(input);
        System.setIn(in);
        sc = new Scanner(System.in);
        InputView.setSc(sc);

        List<Integer> lotto = manualLottoMaker.createLotto();
        assertThat(lotto.size()).isEqualTo(6);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private static Stream<Arguments> provideContinuousInput() {
        return Stream.of(
            Arguments.of("1, 2, 3, 4, 5, 6\n"),
            Arguments.of("7, 8, 9, 10, 11, 12\n"),
            Arguments.of("1, 4, 7, 9, 12, 14\n")
        );
    }

    private InputStream createInputStream(String nameInput) {
        List<InputStream> streams = Collections.singletonList(
            generateUserInput(nameInput));
        return new SequenceInputStream(Collections.enumeration(streams));
    }
}
