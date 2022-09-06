package Leetcode.Strings;

public class InterleavingString {
    public static void main(String[] args) {
        InterleavingString i = new InterleavingString();
        System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));;
    }
    char[] s1;
    char[] s2;
    char[] s3;
    Boolean[][] cache;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length() != s3.length()) return false;
        this.s3 = s3.toCharArray();
        this.s1 = s1.toCharArray();
        this.s2 = s2.toCharArray();
        this.cache = new Boolean[s1.length()+1][s2.length()+1];

        return dfs(0,0);
        
    }

    boolean dfs(int a, int b) {
        if (a == s1.length && b == s2.length) return true;
        if (cache[a][b] != null) return cache[a][b];

        char firstChar = a == s1.length ? '1' : this.s1[a];
        char secondChar = b == s2.length ? '1' : this.s2[b];
        int index = a+b;
        char thirdChar = this.s3[index];

        if (firstChar == thirdChar && secondChar == thirdChar) {
            cache[a][b] = dfs(a+1, b) || dfs(a,b+1);
        } else if (firstChar == thirdChar) {
            cache[a][b] = dfs(a+1,b);
        } else if (secondChar == thirdChar) {
            cache[a][b] = dfs(a,b+1);
        } else {
            return false;
        }

        return cache[a][b];
    }
}
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
// Output: true