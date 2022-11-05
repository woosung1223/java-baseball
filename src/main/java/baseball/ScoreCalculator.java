package baseball;

import java.util.stream.Stream;

public class ScoreCalculator {
    public static int calculateBallCount(BaseballNumber baseballNum1, BaseballNumber baseballNum2) {
        return (int) Stream.iterate(0, i -> i + 1)
                .limit(SystemConstant.GAME_DIGIT)
                .filter(i -> baseballNum2.contains(baseballNum1.getNumberAt(i)))
                .filter(i -> baseballNum1.getNumberAt(i) != baseballNum2.getNumberAt(i))
                .count();
    }
}
