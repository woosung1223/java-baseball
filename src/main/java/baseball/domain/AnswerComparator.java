package baseball.domain;

import java.util.List;

public class AnswerComparator {
    public List<Integer> getScore(BaseballNumber userNumber, BaseballNumber answer) {
        return List.of(getBallCount(userNumber, answer), getStrikeCount(userNumber, answer));
    }

    private int getBallCount(BaseballNumber userNumber, BaseballNumber answer) {
        return userNumber.countDifferentDigit(answer);
    }

    private int getStrikeCount(BaseballNumber userNumber, BaseballNumber answer) {
        return userNumber.countSameDigit(answer);
    }
}
