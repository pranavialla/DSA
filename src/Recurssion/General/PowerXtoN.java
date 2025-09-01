class PowerXtoN {

    /*
        handle both x negative case and n negaative case

        when converting n neagative to positive handle int overflow condition with long

        try to minimise recursions call as possible as we caculate same thing numtiple time (instead of having separate functions for 
        n%2==0 and n%2!=0)
    
    
    */
    public double myPow(double x, int n) {
            if(n>0){
                return Pow( x,  n);
            }
            return Pow( 1/x,  -1*n);
    }

    public double Pow(double x, long n) {
        if (n==0) return 1 ;
        double ans = Pow(x, n/2);
        if(n%2==0){   
            return  ans*ans;
        }
        return  x * ans* ans;
    }
}

