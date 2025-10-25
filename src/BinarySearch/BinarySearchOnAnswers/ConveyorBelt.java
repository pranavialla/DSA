package BinarySearch.BinarySearchOnAnswers;

public class ConveyorBelt {

    public boolean willItBeShippedInDDays(int[] weights, int days, int maxWeight){
        int curWeight =0 ;
        for(int weight : weights){
            curWeight+=weight;
            if(curWeight>=maxWeight){
                days-=1;
                if(curWeight == maxWeight ) curWeight = 0 ;
                else curWeight = weight ;
            }
        }
        if(curWeight > 0 ) return days-1>=0;
        return days>=0;
    }

    public int shipWithinDays(int[] weights, int days) {
        int minWeight=0;
        int totalWeight =0;
       for(int weight : weights){
            minWeight = Math.max(minWeight, weight);
            totalWeight+= weight;
       } 
        int left = minWeight, right = totalWeight, ans = -1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(willItBeShippedInDDays(weights, days, mid)){
                ans = mid;
                right = mid-1;}
            else{
                left= mid+1;}
        }
        return ans;
    }

}
