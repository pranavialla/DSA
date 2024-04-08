package Arrays;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
