import java.util.*;

public class AWS {
    public static void main(String[] args){

    }

    /**
     * https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/description/
     * 
     */
    public static int getMinSwaps(int[] blocks){
        int maxIndex = blocks.length - 1;//index of maxValue from the right
        int minIndex = 0;//index of minValue from the left
        for(int i = 1; i < blocks.length; i++){
            if(blocks[minIndex]>blocks[i]){//this ones going in order to find the min
                minIndex = i;
            }
            if(blocks[maxIndex]<blocks[blocks.length-1-i]){//this ones going reverse to find the max
                maxIndex = blocks.length-1-i;
            }
        }
        int ans = minIndex+(blocks.length-1-maxIndex);//distance of each from respective sides is the min of swaps
        if(maxIndex < minIndex){//case when maxIndex and  minIndex are adjacent to each other
            ans--;
        }
        return ans;
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
