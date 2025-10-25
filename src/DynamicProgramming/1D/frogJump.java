package DynamicProgramming.1D;

public class frogJump {
    // User function Template for Java
    int minCost(int[] height) {
        // code here
        int n = height.length;
        
        int[] memory = new int[n];
        Arrays.fill(memory, -1);
        
        //length based
        if(n<=1) return 0;
        if(n==2) return Math.abs(height[0]-height[1]);
        if(n==3) return Math.min(Math.abs(height[0]-height[1]) + Math.abs(height[1]-height[2]) , Math.abs(height[0]-height[2]));
        
        //index based
        memory[0] = 0;
        memory[1]= Math.abs(height[0]-height[1]);
        memory[2]=Math.min(Math.abs(height[0]-height[1]) + Math.abs(height[1]-height[2]) , Math.abs(height[0]-height[2]));
          

        for(int i=3; i<n; i++){
           int oneStep = memory[i-1] + Math.abs(height[i]-height[i-1]);
           int twoStep = memory[i-2] + Math.abs(height[i]-height[i-2]);
           memory[i] = Math.min(oneStep, twoStep);
            
        }
        return memory[n-1];
        
    }

}
