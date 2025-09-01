class Solution {
    public static int mod = 1000000007;
    public int countGoodNumbers(long n) {

        /*
            1.even - 0, 2, 4, 6, 8 - 5
            2. prime - 2, 3 ,5, 7 -> 4

            common nums 2

            n- 2
            0 -> 5
            1 -> 4


            n number -> n%2==0 -> even -> n/2, odd ->n/2
                            !=0 -> even -> n/2, odd ->n/2 +1

            
            even -> 5^n+1/2
            odd ->  4^(n/2)

            if 
            Pow(5, n/2 )*5 

            if n is even -> Pow(5, (n+1)/2 )*5  *  Pow(4, n/2 )
            if n is odd -> Pow(5, (n+1)/2 ) * Pow(4, n/2 )


        */
        if (n==0){
            return 0;
        }
        //int mod = 1000000007;
        if(n%2==0){
            return (int) (((Pow(5, n/2 ) *  Pow(4, n/2 )))%mod);
        }
        else{
            return (int) ((((Pow(5, (n+1)/2 )) *  (Pow(4, n/2 ))))%mod);
        }
        
    }


    public  long Pow(long x, long n){
        // long mod = 1000000007;
        
        x%=mod;

        if(n==0){
            return 1;
        }
        long half = Pow(x,n/2);
        if(n%2==0){  
            return  (half*half)%mod;
        }
        //System.out.println(half);
        return  (((half*half)%mod)*x)%mod;

    }
}