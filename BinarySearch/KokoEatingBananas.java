package Leetcode.BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        KokoEatingBananas k = new KokoEatingBananas();
        System.out.println(k.minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
    int[] piles;
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 0) return 0;
        this.piles = piles;
        int maxValue = -Integer.MAX_VALUE;
        for (int pile : piles) {
            maxValue = Math.max(maxValue, pile);
        }
        int a = 1;
        int b = maxValue;
        int minK = Integer.MAX_VALUE;

        while (a <= b) {
            int mid = (int)Math.ceil((a+b)/2.0);
            int hours = getHours(mid);
            if (hours <= h) {
                minK = Math.min(minK, mid);
            }

            if (hours > h) {
                a = mid+1;
            } else {
                b = mid-1;
            }
        }
        return minK;
    }

    int getHours(double k) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil(pile/k);
        }
        return hours;
    }
}
// Input: piles = [3,6,7,11], h = 8
// Output: 4