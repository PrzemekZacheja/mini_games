package lotto;

import interfaces.Game;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static lotto.LottoRandomGenerator.generateRandomNumber1To99;
import static lotto.PlayerNumbersProvider.readNumbersFromPlayer;

public class LottoGame implements Game {

    protected static final Set<Integer> playerChoicesSet = new HashSet<>();
    protected static final Set<Integer> randomsNumbersSet = new HashSet<>();
    private final Scanner scanner = new Scanner(System.in);

    public void play() {
        readNumbersFromPlayer(scanner);
        scanner.close();
        generateRandomNumber1To99(randomsNumbersSet);
        LottoGameResultInfo.checkTheWinMessage();
    }









}


