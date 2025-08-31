package Recurssion;

import java.util.ArrayList;
import java.util.Arrays;

class Position{
    int x;
    int y;

    Position(int x, int y){
        this.x=x;
        this.y=y;
    }

}

public class RatInTheMaze {

    public static ArrayList<String> findPath(int[][] m, int n)   {
        ArrayList<String> paths = new ArrayList<>();
        String currentPath = "";
        if (m[0][0]==0){
            return paths;
        }
        Position currentPossition = new Position(0,0);
        boolean[][] visitedMarker = initializeVisitedMaarkingBoard(n);
        visitedMarker[0][0]=true;
        findAllPathsRecursively(m, paths, visitedMarker, currentPath, currentPossition);
        return paths;
        // Your code here
    }

    private static String findAllPathsRecursively(int[][] m,
                                                  ArrayList<String> paths,
                                                  boolean[][] isVisited,
                                                  String currentPath,
                                                  Position currentPossition) {
        if(currentPossition.x==isVisited.length-1 &
                currentPossition.y==isVisited[0].length-1){
            isVisited[isVisited.length-1][isVisited.length-1] = false ;
            return currentPath;
        }

        int[][] allDirectoins = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for(int[] direction : allDirectoins){
            if(isValidRoute(direction, currentPossition, isVisited, m)){
                currentPath+=getDirectionIdentifier(direction);
                currentPossition.x += direction[0];
                currentPossition.y += direction[1];
                isVisited[currentPossition.x][currentPossition.y] = true ;

                String possiblePath = findAllPathsRecursively(m, paths, isVisited, currentPath, currentPossition);
                if(possiblePath!=null){
                    paths.add(possiblePath);
                }

                isVisited[currentPossition.x][currentPossition.y] = false ;
                currentPossition.x -= direction[0];
                currentPossition.y -= direction[1];
                currentPath=goBackToLastStep(currentPath);

            }
        }
        return null;
    }

    private static boolean isValidRoute(int[] direction, Position currentPossition, boolean[][] isVisited, int[][] maze) {

        return !(
                currentPossition.x + direction[0] < 0 ||
                        currentPossition.x + direction[0] > isVisited.length-1 ||
                        currentPossition.y + direction[1] < 0 ||
                        currentPossition.y + direction[1] > isVisited[0].length-1 ||
                        isVisited[currentPossition.x + direction[0]][currentPossition.y  + direction[1] ] ||
                        maze[currentPossition.x + direction[0]][currentPossition.y + direction[1]]==0 );

    }

    private static String goBackToLastStep(String currentPath) {
        currentPath=currentPath.substring(0,currentPath.length()-1);
        return currentPath;
    }

    private static String getDirectionIdentifier(int[] direction) {
        if (direction[0]==0 & direction[1]==1){
            return "R";
        }
        else if(direction[0]==1 & direction[1]==0){
            return "D";
        }
        else if(direction[0]==-1 & direction[1]==0){
            return "U";
        }
        else if(direction[0]==0 & direction[1]==-1){
            return "L";
        }
        return null;
    }


    private static boolean[][] initializeVisitedMaarkingBoard(int n) {
        boolean[][] visitedMarker = new boolean[n][n];
        return visitedMarker;
    }
}
