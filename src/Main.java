import java.io.*;
import java.util.Scanner;

import ArraysProblems.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //InputOutputNotes i= new InputOutputNotes();
        File inputFile = new File("src/IOFiles/Input.txt");
        File outputFile = new File("src/IOFiles/Output.txt");
        FileWriter outputWriter = new FileWriter(outputFile);
        Scanner input= new Scanner(inputFile);

        /*ZeroMatrix zeroMatrix = new ZeroMatrix(input, outputWriter);

        Permutations permutations = new Permutations(new int[]{1, 2, 434, 5, 56, 3, 2,});

        MaximumSubArray maximumSubArray = new MaximumSubArray();
        System.out.println(maximumSubArray.maxSubArray(new int[]{0, -1, -7, -4, 6, -2, 4}));

        SortColours sortColours= new SortColours(new int[]{2,0,2,1,1,0});

        BuyAndSellStockOnce buyAndSellStockOnce=new BuyAndSellStockOnce(new int[]{7,1,5,3,6,4});

        MergeIntergvals mergeIntergvals=new MergeIntergvals(new int[][]{{1,3},{2,6},{8,10},{15,18}});

        FindTheDuplicate findTheDuplicate=new FindTheDuplicate(new int[]{1,3,4,2,2});

        SerachATwoDMatrix serachATwoDMatrix = new SerachATwoDMatrix(new int[][]{{1,2,3,4,5}, {6,7,8,9,10}}, 8);

        PowerXtoN powerXtoN=new PowerXtoN(2.00000, -2147483648);
         UniquePaths u= new UniquePaths(3,7);

        LongestSubsequence longestSubsequence=new LongestSubsequence();
        int[] arr= {100,4,200,1,3,2};
        int i = longestSubsequence.calculateLongestSubsequence(arr);

        LargestSubsequenceWithZeroSum l= new LargestSubsequenceWithZeroSum();
        int[] arr={15,-2,2,-8,1,7,10,23};
        l.getLargestSubsequenceWithZeroSum(arr , 8);*/

        LongestSubStringWithOutRepetation longestSubStringWithOutRepetation=new LongestSubStringWithOutRepetation();
        longestSubStringWithOutRepetation.getLongestSubStringWithOutRepetation("abcabcbb");







    }
}

