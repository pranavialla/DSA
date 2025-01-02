package String;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int l =  s.length();
        for(int i=l; i>=1; i--){
            for( int j=0; j+i<=l; j++ ){
                StringBuilder substr = new StringBuilder(s.substring(j, j+i));
                //StringBuilder rsubstr = new StringBuilder(s.substring(j, j+i));
                //rsubstr.reverse();
                // System.out.println("i : " + i + " j : "+ j + " substr : " + substr.toString());
                // System.out.println("rsubstr : " + rsubstr.toString());
                // System.out.println("substr.toString() : " + substr.toString());
                // System.out.println("rsubstr.toString().equals(substr.toString()) : " + rsubstr.toString().equals(substr.toString()));
                
                if(isPal(substr)){
                    return substr.toString();
                }
            }
        }
        return "";
    }

    public boolean isPal(StringBuilder st){
        int s =0;
        int e = st.length()-1;
        while(s<e){
            if(st.charAt(s++)!=st.charAt(e--)){
                return false;
            }
        }
        return true;
    }
}
