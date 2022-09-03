package Leetcode.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class GreyCode {
    public static void main(String[] args) {
        GreyCode g = new GreyCode();
        System.out.println(g.grayCode(2));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int num = 1 << n;
        for (int i = 0; i < num; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}