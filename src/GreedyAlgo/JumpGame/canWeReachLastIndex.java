package GreedyAlgo.JumpGame;

public class canWeReachLastIndex {
    public boolean canReachLastIndex(int[] nums) {
        int maxDistanceReached = 0;
        int destination = nums.length;

        for( int i=0; i<nums.length; i++){
            if( maxDistanceReached>=destination){
                return true;
            }
            if(nums[i]+i>maxDistanceReached){
                maxDistanceReached = nums[i]+i;
            }
        }
        if(maxDistanceReached>=destination){
            return true;
        }
        return false;

    }
}
