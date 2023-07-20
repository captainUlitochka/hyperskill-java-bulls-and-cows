package bullscows;

import java.util.Scanner;

public class Main {

    private static final char[] CODE = {'9', '3', '0', '5'}; // This value should be like this in the 2nd stage
    private static int bulls = 0;
    private static int cows = 0;

    public static void main(String[] args) {
        grade();
    }

    private static void grade() {
        Scanner scanner = new Scanner(System.in);
        char[] number = scanner.nextLine().toCharArray();

        // find bulls and cows
        for (int i = 0; i < CODE.length; i++) {
            for (int j = 0; j < number.length; j++) {
                if (CODE[i] == number[j]) {
                    if (i == j) {
                        bulls++;
                    }
                    cows++;
                }
            }
        }

        if (bulls > 0) {
            cows = cows - bulls;
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.\n", bulls, cows, String.valueOf(CODE));
        } else {
            System.out.printf("Grade: %d cow(s). The secret code is %s.\n", cows, String.valueOf(CODE));
        }

    }
}