package bullscows;

import java.util.Scanner;

public class Game {
    String number;
    int turn = 1;
    Number secret;

    Scanner scanner = new Scanner(System.in);

    public void startGame() {
        System.out.println("Input the length of the secret code:");
        int length = scanner.nextInt();

        System.out.println("Input the number of possible symbols in the code:");
        int difficulty = scanner.nextInt();

        if (length > 0 && length <= difficulty) {
            setSecretNumber(length, difficulty);
            System.out.printf("The secret is prepared: %s (%s).\nOkay, let's start a game!\n", maskedNumber(difficulty), availableRange(difficulty));
        } else {
            System.out.println("Error: can't generate a secret number with a " +
                            "length of 11 because there aren't enough unique digits.");
        }
    }

    private String maskedNumber(int difficulty) {
        return "*".repeat(difficulty);
    }

    private String availableRange(int difficulty) {
        if (difficulty <= 10) {
            return "0-9";
        } else if (difficulty <= secret.getDefaultRange().size()) {
            return "0-9, a-" + secret.getDefaultRange().get(difficulty - 1); // Вот здесь неправильно вычисляется индекс
        } else return null;
    }

    private void setSecretNumber(int length, int difficulty) {
        secret = new Number(length, difficulty);
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
