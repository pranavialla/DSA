package BinarySearch.BinarySearchOnAnswers;

class SolutiMinimumDaysToMakeBouquetson {
    public boolean ismakable(int[] bloomDay, int m, int k, int curDays) {
        int totalBouquets = m;
        int FlowersCollected = 0;
        for( int day : bloomDay){
            if(day<=curDays){
                FlowersCollected +=1;
                if(FlowersCollected ==k){
                    totalBouquets-=1;
                    FlowersCollected = 0;
                } 
            }
            else{
                FlowersCollected =0;
            }        
        }
        return totalBouquets<=0;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int ans = -1;

        int maxBloomDay = 0;
        for(int day : bloomDay ) maxBloomDay =  Math.max(maxBloomDay, day);
        
        int left = 1 ,right = maxBloomDay;

        while(left<=right){
            int mid= left + (right-left)/2;

            if(ismakable( bloomDay,  m, k, mid)){
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