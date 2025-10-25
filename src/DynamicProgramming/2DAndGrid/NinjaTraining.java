package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class NinjaTraining {

    // Recusion + Memoization
    public int maximumPoints(int arr[][]) {
        // code here
        
        int totalDays = arr.length;
        if(totalDays==0) return 0;
        int activities =arr[0].length;
        
        //cordinate shift by 1
        int[][] memo = new int[totalDays+1][activities+1];
        for(int i=0; i<totalDays+1; i++ ) Arrays.fill(memo[i], -1);
        for(int i=1; i<activities+1; i++) memo[0][i]=0;
    
        return ninja(totalDays-1, -1, arr, memo);
    }
    
    int ninja(int day, int prevActivity, int[][] arr, int[][] memo){
        if(memo[day+1][prevActivity+1]!=-1) return memo[day+1][prevActivity+1];
    
        int maxPointsTillNow = Integer.MIN_VALUE;
        for(int curActivity=0; curActivity<arr[day].length; curActivity++){
            if(prevActivity != curActivity){
                int PointsByCurActivity = arr[day][curActivity] +  ninja( day-1,curActivity , arr, memo);
                maxPointsTillNow = Math.max( PointsByCurActivity , maxPointsTillNow);
            }
        }
        memo[day+1][prevActivity+1] = maxPointsTillNow;
        
        return maxPointsTillNow;
    }

     public int maximumPoints(int arr[][]) {
        // code here
        
        int totalDays = arr.length;
        if(totalDays==0) return 0;
        int activities =arr[0].length;
        
        //cordinate shift by 1
        int[][] memo = new int[totalDays+1][activities+1];
        for(int i=0; i<totalDays+1; i++ ) Arrays.fill(memo[i], -1);
        for(int i=1; i<activities+1; i++) memo[0][i]=0;
        
        //only shif the coordinate in memo not anywhere else for clarity
        // we only mostly use coordinate shift for the case where every state takes the cuurent
        // index to avoid outbound conditions
        for(int day = 0; day<totalDays ; day++ ){
            for(int prevActivity = 0; prevActivity<activities ; prevActivity++ ){
                int maxPointsTillNow = Integer.MIN_VALUE;
                for(int curActivity=0; curActivity<arr[day].length; curActivity++){
                    if(prevActivity != curActivity){
                        int PointsByCurActivity = arr[day][curActivity] + memo[day][curActivity+1];
                        maxPointsTillNow = Math.max( PointsByCurActivity , maxPointsTillNow);
                    }
                }
                memo[day+1][prevActivity+1] = maxPointsTillNow;
            }
        }
        
        //System.out.println(Arrays.deepToString(memo));
        int maxTotalPoint = Integer.MIN_VALUE;
        for(int i=1; i<activities+1; i++) maxTotalPoint=Math.max(maxTotalPoint, memo[totalDays][i]);
    
        return maxTotalPoint;
    }

    public static int ninja(int n, int points[][] ){
        int[] dp= new int[]{points[0][0], points[0][1], points[0][2]};
        for(int day=1; day<points.length; day++){
            ArrayList<Integer> temDP = new ArrayList<Integer>();
            for(int session=0; session<3; session++){
                int prevSessionOptimal = 0;
                int maxSessionPoints = 0;
                while (prevSessionOptimal!=3){
                    if(session==prevSessionOptimal){
                        prevSessionOptimal+=1;
                        continue;
                    }
                    maxSessionPoints = Math.max(dp[prevSessionOptimal] + points[day][session], maxSessionPoints);
                    prevSessionOptimal+=1;
                }
                temDP.add(maxSessionPoints);
            }
            dp= new int[]{temDP.get(0), temDP.get(1), temDP.get(2)};

        }
    return   Arrays.stream(dp).max().getAsInt();
    }

}
