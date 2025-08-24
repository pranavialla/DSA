class MultiplyTwoNums {
    public String multiplyStrings(String s1, String s2) {
        // code here
        /*
        finalSign = 1
        1. compute final number sign
            if (s1.charAt(0)=='-')
                finalSign*=-1
        2. remove trailing 0 and identify if any number is 0
        3. multiply num
        4. reverse num
        */
        int s1_index = 0;
        int s2_index = 0;
        
        int finalSign = 1;
        if(s1.charAt(s1_index)=='-'){
            finalSign*=-1;
            s1_index++;
        }
        if(s2.charAt(s2_index)=='-'){
            finalSign*=-1;
            s2_index++;
        }
        
        while(s1_index<s1.length() && s1.charAt(s1_index)=='0'){
            s1_index++;
        }
        
        while(s2_index<s2.length() && s2.charAt(s2_index)=='0'){
            s2_index++;
        }
        
        if(s1_index>s1.length()-1 || s2_index>s2.length()-1){
            return "0";
        }
        int n = s1.length();
        int m = s2.length();
        
        //System.out.println(n + " "+m+" "+ s1_index + " " + s2_index);
        
        int[] res = new int[n-s1_index + m-s2_index];
        //System.out.println(res.length-1);
        for( int i= n-1 ; i>=s1_index; i-- ){
            int d1 = s1.charAt(i)-'0';
            for( int j= m-1 ; j>=s2_index; j-- ){
                int d2 = s2.charAt(j)-'0';
                
                int p1 = i-s1_index + j-s2_index;
                int p2 = p1 + 1;
                int ms = d1*d2 +  res[p2];
                
                //System.out.println("p2 : " + p2 + " p1:  " + p1);
                //System.out.println("p2 = " + res[p2] + ms/10 + " p1=   " + ms%10);
                res[p1] += ms/10;
                res[p2] = ms%10; 
            }
        }
        
        //System.out.println("res-----"+Arrays.toString(res));
        String mul = "";
        int i=0;
        boolean leadingZero = true;
        while(i<res.length){
            if(res[i]==0 && leadingZero){
                i++;
                continue;
            } 
            leadingZero = false;
            mul += res[i];
            i++;
        }
        
        //System.out.println(mul);
        return (finalSign == -1 ? "-" : "") + (mul.length() == 0 ? "0" : mul);
                
    }
}