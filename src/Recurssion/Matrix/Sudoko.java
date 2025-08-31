package Recurssion;

import java.util.Arrays;

public class Sudoko {
    public void sudokoSolver(char[][] board){
        RecursiveSudokoSolver(board, 0, 0);
    }

    private char[][] RecursiveSudokoSolver(char[][] board, int row, int col) {
        if(row==board.length){
            return board;
        }
        else if(col==board.length){
            return RecursiveSudokoSolver(board, row+1, 0);
        }
        if(board[row][col]=='.'){
            for(int num=1; num<=9; num++){
                //another better is valid condition down there isvalid() function
                if(isValidNum(num, board, row, col)){
                    board[row][col] = (char) (num+ '0');
                    if(RecursiveSudokoSolver(board, row, col+1)!=null){
                        return board;
                    }
                    board[row][col]='.';
                }
            }
            return null;
        }
        else {
            return RecursiveSudokoSolver(board, row, col+1);
            }
        }


    private boolean isValidNum(int num, char[][] board, int x, int y) {
        if(horizontalAndVerticalValidation(num, board, x, y) & boxValidation(num, board, x, y)){
            return true;
        }
        return false;
    }

    private boolean boxValidation(int num, char[][] board, int x, int y) {
        int[][] startEndBoxIndices = new int[][]{ {0, 2}, {3, 5}, {6, 8}};
        for (int xIndex=0;  xIndex<3; xIndex++){
            for(int yIndex=0; yIndex<3; yIndex++){
                if(startEndBoxIndices[xIndex][0] <=x  & x <= startEndBoxIndices[xIndex][1] &
                   startEndBoxIndices[yIndex][0] <= y & y <= startEndBoxIndices[yIndex][1]){
                        if (validateInthisBox(startEndBoxIndices[xIndex], startEndBoxIndices[yIndex], board, x, y, num)){
                            return true;
                        }
                        else {
                            return false;
                        }
                }
            }

        }
        return false;
    }

    private Boolean validateInthisBox(int[] xAxisStartEndBoxIndex, int[] yAxisStartEndBoxIndex, char[][] board, int x, int y, int num) {
        for(int i=xAxisStartEndBoxIndex[0]; i<=xAxisStartEndBoxIndex[1]; i++){
            for(int j=yAxisStartEndBoxIndex[0]; j<=yAxisStartEndBoxIndex[1]; j++){
                if(board[i][j]==(char) (num+ '0')){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean horizontalAndVerticalValidation(int num, char[][] board, int x, int y) {
        for (int i=0; i<9; i++){
            if(board[x][i]==(char) (num+ '0') || board[i][y]==(char) (num+ '0')){
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, int num) {
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
        for (int i = 0; i < 9; i++)
            if (board[i][col] == (char) (num+ '0') || board[row][i] == (char) (num+ '0') ||
                    board[blkrow + i / 3][blkcol + i % 3] == (char) (num+ '0'))
                return false;
        return true;
    }

}
