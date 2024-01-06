public class DoordashInterview {
    public static void main(String[]args){
        int[][] testcase1 = {{9, 9, 4},{6, 6, 8},{2, 1, 1}};
        int[][] testcase2 = {{9, 10, 4},{6, 6, 8},{2, 1, 1}};
        int[][] testcase3 = {{1, 1, 1},{1, 1, 1},{1, 1, 1}};
        int[][] testcase4 = {{9, 8, 7},{4, 5, 6},{3, 2, 1}};
        System.out.println(getMaximumStackableOrders(testcase1));
        System.out.println(getMaximumStackableOrders(testcase2));
        System.out.println(getMaximumStackableOrders(testcase3));
        System.out.println(getMaximumStackableOrders(testcase4));
    }
    // [9 9 4]
    // [6 6 8]
    // [2 1 1]
    // ans: 4

    // [9 10 4]
    // [6 6 8]
    // [2 1 1]
    // ans: 5

    // [1 1 1]
    // [1 1 1]
    // [1 1 1]
    // ans: 1

    // [9 8 7]
    // [4 5 6]
    // [3 2 1]
    // ans: 9

    // [0 0 0]
    // [0 0 0]
    // [0 0 0]
    public static int M;
    public static int N;
    public static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public static int getMaximumStackableOrders(int[][] grid){
        M = grid.length;
        N = grid[0].length;
        int[][] countMap = new int[M][N];
        int max = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                int size = dfs(grid,i,j,Integer.MAX_VALUE,countMap);
                max = Math.max(max,size);
            }
        }
        return max;
    }
    public static int dfs(int[][] grid, int row, int col, int prev,int[][] countMap){
        if(row < 0 || col < 0 || row == M || col == N || prev <= grid[row][col]){
            return 0;
        }

        if(countMap[row][col] != 0){
            return countMap[row][col];
        }
        int max = 0; 
        for(int[] direction: directions){
            max = Math.max(max, dfs(grid, row+direction[0], col+direction[1],grid[row][col],countMap));
        }
        countMap[row][col] = 1 + max;
        return countMap[row][col];
    }
}
