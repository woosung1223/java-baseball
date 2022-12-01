package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.GameControl;
import baseball.domain.GameResultDTO;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private BaseballGame baseballGame;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public GameController(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    public void startGame() {
        System.out.println(GAME_START_MESSAGE);
        startGameLoop();
    }

    private void startGameLoop() {
        GameControl userControl;
        do {
            baseballGame.initAnswer();
            doOneGame();
            userControl = GameControl.of(inputView.readControl());
        } while (userNeedContinue(userControl));
    }

    private void doOneGame() {
        GameResultDTO gameResult;
        do {
            int userNumber = inputView.readNumber();
            gameResult = baseballGame.getGameResult(userNumber);
            outputView.printResult(gameResult);
        } while (!gameResult.isGameOver());
    }

    private boolean userNeedContinue(GameControl userControl) {
        return userControl.isContinue();
    }
}
