package Graph.Traversal;

import java.util.ArrayList;
import java.util.List;

public class WordBoggle {
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        List<String> words = new ArrayList<String>();
        boolean breakLoop = false;

        for( int i = 0; i < dictionary.length; i++){
            breakLoop = false;
            boolean[][] visited = new boolean[board.length][board.length];
            for(int r=0; r<board.length; r++){
                if(breakLoop){
                    break;
                }
                for( int c=0; c < board[0].length; c++){
                    if(board[r][c]==dictionary[0].charAt(0)){
                        if(isWordExists(board,  r, c, dictionary[i], 0, visited)){
                            words.add(dictionary[r]);
                            breakLoop = true;
                            break;
                        }
                    }
                }
            }
        }

    }

    private boolean isWordExists(char board[][], int r, int c, String word, int curIndex, boolean[][] visited) {
        if(curIndex==word.length()){
            return true;
        }
        visited[r][c] =true;
        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}, {-1,-1}, {-1,1}, {1, -1}, {1,1}};
        for (int[] direction : directions ){
            int newR = r + direction[0];
            int newC = c + direction[1];
            if(isValidIndex(newR, newC, board) &&!visited[newR][newC] && board[newR][newC]==word.charAt(curIndex)){
                if(isWordExists(board, newR, newC, word, curIndex+1, visited)){
                    return true;
                }
            }
        }
    }

    private boolean isValidIndex(int newR, int newC, char[][] board) {
        return true;
    }
}
