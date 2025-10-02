

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> subsetsWithDuplicates=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        Arrays.sort(candidates);
        return getsubsetWithTargetT(candidates, subsetsWithDuplicates, subset, 0, 0, target);
    }

    private List<List<Integer>> getsubsetWithTargetT(int[] candidates, List<List<Integer>> allSubbsetsWithTargetT, List<Integer> subset, int startIndex, int subsetSum, int target) {
        if (subsetSum<target){
            for(int i=startIndex; i<candidates.length; i++){
                subset.add(candidates[i]);
                subsetSum+=candidates[i];
                if (subsetSum==target) {
                    List<Integer> subsetWithTargetSum = new ArrayList<>(subset);
                    allSubbsetsWithTargetT.add(subsetWithTargetSum);
                }
                getsubsetWithTargetT(candidates,allSubbsetsWithTargetT ,  subset, i+1,subsetSum, target);
                subsetSum-=candidates[i];
                subset.remove(subset.size()-1);
            }
        }
        return allSubbsetsWithTargetT;
    }

    public List<List<Integer>> combinationSumConsideringElementNTimes(int[] candidates, int target) {
        List<List<Integer>> subsetsWithDuplicates=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        return  getsubsetWithTargetTConsideringElementNTimes(candidates, subsetsWithDuplicates, subset, 0, target, 0);
    }

    private List<List<Integer>> getsubsetWithTargetTConsideringElementNTimes(int[] candidates, List<List<Integer>> allSubbsetsWithTargetT, List<Integer> subset, int subsetSum, int target, int startIndex) {
        if (subsetSum==target) {
            List<Integer> subsetWithTargetSum = new ArrayList<>(subset);
            allSubbsetsWithTargetT.add(subsetWithTargetSum);
        }
        else if (subsetSum<target){
            for(int i=startIndex; i<candidates.length; i++){
                subset.add(candidates[i]);
                subsetSum+=candidates[i];
                getsubsetWithTargetTConsideringElementNTimes(candidates,allSubbsetsWithTargetT ,subset ,subsetSum, target, i);
                subsetSum-=candidates[i];
                subset.remove(subset.size()-1);
            }
        }
        return allSubbsetsWithTargetT;
    }


    public List<List<Integer>> combinationSumConsideringElementOneTime(int[] candidates, int target) {
        List<List<Integer>> subsetsWithDuplicates=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        Arrays.sort(candidates);
        return  getsubsetWithTargetTConsideringElementOneTime(candidates, subsetsWithDuplicates, subset, 0, target, 0);
    }

    private List<List<Integer>> getsubsetWithTargetTConsideringElementOneTime(int[] candidates, List<List<Integer>> allSubbsetsWithTargetT, List<Integer> subset, int subsetSum, int target, int startIndex) {
        if (subsetSum==target) {
            List<Integer> subsetWithTargetSum = new ArrayList<>(subset);
            Arrays.sort(candidates);
            allSubbsetsWithTargetT.add(subsetWithTargetSum);
        }
        else if (subsetSum<target){
            for(int i=startIndex; i<candidates.length; i++){
                if(i==0 || (i!=0 & candidates[i]!=candidates[i-1]))
                subset.add(candidates[i]);
                subsetSum+=candidates[i];
                getsubsetWithTargetTConsideringElementOneTime(candidates,allSubbsetsWithTargetT ,subset ,subsetSum, target, i+1);
                subsetSum-=candidates[i];
                subset.remove(subset.size()-1);
            }
        }
        return allSubbsetsWithTargetT;
    }
}
