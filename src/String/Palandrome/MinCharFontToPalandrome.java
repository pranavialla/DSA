package String.Palandrome;

public class MinCharFontToPalandrome {

    
        public int solve(String A) {
            int l = A.length();
            int maxpaldromeLength = 1;
            if(l%2!=0){
                maxpaldromeLength = 1;
                
            }
            
            for(int i =1 ; i<l; i++){
                StringBuilder curString = new StringBuilder(A.substring(0, i+1));
                if((curString.toString()).equals((curString.reverse()).toString())){
                    maxpaldromeLength = curString.length();
                }
            }
            
            return l-maxpaldromeLength;
        }
}