package Graph.Traversal.DFS;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        if (image[sr][sc]==newColor) return image;
        int oldColour= image[sr][sc];

        return dfs(image, sr, sc,  newColor, oldColour);


    }

    private int[][] dfs(int[][] image, int r, int c, int newColor, int oldColour) {
        if(r>=0 && c>=0 && c<image[0].length && r<image.length && image[r][c]==oldColour){
            image[r][c]=newColor;
            int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
            for(int[] direction : directions){
                dfs(image, r+direction[0], c+direction[1],  newColor, oldColour);
            }

        }
        return image;

    }

}
