package lotto;

import java.util.Random;
import java.util.Scanner;

public class LottoGame {

    public static final String JESZCZE_RAZ = "liczba z poza zakresu 1-99, spróbuj jeszcze raz";
    public static final String WYBIERZ_INNA = "Już wybrałeś tą liczbę, wybierz inną";
    public static final String CZY_WYGRALES = "Sprawdzam czy wygrałeś: ... ";
    public static final String WYBRALES_LICZBY = "wybrałeś liczby: ";
    public static final String WYLOSOWANE_LICZBY_TO = "Wylosowane liczby to: ";
    public static final String GRATULACJE = "Gratulacje";
    public static final String SPROBUJ_JESZCZE_RAZ = "Spróbuj jeszcze raz";
    public static final int MAX_DIGIT = 99;
    private static Random rand = new Random();
    private static final int NUMBERS_OFPRANDOMS = 6;

    private static int[] playerChoices = new int[NUMBERS_OFPRANDOMS];
    private static int[] randomsNumbers = new int[NUMBERS_OFPRANDOMS];
    private Scanner scanner = new Scanner(System.in);



    public void play() {
        readNumbersFromPlayer(scanner);

        System.out.println(WYBRALES_LICZBY + printTable(playerChoices));

        generateRandomNumber1To99(randomsNumbers);
        System.out.println(WYLOSOWANE_LICZBY_TO + printTable(randomsNumbers));

        System.out.println(CZY_WYGRALES);

        System.out.println(isWinTheGame(playerChoices, randomsNumbers) ? GRATULACJE : SPROBUJ_JESZCZE_RAZ);
    }



    private static boolean isWinTheGame(int[] playerChoices, int[] randomsNumbers) {
        for (int playerChoice : playerChoices) {
            for (int randomsNumber : randomsNumbers) {
                if (playerChoice != randomsNumber) {
                    return false;
                }
            }
        }
        return true;
    }


    private static void generateRandomNumber1To99(int[] randomsNumbers) {

        for (int i = 0; i < randomsNumbers.length; i++) {
            int checkDigit = rand.nextInt(MAX_DIGIT) + 1;
            while (isTheNumberExistInTable(checkDigit, randomsNumbers)) {
                checkDigit = rand.nextInt(MAX_DIGIT) + 1;
            }
            randomsNumbers[i] = checkDigit;
        }
    }

    private static String printTable(int[] playerChoices) {
        StringBuilder line = new StringBuilder();
        for (int i : playerChoices) {
            line.append(i).append(" ");
        }
        return line.toString();
    }

    private static void readNumbersFromPlayer(Scanner scanner) {
        for (int i = 0; i < 6; i++) {
            int digit = scanner.nextInt();
            while (true) {
                if (digit < 1 || digit > MAX_DIGIT) {
                    System.out.println(JESZCZE_RAZ);
                } else {
                    if (isTheNumberExistInTable(digit, playerChoices)) {
                        System.out.println(WYBIERZ_INNA);
                    } else {
                        playerChoices[i] = digit;
                        break;
                    }
                }
                digit = scanner.nextInt();
            }
        }
    }

    private static boolean isTheNumberExistInTable(int digit, int[] playerChoices) {
        for (int playerChoice : playerChoices) {
            if (digit == playerChoice) {
                return true;
            }
        }
        return false;
    }
}

