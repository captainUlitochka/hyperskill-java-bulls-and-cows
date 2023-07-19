package bullscows;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int[] CODE = {9, 3, 0, 5}; // This value should be like this in the 2nd stage
    private static final byte NUM_LENGTH = 4;
    private static int bulls = 0;
    private static int cows = 0;

    public static void main(String[] args) {
        grade();
    }

    private static void grade() {
        Scanner scanner = new Scanner(System.in);
        int[] number = new int[NUM_LENGTH];
        String[] input = scanner.nextLine().split("");

        for (int i = 0; i < input.length; i++) {
            number[i] = Integer.parseInt(input[i]);
        }

        // find bulls and cows
        for (int i = 0; i < CODE.length; i++) {
            for (int j = 0; j < number.length; j++) {
                if (CODE[i] == number[j]) {
                    if (i == j) {
                        bulls++;
                    } cows++;
                }
            }
        }

        if (bulls > 0) {
            cows = cows - bulls;
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.\n",bulls,cows, Arrays.toString(CODE).replaceAll("\\[|\\]|,|\\s", ""));
        } else {
            System.out.printf("Grade: %d cow(s). The secret code is %s.\n", cows, Arrays.toString(CODE).replaceAll("\\[|\\]|,|\\s", ""));
        }

}
}