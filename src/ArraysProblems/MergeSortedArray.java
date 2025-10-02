

import java.util.Arrays;

public class MergeSortedArray {
    MergeSortedArray(int[] nums1, int m, int[] nums2, int n){
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(j>=0 ){
            if(i>-1 && nums1[i]>nums2[j]){
                nums1[k--]=nums1[i--];
            }else{
                nums1[k--]=nums2[j--];
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=0;
        while(i >=0  && j<n && nums1[i]>nums2[j]  ){
            int temp = nums1[i];
            nums1[i] = nums2[j];
            nums2[j] = temp;
            i--;
            j++;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

    }



}
