package baseball;

import baseball.controller.GameController;
import baseball.domain.BaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new GameController(new BaseballGame()).startGame();
    }
}
