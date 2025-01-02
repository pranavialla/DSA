package Heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

class KthLargest{
    public int getKthLargest(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for( int num :  nums){
            maxHeap.add(num);
            if(maxHeap.size()== nums.length+1-k){
                minHeap.add(maxHeap.poll());
            }
        }
        return minHeap.poll();
    }


    public int getKthLargest1(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for( int num :  nums){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}