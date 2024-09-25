package GreedyAlgo.JumpGame;

public class minJumpsToReachLastIndex {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for( int curPosition=0; curPosition<nums.length; curPosition++){
            for( int curJumPosition=curPosition+1;
                 curJumPosition<=Math.min(curPosition+nums[curPosition], nums.length-1 );
                 curJumPosition++){

                if(dp[curJumPosition]==0){
                    dp[curJumPosition] = dp[curPosition] + 1;
                }
                else{
                    dp[curJumPosition] = Math.min(dp[curJumPosition], dp[curPosition] + 1);
                }
            }
        }
        return dp[nums.length-1];
    }


    public int jump2(int[] nums) {
            int jumps = 0;
            int currentJumpEnd = 0;
            int farestJumpToConsiderNext = 0;

            for(int curPosition=0; curPosition<nums.length; curPosition++){
                farestJumpToConsiderNext = Math.max(farestJumpToConsiderNext, curPosition + nums[curPosition]);
                if(curPosition!=nums.length-1 && curPosition == currentJumpEnd){
                    jumps++;
                    currentJumpEnd = farestJumpToConsiderNext;
                    if (currentJumpEnd>=nums.length-1){
                        return jumps;
                    }
                }

            }
            return jumps;

        }
    }