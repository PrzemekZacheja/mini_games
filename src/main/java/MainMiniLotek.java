import java.util.Random;
import java.util.Scanner;

public class MainMiniLotek {

    static int[] playerChoices = new int[6];
    static int[] randomsNumbers = new int[6];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        readNumbersFromPlayer(scanner);

        System.out.println("wybrałeś liczby: " + printTable(playerChoices));

        generateRandomNumber1To99(randomsNumbers);
        System.out.println("Wylosowane liczby to: " + printTable(randomsNumbers));

        System.out.println("Sprawdzam czy wygrałeś: ... ");

        System.out.println(isWinTheGame(playerChoices, randomsNumbers) ? "Gratulacje" : "Spróbuj jeszcze raz");
    }

    private static boolean isWinTheGame(int[] playerChoices, int[] randomsNumbers) {
        for (int playerChoice : playerChoices) {
            for (int randomsNumber : randomsNumbers) {
                if (playerChoice != randomsNumber) return false;
            }
        }
        return true;
    }


    private static void generateRandomNumber1To99(int[] randomsNumbers) {
        Random rand = new Random();

        for (int i = 0; i < randomsNumbers.length; i++) {
            int checkDigit = rand.nextInt(99) + 1;
            while (isTheNumberExistInTable(checkDigit, randomsNumbers)) {
                checkDigit = rand.nextInt(99) + 1;
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
                if (digit < 1 || digit > 99) {
                    System.out.println("liczba z poza zakresu 1-99, spróbuj jeszcze raz");
                } else {
                    if (isTheNumberExistInTable(digit, playerChoices)) {
                        System.out.println("Już wybrałeś tą liczbę, wybierz inną");
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
            if (digit == playerChoice) return true;
        }
        return false;
    }
}
