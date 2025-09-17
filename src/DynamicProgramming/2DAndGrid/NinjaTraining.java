package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class NinjaTraining {
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
