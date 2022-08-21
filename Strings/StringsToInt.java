package Leetcode.Strings;

public class StringsToInt {
    public static void main(String[] args) {
        StringsToInt s = new StringsToInt();
        System.out.println(s.myAtoi("9223372036854775808"));
    }
    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                startIndex = i;
                break;
            }
        } 

        boolean isPositive = true;
        char ch = s.charAt(startIndex);
        if (ch == '+' || ch == '-') {
            if (ch == '-') isPositive = false;
            startIndex++;
        }
 
        double result = 0;
        for (int i = startIndex; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int charVal = Character.getNumericValue(c);
                result *= 10;
                result += charVal;
            } else {
                break;
            }   
        }
        System.out.println(result);
        if (!isPositive) {
            result = result * -1;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}