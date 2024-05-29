package ArraysProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithOutRepetation {
    public  int getLongestSubStringWithOutRepetation(String s){
        int maxLongestSubstringWithOutRepetation=0;
        Map<Character, Integer> Hash=new HashMap<>();
        Integer start=0;
        Integer i=0;
        while (i<s.length()){
            if(Hash.containsKey((Character) s.charAt(i))){
                //if start is greater than Hash.get((Character) s.charAt(i))+1 then it is not in the current substring so start won't change else it change to that index plus 1
                start=Math.max(Hash.get((Character) s.charAt(i))+1, start) ;}
            maxLongestSubstringWithOutRepetation=Math.max(maxLongestSubstringWithOutRepetation,i-start+1);
            Hash.put((Character) s.charAt(i),i);
            i+=1;

        }
        return maxLongestSubstringWithOutRepetation;
    }
}
