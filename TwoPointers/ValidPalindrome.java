package Leetcode.TwoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
    }
    
    public boolean isPalindrome(String s) {
        String tempString = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                tempString += c;
            }
        }
        s = tempString.toLowerCase();
        int a = 0;
        int b = s.length()-1;
        while (a <= b) {
            if (s.charAt(a) != s.charAt(b)) return false;
            a++;
            b--;
        }
        return true;
    }
}
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.