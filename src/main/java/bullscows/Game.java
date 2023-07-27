package bullscows;

import java.util.Scanner;

public class Game {
    String number;
    int turn = 1;
    Number secret;

    Scanner scanner = new Scanner(System.in);

    public void startGame() {
        System.out.println("Input the length of the secret code:");
        int length = 0;
        String inputLength = scanner.nextLine();
        try {
            length = Integer.parseInt(inputLength);
        } catch (Exception e) {
            stopGame("\nError: " + inputLength + " isn't a valid number.\n");
        }

        System.out.println("Input the number of possible symbols in the code:");
        int difficulty = scanner.nextInt();

        int MAX_RANGE = 36;
        if (length > difficulty) {
            stopGame("\nError: it's not possible to generate a code with a length of " +
                    length + " with " + difficulty + " unique symbols.\n");
        } else if (difficulty > MAX_RANGE) {
            stopGame("\nError: maximum number of possible symbols in the code is 36 (0-9, a-z).\n");
        } else if (length <= 0) {
            stopGame("Error: length should be bigger than 0");
        } else {
            setSecretNumber(length, difficulty);
            System.out.printf(
                    "The secret is prepared: %s (%s).\nOkay, let's start a game!\n",
                    maskedNumber(difficulty), availableRange(difficulty));
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

    private void stopGame(String errorMessage) {
        System.out.println(errorMessage);
        System.exit(0);
    }
}