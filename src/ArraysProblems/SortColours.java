package ArraysProblems;

public class SortColours {
    public SortColours(int[] nums){
        int index=0;
        int zeroEnd=0;
        int oneEnd=nums.length-1;
        while(index<=oneEnd){
            if(nums[index]==0){
                swap(nums, zeroEnd++, index++);
            }
            else if(nums[index]==1){
                index++;
            }
            else {
                swap(nums, oneEnd--, index);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
