package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballGame {
    private BaseballNumber answer;
    private final int GAME_DIGIT = 3;

    public void initAnswer() {
        RandomNumGenerator randomNumGenerator = new RandomNumGenerator();
        answer = new BaseballNumber(randomNumGenerator.makeDistinctRandomNDigitNumber(GAME_DIGIT));
    }
    
    public GameResultDTO getGameResult(int userInput) {
        BaseballNumber userNumber = new BaseballNumber(makeIntegerToList(userInput));
        AnswerComparator answerComparator = new AnswerComparator();

        List<Integer> userScore = answerComparator.getScore(userNumber, answer);
        return new GameResultDTO(userScore, isGameOver(userScore));
    }

    private List<Integer> makeIntegerToList(int target) {
        List<Integer> result = new ArrayList<>();
        while (target > 0) {
            result.add(target % 10);
            target /= 10;
        }
        Collections.reverse(result);
        return result;
    }

    private boolean isGameOver(List<Integer> score) {
        if (score.get(1) == 3) {
            return true;
        }
        return false;
    }
}
