package DynamicProgramming.SubsequenceSubarraySubset;

import java.util.Arrays;

public // User function Template for Java

class knapSackWithDuplicates {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int[][] memory = new int[val.length][capacity+1];
        for(int[] ememory : memory){
            Arrays.fill(ememory, -1);
        }
        return recur(  val.length-1,  val,  wt,  capacity, memory);
        
    }
    
    
    static int recur( int i, int val[], int wt[], int capacity, int[][] memory){
        if(i<0) return 0;
        int take = 0;
        if(memory[i][capacity]!=-1) return memory[i][capacity];
        
        if(capacity-wt[i]>=0){
            take =  val[i] + recur( i, val, wt, capacity-wt[i], memory);
        }
        int nottake =  recur( i-1, val, wt, capacity, memory);
        
        memory[i][capacity] = Math.max(take, nottake);
        return memory[i][capacity];
    }

        static int recur2( int val[], int wt[], int capacity, int[][] memory){
        
        for(int i=1; i<=val.length; i++){
            for(int curCapacity=0; curCapacity<=capacity ; curCapacity++){
                int take = 0;
                if(curCapacity-wt[i-1]>=0){
                    take =  val[i-1] + memory[i][curCapacity-wt[i-1]];
                }
                int nottake =  memory[i-1][curCapacity];
                
                memory[i][curCapacity] = Math.max(take, nottake);
                }
            }
            
        return memory[val.length][capacity];
    }

    static int knapSackOptimised(int val[], int wt[], int capacity) {
        // code here
        int[] memory = new int[capacity+1];
        //Arrays.fill(memory, -1);
        for(int i=1; i<=val.length; i++){
            int[] temp = new int[capacity+1];
            for(int curCapacity=0; curCapacity<=capacity ; curCapacity++){
                int take = 0;
                if(curCapacity-wt[i-1]>=0){
                    take =  val[i-1] + temp[curCapacity-wt[i-1]];
                }
                int nottake =  memory[curCapacity];
                
                temp[curCapacity] = Math.max(take, nottake);
                }
                
                memory=temp;
            }
            
        return memory[capacity];
        
    }
    
} 
