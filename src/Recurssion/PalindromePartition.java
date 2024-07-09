package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>>  getPalindromPartitions(String s) {
        List<List<String>> allPossiblePalindromePartitions = new ArrayList();
        List<String> possiblePalindromeParttion = new ArrayList();
        return getpartitionsByRecursion(0, s, allPossiblePalindromePartitions, possiblePalindromeParttion) ;
    }

    private List<List<String>> getpartitionsByRecursion(int startIndex, String s, List<List<String>> allPossiblePalindromePartitions, List<String> possiblePalindromeParttion) {
        if(startIndex==s.length()){
            allPossiblePalindromePartitions.add(new ArrayList<>(possiblePalindromeParttion));
            return allPossiblePalindromePartitions;
        }
        for(int i=startIndex; i<s.length(); i++){
            if(isPalindrome(s, startIndex, i)){
                possiblePalindromeParttion.add(s.substring(startIndex, i+1));
                getpartitionsByRecursion(i+1, s, allPossiblePalindromePartitions, possiblePalindromeParttion);
                possiblePalindromeParttion.remove(possiblePalindromeParttion.size()-1);
            }
        }
        return allPossiblePalindromePartitions;
    }

    private boolean isPalindrome(String s, int startIndex, int i) {
        int l=startIndex;
        int r=i;
        while( l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}