package Recurssion.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//This check works only if the array is sorted and you never swap elements in a way that breaks the sorted order for the remaining part of the list. But since you swap elements during recursion, the later part of the list may no longer be sorted, so curProcessingPermutation.get(i) != curProcessingPermutation.get(i - 1) is not a reliable duplicate check anymore.

class PermutationWithDuplicates {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> curProcessingPermutation= getArrayListFromArray(nums);
       
        getPermutations(0, curProcessingPermutation, permutations);
        return permutations;
    }

    private List<Integer> getArrayListFromArray(int[] nums) {
        List<Integer> numsCopy = new ArrayList<>();
        for(Integer num : nums){
            numsCopy.add(num);
        }
        return numsCopy;
    }

    private void getPermutations(int startIndex, List<Integer> curProcessingPermutation, List<List<Integer>> permutations) {
        if(startIndex==curProcessingPermutation.size()){
            permutations.add(new ArrayList<>(curProcessingPermutation));
        }
        HashSet<Integer> used = new HashSet<>();
        for(int i=startIndex; i<curProcessingPermutation.size(); i++){
            
            if(used.contains(curProcessingPermutation.get(i))) continue;
            
            used.add(curProcessingPermutation.get(i));
            swap(curProcessingPermutation, startIndex, i);
            getPermutations(startIndex+1, curProcessingPermutation, permutations);
            swap(curProcessingPermutation, i, startIndex);
            
        }
        return ;
    }

    private void swap(List<Integer> curProcessingPermutation, Integer l, Integer r){
        Integer temp = curProcessingPermutation.get(l) ;
        curProcessingPermutation.set(l, curProcessingPermutation.get(r));
        curProcessingPermutation.set(r, temp);
    }
}