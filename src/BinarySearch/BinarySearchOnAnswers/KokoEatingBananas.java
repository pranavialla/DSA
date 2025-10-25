package BinarySearch.BinarySearchOnAnswers;

public class KokoEatingBananas {
    
    public boolean isEatable(int[] piles,int h,int curSpeed){
        int totalTimeToEat=0;
        for(int pile : piles){
            totalTimeToEat += Math.ceil((double)pile/curSpeed);
        }
        return totalTimeToEat<=h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile=0;
        for(int pile : piles) maxPile = Math.max(maxPile, pile);
        int left = 1, right = maxPile, ans = -1;
        while(left<=right){
            int mid = left+ (right-left)/2;
            if(isEatable(piles, h, mid)){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return ans;  
    }
}
