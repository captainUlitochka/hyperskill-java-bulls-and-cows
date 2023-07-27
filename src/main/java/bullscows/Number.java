package bullscows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Number {
    private final int length;
    private final String value;
    private final int difficulty;

    List<Character> defaultRange = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u','v','w','x','y','z');

    public Number(int length, int difficulty) {
        this.length = length;
        this.difficulty = difficulty;
        // Generating a pseudorandom number

        List<Character> playersRange = new ArrayList<>(defaultRange.subList(0,difficulty));
        Collections.shuffle(playersRange);
        this.value = playersRange.stream().limit(length).map(String::valueOf).collect(Collectors.joining(""));
    }

    public List<Character> getDefaultRange() {
        return defaultRange;
    }

    @Override
    public String toString() {
        return value;
    }

    public Grade getGrade(String usersNumber) {
        Grade grade = new Grade();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < usersNumber.length(); j++) {
                if (value.charAt(i) == usersNumber.charAt(j)) {
                    if (i == j) {
                        grade.incrementBulls();
                    } else {
                        grade.incrementCows();
                    }
                }
            }
        }

        return grade;
    }

}
