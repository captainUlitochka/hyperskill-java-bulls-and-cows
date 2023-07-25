package bullscows;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final char[] CODE = {'9', '3', '0', '5'}; // This value should be like this in the 2nd stage
    private static int bulls = 0;
    private static int cows = 0;

    public static void main(String[] args) {
        askForLength();
       // print();
    }

    private static void print() {
        Scanner scanner = new Scanner(System.in);
        char[] number = scanner.nextLine().toCharArray();

        grade(number);

        if (bulls > 0) {
            cows = cows - bulls;
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.\n", bulls, cows, String.valueOf(CODE));
        } else {
            System.out.printf("Grade: %d cow(s). The secret code is %s.\n", cows, String.valueOf(CODE));
        }
    }

    private static void grade(char[] number) {
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
    }

    private static void askForLength() {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        if (length > 0 && length < 10) {
            System.out.println("The random secret number is " + generate(length));
        } else {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        }
    }

    private static String generate(int length) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        while (list.get(0) == 0) {
            Collections.shuffle(list);
        }

        return list.stream().limit(length).map(String::valueOf).collect(Collectors.joining(""));
    }

}