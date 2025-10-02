

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MColoring {
    public boolean isColouringWithMColorsPossible(boolean graph[][], int m, int n){
        int[] vertexColor = initializeVertexColor(n);
        return coloringWithMColoursRecursively(m, vertexColor, graph, 0);
    }

    private boolean coloringWithMColoursRecursively(int m, int[] vertexColor, boolean[][] graph, int vertex) {
        if(vertex >=graph.length){
            return true;
        }
        for(int color=0; color<m; color++){
            if(isSurroundingVerticesDontHaveThisColour(color, vertexColor, graph, vertex )){
                vertexColor[vertex] = color;
                if(coloringWithMColoursRecursively(m, vertexColor, graph, vertex+1)){
                    return true;
                }
                vertexColor[vertex]=-1;
            }
        }
        return false;
    }

    private boolean isSurroundingVerticesDontHaveThisColour(int color, int[] vertexColor, boolean[][] graph, int  curVertex) {
        for(int i=0; i<graph.length; i++ ){
            if(graph[curVertex][i]==true){
                if(vertexColor[i]==color){
                    return false;
                }
            }
        }
        return true;
    }


    private int[] initializeVertexColor(int m) {
        int[] vertexColor = new int[m];
        Arrays.fill(vertexColor , -1);
        return vertexColor;
    }
}
