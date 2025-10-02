package Recurssion.permutations;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> nNumbers=getNNumbers(n);
        List<Integer> nNumbersFactorials=getNNumbersFactorials(n);
        return getKthPermutationOfNNumbers(n, k-1, nNumbersFactorials, nNumbers);
    }

    private List<Integer> getNNumbers(int n) {
        List<Integer> nNumbers=new ArrayList<>();
        for(int i=1; i<=n; i++){
            nNumbers.add(i);
        }
        return nNumbers;
    }

    private List<Integer> getNNumbersFactorials(int n) {
        List<Integer> nNumbersFactorials=new ArrayList<>();
        int factorial=1;
        nNumbersFactorials.add(1);
        for (int i=1; i<=n; i++){
            factorial*=i;
            nNumbersFactorials.add(factorial);
        }
        return nNumbersFactorials;
    }

    private String getKthPermutationOfNNumbers(int n, int k, List<Integer> nNumbersFactorials, List<Integer> nNumbers) {
        String kthPermutation="";
        int ithIndex;
        for(int i=1; i<=n; i++){
            ithIndex = k / nNumbersFactorials.get(n-i);
            kthPermutation += String.valueOf(nNumbers.get(ithIndex));
            nNumbers.remove(ithIndex);
            k = k - ithIndex*nNumbersFactorials.get(n-i);
        }
        return kthPermutation;
    }
}
