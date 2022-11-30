package baseball.domain;

public class BaseballGame {
    private BaseballNumber answer;
    private final int GAME_DIGIT = 3;

    public void initializeGame() {
        RandomNumGenerator randomNumGenerator = new RandomNumGenerator();
        answer = new BaseballNumber(randomNumGenerator.makeDistinctRandomNDigitNumber(GAME_DIGIT));
    }
}
