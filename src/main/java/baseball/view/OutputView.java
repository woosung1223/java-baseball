package baseball.view;

import baseball.domain.GameResultDTO;

import java.util.List;

public class OutputView {
    private final String BALL_MESSAGE = "볼";
    private final String STRIKE_MESSAGE = "스트라이크";
    private final String NOTHING_MESSAGE = "낫싱";
    private final String DELIMITER = " ";
    private final String EMPTY_STRING = "";

    public void printResult(GameResultDTO gameResult) {
        printResultMessage(gameResult);
    }

    private void printResultMessage(GameResultDTO gameResult) {
        String ballMessage = makeBallCountIfExists(gameResult.getGameResult().get(0));
        String strikeMessage = makeStrikeCountIfExists(gameResult.getGameResult().get(1));

        if (ballMessage.isEmpty() && strikeMessage.isEmpty()) {
            printNothing();
            return;
        }
        System.out.println(ballMessage + DELIMITER + strikeMessage);
    }

    private String makeBallCountIfExists(int ball) {
        if (ball > 0) {
            return ball + BALL_MESSAGE;
        }
        return EMPTY_STRING;
    }

    private String makeStrikeCountIfExists(int strike) {
        if (strike > 0) {
            return strike + STRIKE_MESSAGE;
        }
        return EMPTY_STRING;
    }

    private void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }
}
