

import java.util.ArrayList;
import java.util.Collections;

public class SubSetsSum {
    public ArrayList<Integer> getSubsetsSum(ArrayList<Integer> arr, int n){
            ArrayList<Integer> subSetsSum=new ArrayList<>();
            subSetsSum.add(0);
            for(int index=0; index<n; index++){
                for(int subsetIndex=0; subsetIndex<Math.pow(2, index) ; subsetIndex++){
                    subSetsSum.add((int) (Math.pow(2, index)+subsetIndex), subSetsSum.get(subsetIndex)+arr.get(index));
                }
            }
            return subSetsSum;

    }
}
