// User function Template for Java
class FromJumpWithKsteps {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        
        int[] memory = new int[n];
        Arrays.fill(memory, -1);
        return frogJump( n-1, height, memory);
        
    }
    
    int frogJump(int curStep, int[] height, int[] memo){
       
        if(curStep==0) return 0;
        if(memo[curStep]!=-1) return memo[curStep] ;
        
        int minCostTillCurStep = Integer.MAX_VALUE;
        for(int stepsTaken=1; stepsTaken<=2; stepsTaken++){
            if(curStep-stepsTaken>=0){
                int costByTakingCurStep =  frogJump(curStep-stepsTaken, height, memo) + Math.abs(height[curStep]-height[curStep-stepsTaken]);
                minCostTillCurStep = Math.min(minCostTillCurStep, costByTakingCurStep);
            }
        }
        memo[curStep] = minCostTillCurStep;
        return memo[curStep];
    }

}