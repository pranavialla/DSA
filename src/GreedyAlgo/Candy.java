package GreedyAlgo;

//https://leetcode.com/problems/candy/
public class Candy {
    public int candy(int[] ratings) {
        int i = 1;
        int totolChoclates = 1;
        int n = ratings.length;
        while (i < n) {
            while (i < n && ratings[i] == ratings[i - 1]) {
                totolChoclates += 1;
                i++;
            }
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                totolChoclates += peak;
                i++;
            }

            int down = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                down++;
                totolChoclates += down;
                i++;
            }

            totolChoclates += down + 1 > peak ? down + 1 - peak : 0;
        }
        return totolChoclates;
    }
}