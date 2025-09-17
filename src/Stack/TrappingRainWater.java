package GreedyAlgo;

public class TrappingRainWater {
    public int trap1(int[] height) {
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i-1], height[i]);

        for (int i = n-2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i+1], height[i]);

        int total = 0;
        for (int i = 0; i < n; i++)
            total += Math.min(leftMax[i], rightMax[i]) - height[i];

        return total;
    }

    public int trap2(int[] height) {
    
        int cur=0, rightMax = 0, ri= height.length-1, leftMax=0, trappedWater = 0;

        while(cur<=ri){ 
            if(rightMax<=leftMax){
                if(rightMax< height[ri]){
                    rightMax = height[ri];
                }else{
                    trappedWater =trappedWater +  rightMax - height[ri];
                }
                ri--;
            } else{
                if(leftMax< height[cur]){
                    leftMax = height[cur];
                }else{
                    trappedWater =trappedWater +  leftMax - height[cur];
                }
                cur++;
            }
        
        }
        return trappedWater;
    }
}
