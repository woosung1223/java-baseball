package baseball.view;

import java.util.List;

public class OutputView {
    private final String BALL_MESSAGE = "볼 ";
    private final String STRIKE_MESSAGE = "스트라이크";
    private final String NOTHING_MESSAGE = "낫싱";

    public void printResult(List<Integer> gameResult) {
        printBallCountIfExists(gameResult.get(0));
        printStrikeCountIfExists(gameResult.get(1));
        printNothingIfNeeded(gameResult);
    }

    private void printBallCountIfExists(int ball) {
        if (ball > 0) {
            System.out.println(ball + BALL_MESSAGE);
        }
    }

    private void printStrikeCountIfExists(int strike) {
        if (strike > 0) {
            System.out.println(strike + STRIKE_MESSAGE);
        }
    }

    private void printNothingIfNeeded(List<Integer> gameResult) {
        if (gameResult.get(0) == 0 && gameResult.get(1) == 0) {
            System.out.println(NOTHING_MESSAGE);
        }
    }
}
