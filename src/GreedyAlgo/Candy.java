package GreedyAlgo;

//https://leetcode.com/problems/candy/
public class Candy {

    //as we have constrasnt as choclates can't be 0
    /*
        Intuition:
        1. We need to ensure that each child gets at least one chocolate.
        2. We can traverse the ratings array from left to right and then from right to left to ensure that the conditions are met.
        3. In the first pass (left to right), we ensure that each child has more chocolates than the previous child if their rating is higher.
        4. In the second pass (right to left), we ensure that each child has more chocolates than the next child if their rating is higher.
        5. Finally, we sum up the chocolates given to each child.
    
        Algorithm:
        1. Initialize an array `chocolates` of the same length as `ratings` with all values set to 1 (each child gets at least one chocolate).
        2. Traverse the `ratings` array from left to right:
            - If `ratings[i] > ratings[i - 1]`, then set `chocolates[i] = chocolates[i - 1] + 1`.
        3. Traverse the `ratings` array from right to left:
            - If `ratings[i] > ratings[i + 1]`, then set `chocolates[i] = max(chocolates[i], chocolates[i + 1] + 1)`.
        4. Sum up all values in the `chocolates` array to get the total number of chocolates needed.
    
        Time Complexity: O(n)
        Space Complexity: O(n)


        Better Approach: O(1) space
        1. We can optimize the space complexity by using two variables to keep track of the increasing and decreasing sequences.
        2. We can maintain a variable `peak` to track the highest number of chocolates given in an increasing sequence.
        3. We can maintain a variable `down` to track the length of the current decreasing sequence.
        as number of choclates can't be 0 we get into problem when we have a longer decreasing sequence longer than the value where decreasing starts
        4. We can adjust the                total chocolates based on the lengths of these sequences.
        5. This way, we can achieve the same result with O(1) additional space.
        Time Complexity: O(n)
        Space Complexity: O(1)
    
    */
    public int candy(int[] ratings) {
        int peak = 0, down = 0, totalChoclates = 0, i=0, n=ratings.length;
        if(ratings.length==0) return totalChoclates;

        //as we're starting with 1 for increasing slope, decreasing slope (as we're only considering count), 0 slope 
        totalChoclates=1;
        i=1;

        while(i<ratings.length){

            peak=1;
            while(i<n && ratings[i]==ratings[i-1]){
                totalChoclates+=1;
                i++;
            }

            // cur is greater than prev. all valleys start with 1. so, prev ( peak is 1)
            while(i<n && ratings[i]>ratings[i-1]){
                peak+=1;
                totalChoclates+=peak;
                i++;
            }

            down = 1;
            while(i<n && ratings[i]<ratings[i-1]){
                totalChoclates+=down;
                down++;
                i++;
            }
            System.out.println(totalChoclates);

            totalChoclates += down > peak ? down-peak : 0;
        }

        return totalChoclates;
    }
}