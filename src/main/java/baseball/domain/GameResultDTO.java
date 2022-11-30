package baseball.domain;

import java.util.List;

public class GameResultDTO {
    private final List<Integer> gameResult;
    private final boolean isGameOver;

    public GameResultDTO(List<Integer> gameResult, boolean isGameOver) {
        this.gameResult = gameResult;
        this.isGameOver = isGameOver;
    }

    public List<Integer> getGameResult() {
        return gameResult;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
