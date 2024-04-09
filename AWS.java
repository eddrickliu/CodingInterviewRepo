import java.util.*;

public class AWS {
    public static void main(String[] args){

    }

    /**
     * https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/description/
     * 
     */
    public static int getMinSwaps(List<Integer> blocks){
        return 0;
    }

    /**
     * determine the most amount of negatives that can will allow the cumulative sum to still be positive
     * 
     */
    public static int getMaxNegatives(List<Integer> PnL){
        if(PnL.size()<1){
            return 0;
        }
        return backTracking(PnL, 1, PnL.get(0),0);
    }

    public static int backTracking(List<Integer> PnL, int index, int cumSum, int totalCount){
        if(cumSum <= 0){
            return 0;
        }
        if(index == PnL.size()){
            return totalCount;
        }

        return Math.max(backTracking(PnL,index+1,cumSum+PnL.get(index),totalCount),
                        backTracking(PnL,index+1,cumSum+(PnL.get(index)*-1),totalCount+1));
    }
}
