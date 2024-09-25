package Graph.TopologicalSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedulingOrdering {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = assignIndegree(numCourses, prerequisites);
        ArrayList<ArrayList<Integer>> adj = getAdjacenctList(numCourses, prerequisites);
        Queue<Integer> zeroIndegree = getZeroIndegreeeVertex(indegree);
        int[] order = getTopologySort(numCourses, indegree, zeroIndegree, adj);
        return order;
    }


    public int[] getTopologySort(int V, int[] indegree, Queue<Integer> zeroIndegree, ArrayList<ArrayList<Integer>> adj) {

        int[] topologySort = new int[indegree.length];
        int i=0;
        //System.out.println("indegree : "+Arrays.toString(indegree));

        while(zeroIndegree.size()!=0){
            int vertex = zeroIndegree.poll();
            topologySort[i++]=vertex;
            //System.out.println("vertex:  "+ vertex);
            zeroIndegree = DecrementIndegreeOfNeighboursByOne(indegree, adj, vertex, zeroIndegree);
        }
        //System.out.println(i+ " "+ V);
        return (i == V) ? topologySort : new int[0];
    }

    private ArrayList<ArrayList<Integer>> getAdjacenctList(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adj.get(prerequisiteCourse).add(course);
            //System.out.println(course +"<-"+prerequisiteCourse);
        }


        return adj;
    }


    private static Queue<Integer> DecrementIndegreeOfNeighboursByOne(int[] indegree,
                                                                     ArrayList<ArrayList<Integer>> adj,
                                                                     int vertex,
                                                                     Queue<Integer> zeroIndegree) {
        for(int neighbor : adj.get(vertex)){
            indegree[neighbor]--;
            if(indegree[neighbor]==0){
                zeroIndegree.add(neighbor);
            }
        }
        return zeroIndegree;
    }

    private static Queue<Integer> getZeroIndegreeeVertex(int[] indegree) {
        Queue<Integer> zeroIndegree = new ArrayDeque<>();
        for( int i=0; i<indegree.length; i++){
            if( indegree[i]==0){
                zeroIndegree.add(i);
            }
        }

        return zeroIndegree;
    }

    private static int[] assignIndegree(int V,  int[][] prerequisites) {
        int[] indegree = new int[V];

        for(int[] prerequisite : prerequisites){
            indegree[prerequisite[0]]++;
        }

        return indegree;
    }

}
