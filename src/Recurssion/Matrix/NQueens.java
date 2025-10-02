package Recurssion.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> getNQueensAllPossiblePositions(int n) {
        List<List<String>> allPossibleNQueensPositions = new ArrayList<>();
        char[][] tempPositions = filltempPositions(n);
        getPossitionsRecurssion(0, tempPositions, allPossibleNQueensPositions);
        return allPossibleNQueensPositions;
    }

    private char[][] filltempPositions(int n){
        char[][] tempPositions=new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                tempPositions[i][j] = '.';
            }
        }
        return tempPositions;
    }

    private void getPossitionsRecurssion(int row, char[][] tempPositions, List<List<String>> allPossibleNQueensPositions) {
        if(row==tempPositions.length){
            allPossibleNQueensPositions.add(getStringArrayListByCharArray(tempPositions));
            return ;
        }
            for(int i=0; i<tempPositions.length; i++){
                if(isPossiblePossition(tempPositions, row, i)){
                    tempPositions[row][i] = 'Q';
                    getPossitionsRecurssion(row+1, tempPositions, allPossibleNQueensPositions);
                    tempPositions[row][i] = '.';
                }
            }

    }

    private List<String> getStringArrayListByCharArray(char[][] tempPositions) {
        List<String> NQueensPositions = new ArrayList<>();
        for (int i=0; i<tempPositions.length; i++){
            String tempString = "";
            for(int j = 0; j < tempPositions[i].length; j++){
                tempString+=tempPositions[i][j];
            }
            NQueensPositions.add(tempString);
        }
        return NQueensPositions;
    }

    private boolean isPossiblePossition(char[][] board, int row, int col) {
            for(int i=0; i<row; i++){
                for(int j=0; j<board.length; j++){
                    if(board[i][j]=='Q' & (i==row || j==col || i+col == j+row || i+j == col+row)){
                        return false;
                    }
                }
            }
            return true;
       }




    public List<List<String>> solveNQueens(int n){
        List<List<String>> result = new ArrayList<List<String>>();
        if(n<1)
            return result;
        solve(result, new ArrayList<String>(), n, 0,new boolean[n], new boolean[2*n], new boolean[2*n]);
        return result;
    }
    public void solve(List<List<String>> result, List<String> cur,
                      int n, int rowCur, boolean[] col, boolean[] diag1,
                      boolean[] diag2){
        if(rowCur==n){
            result.add(new ArrayList<String>(cur));
            return;
        }
        for(int j = 0; j<n; j++){
            int d1=rowCur+j;
            int d2=j-rowCur+n;
            if(!col[j] && !diag1[d1] && !diag2[d2]){
                col[j]=true;
                diag1[d1]=true;
                diag2[d2]=true;
                char[] helpChars=new char[n];
                Arrays.fill(helpChars,'.');
                helpChars[j]='Q';
                cur.add(new String(helpChars));

                solve(result, cur, n, rowCur+1, col, diag1, diag2);

                col[j]=false;
                diag1[d1]=false;
                diag2[d2]=false;
                cur.remove(cur.size()-1);
            }
        }
    }
}
