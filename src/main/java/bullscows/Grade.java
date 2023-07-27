package bullscows;

public class Grade {

    private int bulls;
    private int cows;

    public int getBulls() {
        return bulls;
    }

    public void incrementBulls() {
        bulls++;
    }

    public void incrementCows() {
        cows++;
    }

    @Override
    public String toString() {
        if (cows == 0 && bulls > 0) {
            return "Grade: " + bulls + " bull(s).";
        } else if (cows > 0 && bulls == 0) {
            return "Grade: "+ cows + " cow(s).";
        } else if (cows > 0 && bulls > 0) {
            return "Grade: " + bulls + " bull(s) and " + cows + "cow(s).";
        }
        return "None";
    }

}
