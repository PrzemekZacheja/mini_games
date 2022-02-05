package lotto;

import java.util.Random;
import java.util.Set;

import static lotto.LottoConfig.MIN_ZAKRES;
import static lotto.LottoConfig.NUMBERS_IN_DRAW;
import static lotto.LottoMessageProvider.WYLOSOWANE_LICZBY_TO;

public class LottoRandomGenerator extends NumbersGameSetAbstract {

    private static Random rand = new Random();

    static void generateRandomNumber1To99(Set<Integer> randomsNumbersSet) {
        while (randomsNumbersSet.size() < NUMBERS_IN_DRAW) {
            int checkDigit = rand.nextInt(LottoConfig.MAX_ZAKRES) + MIN_ZAKRES;
            randomsNumbersSet.add(checkDigit);
        }
        System.out.println(WYLOSOWANE_LICZBY_TO + printSet(randomsNumbersSet));
    }
}
