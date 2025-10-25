package Heap.GreedyHeap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxSlots {

        public int leastInterval1(char[] tasks, int n) {
        Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        for(char task : tasks){
            frequencyMap.put(task, frequencyMap.getOrDefault(task, 0)+1);
        } 

        PriorityQueue< Integer> taskFrequency = new PriorityQueue<Integer>((a,b)->Integer.compare(b, a));
        taskFrequency.addAll(frequencyMap.values());

        Queue<Integer[]> blockingQueue = new LinkedList<Integer[]>();

        int interval=0;
        while(taskFrequency.size()!=0 || blockingQueue.size()!=0){
            System.out.println(taskFrequency.size()+ " "+ blockingQueue.size());
            if(!taskFrequency.isEmpty()){
                Integer curExecuted= taskFrequency.poll()-1;
                if(curExecuted!=0){
                    blockingQueue.add(new Integer[]{interval+n, curExecuted});
                }
               
            }
            
            if(!blockingQueue.isEmpty() && blockingQueue.peek()[0]==interval){
                taskFrequency.add(blockingQueue.poll()[1]);
            }
            interval++;
            
        }
        return interval;

    }
   
    public int leastInterval(char[] tasks, int n) {
        int[] taskFrequencies = new int[26];
        int maxFrequency = 0;
        for (char task : tasks) {
            int index = task - 'A';
            taskFrequencies[index]++;
            maxFrequency = Math.max(maxFrequency, taskFrequencies[index]);
        }
        int tasksWithMaxFrequency = 0;
        for (int frequency : taskFrequencies) {
            if (frequency == maxFrequency) {
                tasksWithMaxFrequency++;
            }
        }
        int slotsForMaxFreqTasks = (maxFrequency - 1) * (n + 1) + tasksWithMaxFrequency;
        return Math.max(tasks.length, slotsForMaxFreqTasks);
    }
    /*
     * 
     * 
     * This is the heart of the formula:

            (maxFrequency - 1) → number of full "gaps" between the most frequent tasks

            (n + 1) → each gap has n idle slots + 1 task

            + tasksWithMaxFrequency → fill the last row with all max-frequency tasks

            📌 Why -1? We don’t need a trailing gap after the last occurrence of the most frequent task.
    */

}
