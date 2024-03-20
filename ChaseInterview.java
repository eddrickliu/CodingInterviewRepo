import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class ChaseInterview {

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(3);
        arr.add(1);
        arr.add(5);
        arr.add(2);
        solutionA(arr);
        System.out.println(solutionB("800800880"));
        System.out.println(solutionB("468136"));
    }
    
    public static int solutionA(List<Integer> arr){
        Collections.sort(arr);
        int totalResult = 0;
        while(arr.size() >= 2){
            int min = arr.remove(0);
            int max = arr.remove(arr.size()-1);
            totalResult += (min+max)/(max+min+1);//TODO need to remember what this was here.
            arr.add(min+max);
        }
        return totalResult;
    }
    public static String solutionB(String str){
        int N = str.length();
        StringBuilder ans = new StringBuilder();
        char[] digits = str.toCharArray();
        int left = 0;
        //two pointer sliding window algo to find same parity consecutive elements
        while(left < N){
            int[] freq = new int[10];//freq array to store the freq of each integer
            int right = left;//right end of the window
            //expand window to the right while parity is the same
            while(right < N - 1 && (Character.getNumericValue(digits[right]) % 2 == Character.getNumericValue(digits[right+1]) % 2)){
                //add elements into freq array and incremenet right as we go
                ++freq[Character.getNumericValue(digits[right])];
                right++;
            }
            ++freq[Character.getNumericValue(digits[right])];//add the last value in the window

            //add elements to String Builder:
            for(int i = 9; i >= 0; i--){
                while(freq[i] > 0){
                    ans.append(i);
                    --freq[i];
                }
            }

            left = right+1;//slide left side of the window
        }
        return ans.toString();
    }
}
