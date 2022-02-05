package lotto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static lotto.LottoConfig.MIN_ZAKRES;
import static lotto.LottoConfig.NUMBERS_IN_DRAW;
import static lotto.LottoMessageProvider.JESZCZE_RAZ;
import static lotto.LottoMessageProvider.WYBRALES_LICZBY;

public class PlayerNumbersProvider extends NumbersGameSetAbstract{

    private static Set<Integer> playerChoicesSet = new HashSet<>();

    protected static void readNumbersFromPlayer(Scanner scanner) {
        int digit;
        while (playerChoicesSet.size() < NUMBERS_IN_DRAW) {
            digit = scanner.nextInt();
            if (digit < MIN_ZAKRES || digit > LottoConfig.MAX_ZAKRES) {
                System.out.println(JESZCZE_RAZ);
            } else {
                playerChoicesSet.add(digit);
            }
        }
        System.out.println(WYBRALES_LICZBY + printSet(playerChoicesSet));
    }
}
