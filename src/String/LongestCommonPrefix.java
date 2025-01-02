package String;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String minString = findMinLengthString(strs);

        for( int i=0; i< minString.length(); i++){
            for(String str : strs){
                if( str.charAt(i)!=minString.charAt(i)){
                    return str.substring(0, i);
                }
            }
        } 
        return minString;
        
    }

    public String findMinLengthString(String[] strs){
        String cur  = strs[0];

        for( String str : strs){
            if(str.length()<cur.length()){
                cur = str;
            }
        }
        return cur;
    }


    public String longestCommonPrefix1(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
