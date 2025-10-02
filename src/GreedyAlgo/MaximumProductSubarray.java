

//https://leetcode.com/problems/maximum-product-subarray/

import java.util.Arrays;

public class MaximumProductSubarray {

     int product(int ar[], int n)
    {
        int result = 1;
        for (int i = 0; i < n; i++)
            result = (result * ar[i]);

        return result;
    }
    public int maxProduct(int[] nums) {
        //if positive number of neagitive nums and remaining all are positive (non zero)
        //      then product of whole subarray
        // if we have odd number of neagitive numbers and remaing all are positive then
                // prefix product of neagive or suffix product of neagitive num
        //if any of the num is 0, then consider number before and after zero as diff array

        if(nums.length==0) return 0;
        int maxProduct = Integer.MIN_VALUE;

        int prefixProduct = 1;
        int suffixProduct = 1;

        int prefixStartIndex = 0;
        int prefixEndIndex = 0;

        int sufixStartIndex = nums.length-1;
        int sufixEndIndex = nums.length-1;

        int ansStartIndex = -1;
        int ansEndIndex = -1;

        for(int i = 0; i < nums.length; i++) {
            if(prefixProduct==0){
                prefixProduct = 1;
                prefixStartIndex = i;

            }

            if(suffixProduct==0){
                suffixProduct = 1;

                sufixEndIndex = nums.length - 1 - i;
            }

            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length - 1 - i];
            if(Math.max(prefixProduct, suffixProduct)>maxProduct){
                maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
                if(prefixProduct == maxProduct){
                    prefixEndIndex = i;

                    ansStartIndex = prefixStartIndex;
                    ansEndIndex = prefixEndIndex;
                }
                if(suffixProduct == maxProduct){
                    sufixStartIndex = nums.length - 1 - i;

                    ansStartIndex = sufixStartIndex;
                    ansEndIndex = sufixEndIndex;
                }
            }


        }
        return product(Arrays.copyOfRange(nums, ansStartIndex, ansEndIndex+1), ansEndIndex-ansStartIndex+1);

    }


    public int maxProductOnly(int[] nums) {
        //if positive number of neagitive nums and remaining all are positive (non zero)
        //      then product of whole subarray
        // if we have odd number of neagitive numbers and remaing all are positive then
        // prefix product of neagive or suffix product of neagitive num
        //if any of the num is 0, then consider number before and after zero as diff array

        if(nums.length==0) return 0;
        int maxProduct = Integer.MIN_VALUE;
        int prefixProduct = 1;
        int suffixProduct = 1;

        for(int i = 0; i < nums.length; i++) {
            if(prefixProduct==0){
                prefixProduct = 1;
            }

            if(suffixProduct==0){
                suffixProduct = 1;
            }

            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));

        }
        return maxProduct;

    }
}

