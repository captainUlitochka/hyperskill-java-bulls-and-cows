package bullscows;

import java.util.Scanner;

public class Game {
    String number;
    int turn = 1;
    Number secret;

    Scanner scanner = new Scanner(System.in);

    public void startGame() {

        System.out.println("Please, enter the secret code's length:");
        int length = scanner.nextInt();
        if (length > 0 && length < 10) {
            setSecretNumber(length);
            System.out.println("Okay, let's start a game!");
        } else {
            System.out.println("Error: can't generate a secret number with a " +
                            "length of 11 because there aren't enough unique digits.");
        }
    }

    private void setSecretNumber(int length) {
        secret = new Number(length);
    }

    private String compareNumber() {
        System.out.println("Turn " + turn);
        number = scanner.next();
        return secret.getGrade(number).toString();
    }

    private boolean checkWin() {
        return secret.getGrade(number).getBulls() == number.length();
    }

    public void showGradeResult() {
        do {
            System.out.println(compareNumber());
            turn++;
        } while (!checkWin());
        System.out.println("Congratulations! You guessed the secret code.");
    }
}
