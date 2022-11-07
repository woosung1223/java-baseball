package baseball.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static baseball.system.SystemConstant.*;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OutputMsgContainerTest extends NsTest {

    @ParameterizedTest
    @MethodSource("parameterProvider")
    void printMessageTest(OutputMsgContainer outputMsg, String expected) {
        OutputMsgContainer.printMessage(outputMsg);
        assertThat(output()).contains(expected);
    }

    private Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(OutputMsgContainer.GAME_START_MESSAGE,
                        "숫자 야구 게임을 시작합니다."),
                Arguments.of(OutputMsgContainer.GAME_END_AND_RESTART_MESSAGE,
                        GAME_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                "게임을 새로 시작하려면 " + GAME_RESTART_CODE +
                                ", 종료하려면 " + GAME_EXIT_CODE + "를 입력하세요."),
                Arguments.of(OutputMsgContainer.GAME_INPUT_MESSAGE,
                        "숫자를 입력해주세요 :"),
                Arguments.of(OutputMsgContainer.BALL,
                        "볼"),
                Arguments.of(OutputMsgContainer.STRIKE,
                        "스트라이크"),
                Arguments.of(OutputMsgContainer.NOTHING,
                        "낫싱")
        );
    }

    @Override
    public void runMain() {
    }
}
