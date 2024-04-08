import Arrays.ZeroMatrix;
import IOFiles.InputOutputNotes;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        //InputOutputNotes i= new InputOutputNotes();
        File inputFile = new File("src/IOFiles/Input.txt");
        File outputFile = new File("src/IOFiles/Output.txt");
        FileWriter outputWriter = new FileWriter(outputFile);
        Scanner input= new Scanner(inputFile);

        ZeroMatrix zeroMatrix=new ZeroMatrix(input, outputWriter);




    }
}