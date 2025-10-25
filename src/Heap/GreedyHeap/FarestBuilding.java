package Heap.GreedyHeap;

import java.util.PriorityQueue;

public class FarestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderUsedAt = new PriorityQueue();
        for(int i=1; i<heights.length; i++){
            if(heights[i]<heights[i-1]) continue;
            ladderUsedAt.offer(heights[i]-heights[i-1]);
            if(ladderUsedAt.size()>ladders){
                int minHeightBuilding = ladderUsedAt.poll();
                if(bricks<minHeightBuilding) return i-1;
                bricks = bricks-minHeightBuilding;
            }
        }
        return heights.length-1;
    }
}
