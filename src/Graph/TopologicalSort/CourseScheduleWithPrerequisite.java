package Graph.TopologicalSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CourseScheduleWithPrerequisite {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = prepareAdjacencyList(numCourses, prerequisites);
        return !isCyclic(numCourses, adj);
    }



    private ArrayList<ArrayList<Integer>> prepareAdjacencyList(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            int course = prerequisite[1];
            int prerequisiteCourse = prerequisite[0];
            adj.get(course).add(prerequisiteCourse);
        }
        return adj;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        int[] indegree = assignIndegree(V, adj);

        Queue<Integer> zeroIndegree = getZeroIndegreeeVertex(indegree);
        int courseCompletedCount = 0;

        while(zeroIndegree.size()!=0){
            int vertex = zeroIndegree.poll();
            courseCompletedCount +=1;
            DecrementIndegreeOfNeighboursByOne(indegree, adj, vertex, zeroIndegree);
        }
        return !(V == courseCompletedCount);
    }


    private static void DecrementIndegreeOfNeighboursByOne(int[] indegree,
                                                           ArrayList<ArrayList<Integer>> adj,
                                                           int vertex,
                                                           Queue<Integer> zeroIndegree) {
        for(int neighbor : adj.get(vertex)){
            indegree[neighbor]--;
            if(indegree[neighbor]==0){
                zeroIndegree.add(neighbor);
            }
        }
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

    private static int[] assignIndegree(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int neighbor : adj.get(i)){
                indegree[neighbor]++;
            }
        }
        return indegree;
    }
}
