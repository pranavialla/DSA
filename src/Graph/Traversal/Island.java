package Graph.Traversal;

public class Island {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c]=='1' && !visited[r][c] ) {
                    dfs(grid, r, c, visited);
                    count++;
                }
            }
        }
        return count;


    }

    private void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        if(r>=0 && c>=0 && c<grid[0].length && r<grid.length && grid[r][c]=='1'  && !visited[r][c]){
            visited[r][c] = true;
            int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}, {-1,-1}, {-1,1}, {1, -1}, {1,1}};
            for(int[] direction : directions){
                dfs(grid, r+direction[0], c+direction[1], visited);
            }

        }

    }
}
