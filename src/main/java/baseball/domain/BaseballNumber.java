package baseball.domain;

import java.util.List;
import java.util.stream.Stream;

public class BaseballNumber {
    private List<Integer> baseballNumber;

    public BaseballNumber(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public int countDifferentDigit(BaseballNumber other) {
        return (int) Stream.iterate(0, i -> i + 1)
                .limit(baseballNumber.size())
                .filter(i -> other.baseballNumber.contains(baseballNumber.get(i)))
                .filter(i -> !baseballNumber.get(i).equals(other.baseballNumber.get(i)))
                .count();
    }

    public int countSameDigit(BaseballNumber other) {
        return (int) Stream.iterate(0, i -> i + 1)
                .limit(baseballNumber.size())
                .filter(i -> baseballNumber.get(i).equals(other.baseballNumber.get(i)))
                .count();
    }
}
