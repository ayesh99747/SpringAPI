package lk.ayesh.demo.Model;

public class InputValidator {
    public static boolean stringWithNumbers(String input) {
        return (!input.equals("")) && (input != null) && (input.matches("^[0-9]*$"));
    }

    public static boolean stringWithLetters(String input) {
        return (!input.equals("")) && (input != null) && (input.matches("^[a-zA-Z]*$"));
    }

    public static boolean stringWithNumbersAndLetters(String input) {
        return (!input.equals("")) && (input != null) && (input.matches("^[a-zA-Z0-9-]*$"));
    }

    public static boolean integers(int input) {
        return input >= 0;
    }

    public static boolean bigDecimals(double rate) {
        return rate > 0.00;
    }


}
