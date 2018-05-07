package exercise.algorithm.leetcode.array;

//ref: https://www.cnblogs.com/jimmycheng/p/7715061.html
//DFS
public class E_MaxAreaofIsland_695 {

    public static int maxAreaofIsland(int[][] grid){
        if(null == grid)
            return 0;
        
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }
    
    public static int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0)
            return 0;
        
        int tmpArea = 1;
        grid[i][j] = 0;
        
        tmpArea += dfs(grid, i, j-1) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i+1, j);
        return tmpArea;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        
        System.out.println(maxAreaofIsland(grid));
    }
}
