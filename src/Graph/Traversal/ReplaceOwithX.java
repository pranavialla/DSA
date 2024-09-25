package Graph.Traversal;

import java.util.ArrayDeque;
import java.util.Queue;



class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class ReplaceOwithX {

    public static boolean inBounds(int i,int j, int n, int m){
        return (0 <= i && i < n) && (0 <= j && j < m);
    }


    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        char o = 'O';

        Queue<Pair> Q = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            if (a[i][0] == o)
                Q.add(new Pair(i,0));
            if (a[i][m-1] == o)
                Q.add(new Pair(i, m-1));
            }

        for(int i = 0; i < m; i++){
            if (a[i][0] == o)
                Q.add(new Pair(0,i));
            if (a[i][n-1] == o)
                Q.add(new Pair(i, n-1));
        }
        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(Q.size()!=0){
            Pair ele= Q.poll();
            int i= ele.x,j = ele.y;
            a[i][j] = '#';

            for (int[] direction : directions ){
                if(!inBounds(i+direction[0], j+direction[1], n, m)) {
                    continue;
                }
                if(a[i+direction[0]][j+direction[1]] !=o){
                    continue;
                }
                Q.add(new Pair(i,j));
                a[i][j] = '#';

            }
        }
        return a;

    }
}
