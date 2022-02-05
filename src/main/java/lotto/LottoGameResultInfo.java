package lotto;

import static lotto.LottoMessageProvider.*;

class LottoGameResultInfo {

    LottoGameResultInfo() {
    }

    protected static void checkTheWinMessage() {
        System.out.println(CZY_WYGRALES);
        System.out.println(isWinTheGame() ? GRATULACJE : SPROBUJ_JESZCZE_RAZ);
    }

    private static boolean isWinTheGame() {
        for (int playerChoice : LottoGame.playerChoicesSet) {
            for(int randomsNumber: LottoGame.randomsNumbersSet){
                if (playerChoice == randomsNumber) {
                    return true;
                }
            }
        }
        return false;
    }

}
