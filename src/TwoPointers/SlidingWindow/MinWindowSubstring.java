class MinWindowSubstring {
    public String minWindow(String s, String t) {
        /*
        */
        // s= s.toUpperCase();
        // t= t.toUpperCase();
        String result = "";
        int m = s.length(), n = t.length();
        int[] freq = new int[128];
        int l=0, minLenStart=0, minlen=-1;
        int charNeedToGet = t.length();
        for(int i=0; i<n; i++){
            
            freq[t.charAt(i)-'A']++;
        }
        for(int r=0; r<m; r++){
            int asci = s.charAt(r)-'A';
            if(freq[asci]>0){
                charNeedToGet-=1;
            }
            freq[asci]-=1;
            if(charNeedToGet==0){
                while(charNeedToGet==0){
                   
                    if(minlen==-1 || minlen>r-l+1){
                        minLenStart=l;
                        minlen=r-l+1;
                    }
                    asci = s.charAt(l++)-'A';
                    if(freq[asci]==0){
                        charNeedToGet+=1;
                    }
                    freq[asci]+=1;
                }
            }
        }  
        return minlen==-1? "" : s.substring(minLenStart, minLenStart+minlen);
    }
}