package baseball.domain;

import java.util.List;

public class BaseballNumber {
    private List<Integer> baseballNumber;

    public BaseballNumber(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public int countDifferentDigit(BaseballNumber other) {
        return (int) baseballNumber.stream()
                .filter(other::contains)
                .filter(i -> baseballNumber.get(i) != other.getNumberAt(i))
                .count();
    }

    public int countSameDigit(BaseballNumber other) {
        return (int) baseballNumber.stream()
                .filter(i -> baseballNumber.get(i) == other.getNumberAt(i))
                .count();
    }

    public int getNumberAt(int index) {
        return baseballNumber.get(index);
    }

    public boolean contains(int element) {
        return baseballNumber.contains(element);
    }
}
