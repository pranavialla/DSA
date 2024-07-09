package BinarySearch;

public class NthRootOfM {
    public void getNthRootOfM(int n, int m){
        System.out.println(BinarySearchToFindNthRoot( n, m));

    }

    private int BinarySearchToFindNthRoot(int n, int value) {
        int left=1;
        int right = value;
        while (left<=right){
            int mid = (left + right)/2;
            System.out.println("mid : "+mid);
            int result = Power(mid, n, value);

            if (result==1){
                return mid;
            }else if(result ==2){
                right = mid - 1;
            } else {
                left = mid+1;
            }
            System.out.println(left + " "+ right);
        }
        return -1;
    }


    private int Power(int mid, int n, int value) {
        long ans = 1 ;
        for (int i=1; i<=n; i++){
            ans = ans*mid;
            System.out.println("ans : "+ans);
            if(ans > value){
                return 2;
            }
        }
        if(ans==value){
            return 1;
        }
        return 0;
    }
}
