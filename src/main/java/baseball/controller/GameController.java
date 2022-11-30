package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

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
        List<Integer> gameResult;
        do {
            int userNumber = inputView.readNumber();
            gameResult = baseballGame.getGameResult(userNumber);
            outputView.printResult(gameResult);
        } while (!isGameOver(gameResult));
    }


    // TODO: DTO 정의되면 위임하기
    private boolean isGameOver(List<Integer> gameResult) {
        if (gameResult.get(1) == 3) {
            return true;
        }
        return false;
    }

    private boolean userNeedContinue(int userControl) {
        return userControl == 1;
    }
}
