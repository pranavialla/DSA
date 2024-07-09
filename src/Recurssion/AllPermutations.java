package Recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> curProcessingPermutation= getArrayListFromArray(nums);
        return getPermutations(0, curProcessingPermutation, permutations);


    }

    private List<Integer> getArrayListFromArray(int[] nums) {
        List<Integer> numsCopy = new ArrayList<>();
        for(Integer num : nums){
            numsCopy.add(num);
        }
        return numsCopy;
    }

    private List<List<Integer>> getPermutations(int startIndex, List<Integer> curProcessingPermutation, List<List<Integer>> permutations) {
        if(startIndex==curProcessingPermutation.size()){
            permutations.add(new ArrayList<>(curProcessingPermutation));
        }
        for(int i=startIndex; i<curProcessingPermutation.size(); i++){
            swap(curProcessingPermutation, startIndex, i);
            getPermutations(startIndex+1, curProcessingPermutation, permutations);
            swap(curProcessingPermutation, i, startIndex);
        }
        return permutations;
    }

    private void swap(List<Integer> curProcessingPermutation, Integer l, Integer r){
        Integer temp = curProcessingPermutation.get(l) ;
        curProcessingPermutation.set(l, curProcessingPermutation.get(r));
        curProcessingPermutation.set(r, temp);
    }
}
