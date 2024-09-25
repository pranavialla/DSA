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
        int n = height.length;
        int left = 0;
        int right = height.length-1;

        int trappedRainWater = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right){
            if(height[left] <= height[right]){
                if(height[left] > leftMax){
                    leftMax = height[left];
                }else{
                    trappedRainWater += leftMax - height[left];
                }
                left++;
            } else{
                if(height[right] > rightMax){
                    rightMax = height[right];
                } else{
                    trappedRainWater += rightMax - height[right];
                }
                right--;
            }
        }
        return trappedRainWater;
    }
}
