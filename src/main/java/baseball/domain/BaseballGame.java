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

    // TODO: DTO 를 반환하도록 재구성한다.
    public List<Integer> getGameResult(int userInput) {
        BaseballNumber userNumber = new BaseballNumber(makeIntegerToList(userInput));
        AnswerComparator answerComparator = new AnswerComparator();

        List<Integer> gameResult = answerComparator.getScore(userNumber, answer);
        return gameResult;
    }

    private List<Integer> makeIntegerToList(int target) {
        List<Integer> result = new ArrayList<>();
        while (target > 0) {
            result.add(target / 10);
            target /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}
