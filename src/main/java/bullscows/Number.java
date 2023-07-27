package bullscows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Number {
    private int length;
    private String value;

    public Number(int length) {
        this.length = length;
        // Generating a pseudorandom number
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        while (list.get(0) == 0) {
            Collections.shuffle(list);
        }
        this.value = list.stream().limit(length).map(String::valueOf).collect(Collectors.joining(""));
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
