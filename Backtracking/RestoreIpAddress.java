package Leetcode.Backtracking;

import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddress {
    public static void main(String[] args) {
        RestoreIpAddress r = new RestoreIpAddress();
        System.out.println(r.restoreIpAddresses("0000"));
    }
    String s;
    List<String> results = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        dfs(0, 0, "", -1);
        return results;
    }

    void dfs(int count, int index, String str, int lastPointer) {
        if (count == 4 && index != s.length()) return;
        if (count == 4 && index == s.length()) {
            results.add(str.substring(0, str.length()-1));
            return;
        } 

        for (int i = 0; i <= 3; i++) {
            if (index + i < s.length()) {
                char c = s.charAt(index+i);
                str += c;
                if ((lastPointer == str.length()-2 || str.charAt(lastPointer+1) != '0') && 
                Integer.parseInt(str.substring(lastPointer+1)) <= 255) {
                    dfs(count+1, index+i+1, str + ".", str.length());
                }
            }
        }
    }
}
