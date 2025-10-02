package TwoPointers;

class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        int l=0, count =0, result = -1;
        int[] freq = new int[26];
        for(int r=0; r<n; r++){
            char cur = s.charAt(r);
            freq[cur-'a']++;
            if(freq[cur-'a']==1) count++;
            while(count >k){
                char prev = s.charAt(l);
                freq[prev-'a']--;
                if(freq[prev-'a']==0) count--;
                l++;
            }
            if (count==k) result = Math.max(result, r-l+1);
        }
        return result;
        
    }
}