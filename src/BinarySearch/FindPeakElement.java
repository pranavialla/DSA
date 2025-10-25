class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left =0, right = nums.length-1;

        //it goes to infinite loop if we won't keep left in the moving end like left = mid instead of of left = mid +1 as we're using floor division we are biased towards left if 2 elements are there then again we're setting left to mid . tadaaa infinite loop
        while(left<right){
            int mid = left + (right-left)/2;

            if( (mid==0|| nums[mid]>nums[mid-1]) && ( mid==nums.length-1 ||nums[mid]>nums[mid+1])) return mid;
            if(nums[mid+1]>nums[mid]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}