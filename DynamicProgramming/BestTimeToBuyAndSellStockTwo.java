package Leetcode.DynamicProgramming;

public class BestTimeToBuyAndSellStockTwo {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockTwo b = new BestTimeToBuyAndSellStockTwo();
        System.out.println(b.maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int currStock = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int stock = prices[i];
            if (stock <= currStock) {
                currStock = stock;
            } else {
                profit += stock - currStock;
                currStock = stock;
            }
        }
        return profit;  
    }
}
// Input: prices = [7,1,5,3,6,4]
// Output: 7