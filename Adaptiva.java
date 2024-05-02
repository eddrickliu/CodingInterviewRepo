import java.util.*;

public class Adaptiva {
    static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args){
        Integer[] test1 = {3,2,1,23,4,12};
        Integer[] test2 = {2,1,1,12,2,2};
        Integer[] test3 = {6,5,3,1};
        // System.out.println("getMinSwaps(test1)"+getMinSwaps(Arrays.asList(test1)));
        // System.out.println("getMinSwaps(test2)"+getMinSwaps(Arrays.asList(test2)));
        // System.out.println("getMinSwaps(test3)"+getMinSwaps(Arrays.asList(test3)));
        // System.out.println("getMaxNegatives(test1)"+getMaxNegatives(Arrays.asList(test1)));
        // System.out.println("getMaxNegatives(test2)"+getMaxNegatives(Arrays.asList(test2)));
        // System.out.println("getMaxNegatives(test3)"+getMaxNegatives(Arrays.asList(test3)));
    }
    public static long journey(List<Integer> path, int maxStep) {
        // Write your code here
            if(path.size() == 1){
                return path.get(0);
            }
            
            int[] options = new int[path.size()];
            Arrays.fill(options,0);
            options[0] = path.get(0);
            
            for(int i = 1; i < path.size(); i++){
                options[i] = Integer.MIN_VALUE;
                for(int j = 1; j <= maxStep && i - j >= 0; j++){
                    options[i] = Math.max(options[i],path.get(i)+options[i-j]);
                }
            }
            return options[path.size() - 1];
            
        }

        public static String reachTheEnd(List<String> grid, int maxTime) {
            // Write your code here
                int n = grid.size();
                int m = grid.get(0).length();
                char[][] gridArray = new char[n][m];
                for(int i = 0; i < n; i++){
                    gridArray[i] = grid.get(i).toCharArray();
                }
                PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(coor -> coor[2]));
                q.add(new int[]{0,0,0});//{row,col,distance}
                gridArray[0][0] = '#';
                while(!q.isEmpty()){
                    int size = q.size();
                    for(int i = 0; i < size; i++){
                        int[] pos = q.poll();
                        int r = pos[0];
                        int l = pos[1];
                        int d = pos[2];
                        if(r == m - 1 && l == n - 1 && d <= maxTime){
                            return "Yes";
                        }
                        for(int[] direction: directions){
                            int dr = direction[0] + r;
                            int dl = direction[1] + l;
                            
                            if(dr >= 0 && dr < n && dl >= 0 && dl < m && gridArray[dr][dl] == '.'){
                                gridArray[dr][dl] = '#';
                                q.add(new int[]{dr,dl, d+1});
                            }
                        }
                    }
                }
                return "No";
            }

    
}
