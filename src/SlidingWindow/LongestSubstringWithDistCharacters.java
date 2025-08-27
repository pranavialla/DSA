class LongestSubstringWithDistCharacters {
    public int longestUniqueSubstr(String s) {
        // code here
        int start =0;
        int end =0;
        
        int longestSubStringWithDistinctChar = Integer.MIN_VALUE;
        
        int[] Map = new int[128];
        
        while(end<s.length()){
            
            char c = s.charAt(end);
            Map[c]++;
            
            while(start<end && Map[c]>1){
                
                char cr= s.charAt(start);
                Map[cr]--;
                start++;
            }
            longestSubStringWithDistinctChar = Math.max(longestSubStringWithDistinctChar, end-start+1);
            //System.out.println(start + " "+ end +" "+ longestSubStringWithDistinctChar + " " );
            end++;
        }
        return longestSubStringWithDistinctChar;
    }
}