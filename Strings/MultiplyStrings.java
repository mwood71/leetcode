package Leetcode.Strings;

import java.util.LinkedList;
import java.util.List;

public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        System.out.println(m.multiply("123", "456"));
    }
    public String multiply(String num1, String num2) {
        if (num1.isEmpty() || num2.isEmpty() || num1.equals("0") || num2.equals("0")) return "0";

        List<List<Integer>> sums = new LinkedList<>();
        int zerocount = 0;
        for (int i = 0; i < num2.length(); i++) {
            List<Integer> tempList = new LinkedList<>();
            int tempCount = zerocount;
            while (tempCount > 0) {
                tempList.add(0);
                tempCount--;
            }
            zerocount++;
            sums.add(tempList);
        }

        int numIndex = num2.length() - 1;
        int listIndex = 0;
        while (numIndex >= 0) {
            char c = num2.charAt(numIndex);
            int num = Character.getNumericValue(c);
            int remainder = 0;

            for (int i = num1.length()-1; i >= 0; i--) {
                char tempC = num1.charAt(i);
                int tempNum = Character.getNumericValue(tempC);
                int total = remainder + tempNum * num;
                int columnValue = total % 10;
                sums.get(listIndex).add(columnValue);
                total -= columnValue;
                remainder = total/10;
            }

            if (remainder > 0) {
                sums.get(listIndex).add(remainder);
            }
            numIndex--;
            listIndex++;
        }
        
        int maxLength = 0;
        for (int i = 0; i < sums.size(); i++) {
            maxLength = Math.max(maxLength, sums.get(i).size());
        }

        int counter = 0;
        int columnTotal = 0;
        int remainder = 0;
        String result = "";
        while (counter < maxLength) {
            for (int i = 0; i < sums.size(); i++) {
                if (counter > sums.get(i).size() - 1) {
                    continue;
                }
                columnTotal += sums.get(i).get(counter);
            }

            result = columnTotal%10 + result;
            remainder = columnTotal/10;
            columnTotal = remainder;
            counter++;
        }
        if (remainder > 0) result = remainder + result;
        return result;
    }
}
// Input: num1 = "123", num2 = "456"
// Output: "56088"