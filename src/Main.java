import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import BinarySearch.MediumInRowWiseSortedMatrix;
import BinarySearch.NthRootOfM;
import GreedyAlgo.MinimumPlatforms;
import Recurssion.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //InputOutputNotes i= new InputOutputNotes();
        File inputFile = new File("src/IOFiles/Input.txt");
        File outputFile = new File("src/IOFiles/Output.txt");
        FileWriter outputWriter = new FileWriter(outputFile);
        Scanner input = new Scanner(inputFile);

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
        l.getLargestSubsequenceWithZeroSum(arr , 8);

        LongestSubStringWithOutRepetation longestSubStringWithOutRepetation=new LongestSubStringWithOutRepetation();
        longestSubStringWithOutRepetation.getLongestSubStringWithOutRepetation("abcabcbb");

        ReverseLinkedList r=new ReverseLinkedList();
        LinkedList linkedList=new LinkedList();

        Node n1=new Node(11);
        Node n2=new Node(12);
        n1.next=n2;
        Node n3=new Node(13);
        n2.next=n3;
        Node n4=new Node(14);
        n3.next=n4;
        Node n5=new Node(15);
        n4.next=n5;

        linkedList.head=n1;
//        MiddleOfLinkedList middleOfLinkedList=new MiddleOfLinkedList();
//        middleOfLinkedList.getMiddleOdLinkedList(linkedList.head);
//        r.getReverseLinkedList(linkedList.head);

        MergeLinkedList mergeLinkedList=new MergeLinkedList();


        LinkedList linkedList2=new LinkedList();

        Node n6=new Node(6);
        Node n7=new Node(7);
         n6.next=n7;
         linkedList2.head=n6;
        mergeLinkedList.getMergedLinkedList(linkedList.head, linkedList2.head );

        NthFromLastNode nthFromLastNode=new NthFromLastNode();
        nthFromLastNode.getnthFromLastNode(linkedList.head, 2);


        //copy ll
        Node n1=new Node(11);
        Node n2=new Node(12);
        n1.next=n2;
        Node n3=new Node(13);
        n2.next=n3;
        Node n4=new Node(14);
        n4.random=n1;
        n1.random=n3;
        traverseLinkedList(n1);
        CopyLinkedList copyLinkedList=new CopyLinkedList();
        Map<Node, Node> memory=new HashMap<Node, Node>();
        Node ans=copyLinkedList.callingMyself(memory, n1) ;
        traverseLinkedList(ans);
        int[] arr=new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] dep=new int[]{910, 1200, 1120, 1130, 1900, 2000};
        MinimumPlatforms minimumPlatforms = new MinimumPlatforms(arr, dep, 6 );
        CombinationSum combinationSum=new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7).size());
        PalindromePartition palindromePartition=new PalindromePartition();
        System.out.println(palindromePartition.getPalindromPartitions("aab").size());

        KthPermutationSequence kthPermutationSequence=new KthPermutationSequence();
        System.out.println(kthPermutationSequence.getPermutation(3,3));
        AllPermutations permutations = new AllPermutations();
        permutations.permute(new int[]{1,2,3,4,5});
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.getNQueensAllPossiblePositions(1).size());
        Sudoko sudoko = new Sudoko();
        char[][] board =  new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        sudoko.sudokoSolver(board);


        MColoring mColoring = new MColoring();
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {0, 2}};
        int n = 2;
        boolean[][] graph = new boolean[n+1][n+1];
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = true;
            graph[edges[i][1]][edges[i][0]] = true;
        }
        System.out.println(mColoring.isColouringWithMColorsPossible(graph, 2, 3));

        //1 0 0 0 1 1 0 1 1 1 0 0 0 1 1 1

        RatInTheMaze ratInTheMaze = new RatInTheMaze();
        int[][] maze = new int[][]{{1, 0, 0, 0},
                                   {1, 0, 1, 1},
                                   {1, 1, 0, 0},
                                   {0, 1, 1, 1}};
        ratInTheMaze.findPath(maze, 4);


        //god is now no where here
        //godisnowherenowhere
        WordBreak wordBreak =  new WordBreak();
        ArrayList<String> dictionary =  new ArrayList<>();
        dictionary.add("god");
        dictionary.add("is");
        dictionary.add("now");
        dictionary.add("no");
        dictionary.add("where");
        dictionary.add("here");
       System.out.println(wordBreak.wordBreak("godisnowherenowhere",  dictionary));
        NthRootOfM nthRootOfM = new NthRootOfM();
        nthRootOfM.getNthRootOfM(4, 1);*/
        MediumInRowWiseSortedMatrix mediumInRowWiseSortedMatrix = new MediumInRowWiseSortedMatrix();
        int[][]  matrix =  {{1, 3, 5},{2, 6, 9},{3, 6, 9}};
;       mediumInRowWiseSortedMatrix.mediumInRowWiseSortedMatrix(matrix, 3, 3);

    }

}

