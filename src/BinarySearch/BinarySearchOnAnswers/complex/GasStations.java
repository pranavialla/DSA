package BinarySearch.BinarySearchOnAnswers.complex;

import java.util.Arrays;

public class GasStations {
    
    public boolean isTrue(int[] distances , double K, double Maxdistance) {
        int pettrolBunkNeeded =0;
        //System.out.println(Arrays.toString(distances) + " "+Maxdistance);
        for( double curDistance : distances){
            pettrolBunkNeeded += Math.ceil(curDistance/Maxdistance)-1;
            if (pettrolBunkNeeded > K) return false;
            
        }
        //System.out.println("pettrolBunkNeeded : "+ pettrolBunkNeeded+" k : "+K);
        return pettrolBunkNeeded<=K;
    }
    
    
    public double minMaxDist(int[] stations, int K) {
        // code here
        
        if(stations.length==1){
            return 0.00;
        }
       int[] distances = new int[stations.length-1];
       for(int i=1; i<stations.length; i++){
        distances[i-1] = stations[i]- stations[i-1];}
        Arrays.sort(distances);
        
        double left = 0;
        double right = distances[distances.length-1];
        double ans = right;
        while(right-left>1e-6){
            double mid = left +( right-left)/2.0;
            
            boolean isTrue = isTrue(distances, K, mid);
            //System.out.println(" isTrue : "+isTrue + " left right:  "+left + " "+ right + " K, mid : "+K + " " +mid);
            if(isTrue){
                ans = mid;
                right  = mid;}
               
            else{
                left=mid;}
        }
        return  Math.round(ans * 100.0) / 100.0;
    }
}
