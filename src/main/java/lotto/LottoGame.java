package lotto;

import java.util.*;

public class LottoGame {

    private static final String JESZCZE_RAZ = "liczba z poza zakresu 1-99, spróbuj jeszcze raz";
    private static final String CZY_WYGRALES = "Sprawdzam czy wygrałeś: ... ";
    private static final String WYBRALES_LICZBY = "wybrałeś liczby: ";
    private static final String WYLOSOWANE_LICZBY_TO = "Wylosowane liczby to: ";
    private static final String GRATULACJE = "Gratulacje";
    private static final String SPROBUJ_JESZCZE_RAZ = "Spróbuj jeszcze raz";
    private static final int MAX_ZAKRES = 99;
    private static final int MIN_ZAKRES = 1;
    private static Random rand = new Random();


    private static Set<Integer> playerChoicesSet = new HashSet<>();
    private static Set<Integer> randomsNumbersSet = new HashSet<>();
    private Scanner scanner = new Scanner(System.in);


    public void play() {
        readNumbersFromPlayer(scanner);
        scanner.close();
        generateRandomNumber1To99(randomsNumbersSet);
        checkTheWinMessage();
    }

    private void checkTheWinMessage() {
        System.out.println(CZY_WYGRALES);
        System.out.println(isWinTheGame(playerChoicesSet, randomsNumbersSet) ? GRATULACJE : SPROBUJ_JESZCZE_RAZ);
    }


    private static boolean isWinTheGame(Set<Integer> playerChoices, Set<Integer> randomsNumbers) {
        for (int playerChoice : playerChoices) {
            for(int randomsNumber: randomsNumbers){
                if (playerChoice == randomsNumber) {
                    return true;
                }
            }
        }
        return false;
    }


    private static void generateRandomNumber1To99(Set<Integer> randomsNumbersSet) {
        while (randomsNumbersSet.size() < 6) {
            int checkDigit = rand.nextInt(MAX_ZAKRES) + MIN_ZAKRES;
            randomsNumbersSet.add(checkDigit);
        }
        System.out.println(WYLOSOWANE_LICZBY_TO + printTable(randomsNumbersSet));
    }

    private static String printTable(Set<Integer> playerChoices) {
        StringBuilder line = new StringBuilder();
        for (int i : playerChoices) {
            line.append(i).append(" ");
        }
        return line.toString();
    }

    private static void readNumbersFromPlayer(Scanner scanner) {
        int digit;
        while (playerChoicesSet.size() < 6) {
            digit = scanner.nextInt();
            if (digit < MIN_ZAKRES || digit > MAX_ZAKRES) {
                System.out.println(JESZCZE_RAZ);
            } else {
                playerChoicesSet.add(digit);
            }
        }
        System.out.println(WYBRALES_LICZBY + printTable(playerChoicesSet));
    }

}


