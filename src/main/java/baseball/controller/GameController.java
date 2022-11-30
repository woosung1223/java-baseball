package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.GameResultDTO;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private BaseballGame baseballGame = new BaseballGame(); // TODO: DI 활용
    private InputView inputView = new InputView(); // TODO: DI 활용
    private OutputView outputView = new OutputView(); // TODO: DI 활용

    private final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public void startGame() {
        System.out.println(GAME_START_MESSAGE);
        startGameLoop();
    }

    private void startGameLoop() {
        int userControl;
        do {
            baseballGame.initAnswer();
            doOneGame();
            userControl = inputView.readControl();
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

    private boolean userNeedContinue(int userControl) {
        return userControl == 1;
    }
}
