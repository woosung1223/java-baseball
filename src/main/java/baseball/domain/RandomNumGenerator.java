package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumGenerator {
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;

    public List<Integer> makeDistinctRandomNDigitNumber(int digit) {
        List<Integer> distinctRandomNDigitNumber;
        do {
            distinctRandomNDigitNumber = makeRandomNDigitNumber(digit);
        } while (isNotDistinct(distinctRandomNDigitNumber));
        return distinctRandomNDigitNumber;
    }

    private List<Integer> makeRandomNDigitNumber(int digit) {
        List<Integer> randomNDigitNumber = new ArrayList<>();
        for (int i = 0; i < digit; i++) {
            randomNDigitNumber.add(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return randomNDigitNumber;
    }

    private boolean isNotDistinct(List<Integer> randomNumbers) {
        int distinctCount = (int) randomNumbers
                .stream()
                .distinct()
                .count();

        return distinctCount != randomNumbers.size();
    }
}
