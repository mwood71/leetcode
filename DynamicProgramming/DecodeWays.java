package Leetcode.DynamicProgramming;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        System.out.println(d.numDecodings("2224"));
    }

    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] cache = new int[s.length() + 1];
        cache[0] = 1;
        int num = Integer.parseInt(s.substring(0, 1));
        if (num == 0) {
            cache[1] = 0;
        } else {
            cache[1] = 1;
        }

        for (int i = 2; i < cache.length; i++) {
            num = Integer.parseInt(s.substring(i-1, i)); 
            if (num == 0) {
                cache[i] = 0;
            } else {
                cache[i] = cache[i-1];
            }

            num = Integer.parseInt(s.substring(i-2, i));
            if (num >= 10 && num <= 26) {
                cache[i] += cache[i-2];
            }
        }
        return cache[cache.length-1];
    }
}
// Input: s = "2224"
// Output: 3


// 1 0 0 0 0
// 1 1 2 3 5