import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

import LinkedListProblems.reverseKGrooup;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] slidingWindowMedian = new double[nums.length-k];
        Comparator<Integer> comparator = new Comparator<>(){
        
            public int compare(Integer i1, Integer i2){
                if(nums[i1]>nums[i2]){
                    return 1;
                }
                else if(nums[i1]<nums[i2]){
                    return -1;
                }
                return -Integer.compare(i1, i2);
            }
        };

        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);

        for(int i=0; i<k; i++){
            left.add(i);
        }

        findMedian(nums, slidingWindowMedian, left, right, k, k);
        Balance(left, right);
        for( int i=k; i<nums.length; i++){
            if(i-k<nums.length){
                left.remove(i-k);
                right.remove(i-k);
            }
            left.add(i);
            Balance(left, right);
            findMedian(nums, slidingWindowMedian, left, right,k, i);
        }

        return slidingWindowMedian;

    }

    public void findMedian(int[] nums,  double[] slidingWindowMedian, TreeSet<Integer> left, TreeSet<Integer> right, int k, int i){
        if(k%2==0){
            slidingWindowMedian[i-k] = (nums[left.last()]+nums[right.first()])/2;
        }
        else{
            slidingWindowMedian[i-k]= nums[right.first()];
        }
    }

    void Balance(TreeSet<Integer> left, TreeSet<Integer> right){
        while(left.size()>right.size()){
            right.add(left.pollLast());
        }


    }

}
