import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> countT = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            countT.put(t.charAt(i),countT.getOrDefault(t.charAt(i),0)+1);
        }
        int have = 0;
        int need = countT.size();
        int[] result = {-1,-1};
        int resultLength = -1;
        int l = 0;
        int r = 0;
        for(r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            window.put(c,window.getOrDefault(c,0)+1);

            //now we want to see if this window satisfies t
            if(countT.containsKey(c) && window.get(c) == countT.get(c)  ){
                have++;
            }

            //now we want to check if have and need are equal
            while(have == need){
                //update our result
                if(resultLength == -1 ||r-l+1 < resultLength){
                    resultLength =r-l+1; 
                    result[0] = l;
                    result[1] = r;                   
                }
                //pop from left of the window
                char left = s.charAt(l); 
                window.put(left,window.get(left)-1);
                //after popping we need to check if the have and need is still met
                if(countT.containsKey(left) &&  window.get(left) < countT.get(left)){
                    have--;
                }
                l++;
            }
        }

        if(resultLength != -1){
            return s.substring(result[0],result[1]+1);
        }
        return "";
    }
    
}