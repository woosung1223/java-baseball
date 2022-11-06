package baseball.view;

import baseball.view.OutputMsgContainer;

import java.util.List;

public final class OutputMsgGenerator {
    private OutputMsgGenerator() {}
    public static String generate(List<Integer> code) {
        if (code.get(0) == 0 && code.get(1) == 0) {
            return OutputMsgContainer.NOTHING;
        }
        StringBuilder result = new StringBuilder();
        if (code.get(0) != 0) {
            result.append(code.get(0));
            result.append(OutputMsgContainer.BALL);
            result.append(OutputMsgContainer.SPACE);
        }
        result.append(code.get(1));
        result.append(OutputMsgContainer.STRIKE);
        return result.toString();
    }
}
