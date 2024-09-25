package GreedyAlgo.JobSequencingProblem;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
public class JobSequencingProblem {

    public int[] maxProfitSequencing(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (job1, job2)->job2.profit-job1.profit);
        int lastWorkingDay=0;
        for (int id=0; id<arr.length; id++){
            lastWorkingDay=Math.max(arr[id].deadline, lastWorkingDay);
        }
        int totalProfit=0;
        int numOfJobsDone=0;
        int[] timeTable= new int[lastWorkingDay+1];
        Arrays.fill(timeTable, -1);
        for(int id=0; id<arr.length; id++){
            for(int date=arr[id].deadline; date>0; date--){
                if(timeTable[date]==-1){
                    totalProfit+=arr[id].profit;
                    timeTable[date]=id;
                    numOfJobsDone+=1;
                    break;
                }
            }
        }
        int ans[] = new int[2];
        ans[0]=numOfJobsDone;
        ans[1]=totalProfit;
        return ans;
    }
}
