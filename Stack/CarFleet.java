package Leetcode.Stack;

public class CarFleet {
    public static void main(String[] args) {
        CarFleet c = new CarFleet();
        int r = c.carFleet(100, new int[]{0,2,4}, new int[]{4,2,1});
        System.out.println(r);
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int[] nl = new int[target+1];
        float time = -Integer.MAX_VALUE;
        int totalCount = 0;

        for (int i = 0; i < position.length; i++) {
            nl[position[i]] = i+1;
        } 

        for (int i = nl.length-1; i >= 0; i--) {
            if (nl[i] != 0) {
                int carIndex = nl[i]-1;
                float arrivalTime = (float)(target - position[carIndex]) / (float)(speed[carIndex]);
                if (arrivalTime > time){
                    totalCount++;
                    time = arrivalTime;
                }
            }	
        }  
        return totalCount; 
    }
}
// Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
// Output: 3