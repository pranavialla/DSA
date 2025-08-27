class MinWindowSubstringInSHavingAllT {
    public String minWindow(String s, String t) {
        int[] freqMap = new int[128];

        for(char ct : t.toCharArray()){
            freqMap[ct]++;
        }

        int start = 0, end =0 ,count=t.length(), min_start=0, min_window = Integer.MAX_VALUE;

        while(end<s.length()){

            char cs = s.charAt(end);
            if(freqMap[cs]>0) count--;
            freqMap[cs]--;
            end++;

            while(count==0){

                if(min_window>end-start){
                    min_start =  start;
                    min_window = end-start;
                }
                
                char charToRemove = s.charAt(start);

                //if it is equal to 0 that that char is required in t
                if(freqMap[charToRemove]==0) count++;
                freqMap[charToRemove]++;
                start++;
            }
            
        }

        return (min_window == Integer.MAX_VALUE ? "" : s.substring(min_start, min_start+min_window));
    }
}