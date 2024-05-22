package ArraysProblems;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ZeroMatrix {
    Scanner sc;
    Writer outputWriter;

    ArrayList<ArrayList<Integer>> result;
    public ZeroMatrix(Scanner sc, Writer outputWriter) throws IOException {
        this.sc=sc;
        this.outputWriter=outputWriter;
        this.result= inputProcess();
        outputProcess();
    }


    ArrayList<ArrayList<Integer>> execute(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m){
        int[] zeroRows=new int[n];
        int[] zeroColums=new int[m];
        Arrays.fill(zeroRows, 1);
        Arrays.fill(zeroColums, 1);
        // setting  col 0
        for(int rowIndex=0; rowIndex<n; rowIndex++){
            for(int columnIndex=0; columnIndex<m; columnIndex++){
                if (matrix.get(rowIndex).get(columnIndex)==0) {
                    zeroRows[rowIndex]=0;
                    zeroColums[columnIndex]=0;
                }
            }
        }

        for(int rowIndex=0; rowIndex<n; rowIndex++){
            for(int columnIndex=0; columnIndex<m; columnIndex++){
                if (zeroRows[rowIndex]==0 || zeroColums[columnIndex]==0) {
                    matrix.get(rowIndex).set(columnIndex, 0);
                }
            }
        }

        // setting  row 0

        /*    int n= matrix.length ;
            int m=matrix[0].length ;
            int zeroIndexRow=1;
            int zeroIndexColumn=1;

            for(int i=0; i<m; i++){
                if(matrix[0][i]==0){
                    zeroIndexRow=0;
                    break;
                }
            }

            for(int j=0; j<n; j++){
                if(matrix[j][0]==0){
                    zeroIndexColumn=0;
                    break;
                }
            }

            if( zeroIndexRow==0  || zeroIndexColumn==0){
                matrix[0][0]=0;
            }

            // setting  col 0
            for(int rowIndex=1; rowIndex<n; rowIndex++){
                for(int columnIndex=1; columnIndex<m; columnIndex++){
                    if (matrix[rowIndex][columnIndex]==0) {
                        matrix[0][columnIndex]=0;
                        matrix[rowIndex][0]=0;
                    }
                }
            }

            for(int rowIndex=1; rowIndex<n; rowIndex++){
                for(int columnIndex=1; columnIndex<m; columnIndex++){
                    if (matrix[0][columnIndex]==0 ||matrix[rowIndex][0]==0) {
                        matrix[rowIndex][columnIndex]=0;
                    }
                }
            }

            if(zeroIndexRow==0){
                for (int col=1; col<m; col++){
                    matrix[0][col]=0;
                }
            }


            if(zeroIndexColumn==0){
                for (int row=1; row<n; row++){
                    matrix[row][0]=0;
                }
            }*/



            // setting  row 0





        return matrix;

    }

    public ArrayList<ArrayList<Integer>> inputProcess(){
        Integer n=sc.nextInt();
        Integer m=sc.nextInt();
        sc.nextLine();

        ArrayList<ArrayList<Integer>> matrix= new ArrayList<>();
        int[][] array=new int[n][m];
        for (int i=0; i<n; i++){
            ArrayList<Integer> row=new ArrayList<Integer>();
            Boolean lastelement=false;
            for (int j=0; j<m; j++){
                row.add((Integer) sc.nextInt());
                if(j==m-1) lastelement=true;
            }
            matrix.add(row);
            if(i==n-1 && lastelement){
                break;
            }
            sc.nextLine();

        }

        return  execute(matrix, n, m);

    }

    public void outputProcess() throws IOException {
        for(ArrayList<Integer> row: this.result){
            Object[] arrayRow=row.toArray();
            this.outputWriter.write(Arrays.deepToString(arrayRow).replace(",", " ").replace("[", "").replace("]", ""));
            this.outputWriter.write("\n");
        }
        outputWriter.close();
    }
}
