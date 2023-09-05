import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }


    public static String calc(String input) throws Exception {
        int x;
        int y;
        String operator;
        String result;
        boolean isRoman;
        String[] calcInput = input.split("[+\\-*/]");

        if (calcInput.length != 2) {
            throw new Exception("Ошибка ввода");
        };
        operator = whichOperation(input);
        if (operator == null) {
            throw new Exception("Ошибка ввода");
        };

        if (Roman.isRoman(calcInput[0]) && Roman.isRoman(calcInput[1])){
            x = Roman.convertToArabian(calcInput[0]);
            y = Roman.convertToArabian(calcInput[1]);
            isRoman = true;
        }

        else if (!Roman.isRoman(calcInput[0]) && !Roman.isRoman(calcInput[1])){
            x = Integer.parseInt(calcInput[0]);
            y = Integer.parseInt(calcInput[1]);
            isRoman = false;
        }

        else {
            throw new Exception("Нельзя использовать арабские и римские числа одновременно");
        }
        if (x > 10 || x < 1 || y < 1 || y > 10) {
            throw new Exception("Введите числа от 1 до 10");
        }
        int arabian = calc(x, y, operator);
        if (isRoman) {

            if (arabian <= 0) {
                throw new Exception("Римские числа не могут быть отрицательными или равными нулю");
            }
            result = Roman.convertToRoman(arabian);
        } else {

            result = String.valueOf(arabian);
        }

        return result;
    }

    static String whichOperation(String input) {
        if (input.contains("+")) {
            return "+";
        } else if (input.contains("-")){
            return "-";
        } else if (input.contains("*")){
            return "*";
        } else  if (input.contains("/")){
            return "/";
        } else {
            return null;
        }
    }

    static int calc(int a, int b, String operator) {
        if (operator.equals("+")){
            return a + b;
        } else if (operator.equals("-")){
            return a - b;
        } else if (operator.equals("*")){
            return a * b;
        } else {
            return a / b;
        }
    }

    class Roman {
        static String[] romanArray = new String[]{"null","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};

        public static boolean isRoman(String val) {
            for (int i = 0; i < romanArray.length; i++) {
                if (val.equals(romanArray[i])) {
                    return true;
                }
            }
            return false;
        }

        public static int convertToArabian(String roman) {
            for (int i = 0; i < romanArray.length; i++){
                if (roman.equals(romanArray[i])){
                    return i;
                }
            }
            return -1;
        }

        public static String convertToRoman(int arabian){
            return romanArray[arabian];
        }
    }
}