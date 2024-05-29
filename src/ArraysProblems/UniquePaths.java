package ArraysProblems;

import java.util.Arrays;

public class UniquePaths {
    public UniquePaths(int m, int n){
        int[][] memory=new int[m][n];
        memory[0][0]=1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                memory[i][j]=-1;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (i==0 & j==0 ){
                    continue;
                }
                if(j==0 & i!=0){
                    memory[i][j]=memory[i-1][j];
                }
                else if(i==0 & j!=0){
                    memory[i][j]=memory[i][j-1];
                }
                else{
                    memory[i][j]=memory[i-1][j]+memory[i][j-1];
                }
            }
        }
        System.out.println(memory[m-1][n-1]);
    }
}
