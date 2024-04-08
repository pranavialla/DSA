package IOFiles;

import java.io.*;
import java.util.Scanner;
import java.io.*;
import java.util.Scanner;

public class InputOutputNotes {
    public InputOutputNotes() throws IOException {

        /*
         * we can take inputs from the input file or console by 2 ways
         *
         * 1. Scanner class
         * 2. BufferReader class
         */


        /* 1. Scanner
         *   a. it'll parse the input from the console or a file. parsing meaning taking the raw data and analysing them to a primitive
         *      type
         *   b. Asynchronous so not thread safe
         *   c. smaller buffer memory compared to BufferReader
         *   d. present in java.util package which are not imported in system files so need to import manually
         *   c. Scanner reads files as tokenized input (as a small amount at a time ). token is a group of characters
         *      separated by white spaces.
         *           eg: i'm girl .
         *               this above example have 2 tokens.
         *  d. Need to send InputReader type source to the scanner class constructor
         *  e."in" static variable in system class of type InputReader is used to read the input from the console which
         *      is by default open and connected to input stream like keyboard or any other source
         * * */

        File inputFile = new File("src/IOFiles/Input.txt");
        File outputFile = new File("src/IOFiles/Output.txt");

        /*
        to read input from keyboard or input devises we use system.in
        * */
        Scanner consoleInput = new Scanner(System.in);
        Scanner fileInput = new Scanner(inputFile);

        /*
         *   Methods to read Input from Scanner class
         *   a. nextLine - retuns a line from the input as a string and comsu,me next line character \n
         *   b. next     - returns 1 word as a string
         */
        String textInALine = fileInput.nextLine();
        System.out.println("nextLine :"+ textInALine);

        String nextWordTillWhitespace = fileInput.next();
        System.out.println(".next() :"+ nextWordTillWhitespace);

        nextWordTillWhitespace = fileInput.next();
        System.out.println(".next() :"+ nextWordTillWhitespace);

        /*
        to take the  \n we need to use nextLine method or else cursor will be in same line as throw error as there is no
        string present

        nextWordTillWhitespace = fileInput.next();
        System.out.println(".next() :"+ nextWordTillWhitespace);
        */
        fileInput.nextLine();


        /*
        * scanner.nextInt() - returns one word as an integer
          scanner.nextDouble() - returns one word as an integer
          scanner.nextFloat() - returns one word as an integer
          scanner.nextBoolean() - returns one word as an integer
        * */
        int number = fileInput.nextInt();
        System.out.println(".nextInt() :"+ number);

        double doubleNumber = fileInput.nextDouble();
        System.out.println(".nextDouble() :"+ doubleNumber);

        doubleNumber = fileInput.nextDouble();
        System.out.println(".nextDouble() :"+ doubleNumber);

        doubleNumber = fileInput.nextDouble();
        System.out.println(".nextDouble() :"+ doubleNumber);

        float floatNumber = fileInput.nextFloat();
        System.out.println(".nextFloat() :"+ floatNumber);

        floatNumber = fileInput.nextFloat();
        System.out.println(".nextFloat() :"+ floatNumber);

        boolean booleanNumber = fileInput.nextBoolean();
        System.out.println(".nextBoolean() :"+ booleanNumber);

        booleanNumber = fileInput.nextBoolean();
        System.out.println(".nextBoolean() :"+ booleanNumber);



        /*
        the above methods will throw exception if we won't get the expected data type from the input source so
        to check this we use below methods that return boolean if they are present
            scanner.hasNextLine() - returns one word as a String
            scanner.hasNext() - returns one word as a String
            scanner.hasNextInt() - returns one word as an integer
            scanner.hasNextDouble() - returns one word as an integer
            scanner.hasNextFloat() - returns one word as an integer
            scanner.hasNextBoolean() - returns one word as an integer
        * */

        textInALine = fileInput.nextLine();

        Boolean istLinePresent = fileInput.hasNextLine();
        System.out.println("isLinePresent :"+ istLinePresent);

        Boolean isWordPresent = fileInput.hasNext();
        System.out.println("isWordPresent :"+ isWordPresent);

        Boolean isNumberPresent = fileInput.hasNextInt();
        System.out.println("isNumberPresent :"+ isNumberPresent);

        Boolean isDoubleNumberPresent = fileInput.hasNextDouble();
        System.out.println("isDoubleNumberPresent :"+ isDoubleNumberPresent);

        Boolean isFloatNumberPresent = fileInput.hasNextFloat();
        System.out.println("isFloatNumberPresent :"+ isFloatNumberPresent);

        Boolean isBooleanNumberPresent = fileInput.hasNextBoolean();
        System.out.println("isBooleanNumberPresent :"+ isBooleanNumberPresent);

        /*
         * 2. BuufferReader
         *   a.it reads character based input stream, synchronous, threadsafe, faster than scanner
         *   b.When an I/O stream manages 8-bit bytes of raw binary data, it is called a byte stream. And, when the
         *     I/O stream manages 16-bit Unicode characters, it is called a character stream.
         *   c. BufferedReader allows for changing the size of the buffer while Scanner has a fixed buffer size
         *   d. BufferedReader taked reader object in the constructor to read
         *
         * */


        FileReader reader = new FileReader(inputFile);
        BufferedReader bufferedReader= new BufferedReader(reader);

        /*
         * to check whether charcter stream present are not we can use conditions to avoid exception throwing
         * .readLine() - it will return null if there is no character stream presen else it'll reaturn a line as a string
         * .read() - it will return -1 if there is no character stream present in the line else it'll return character asci value
         * */

        while (bufferedReader.read()!=-1){
            System.out.println("bufferReadChar :"+ (char) bufferedReader.read());
        }

        String bufferReadLine=bufferedReader.readLine();
        System.out.println("bufferReadLine :"+ bufferReadLine);

        while(bufferedReader.readLine()!=null){
            System.out.println("bufferReadLine :"+ bufferedReader.readLine());
        }


        /*
        * writing to file
        *   a. we can write on a file using FileWriter class write method and using eithe rth filepath or file object in the
        *      constructor
        *   b. write() - writes a single character to the writer
            c. write(char[] array) - writes the characters from the specified array to the writer
            d. write(String data) - writes the specified string to the writer
        *
        * */

        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write("Hello World");
        fileWriter.write("\n");
        fileWriter.write('g');
        fileWriter.write("\n");
        fileWriter.write(new char[]{'a','b','c'});
        fileWriter.close();





















    }


}

/*
*
returns the entire next line of input
returnOnlyOneWord iWontBePicketfirst
1 1.8732e3 95.03317777109125 1.1 1.1 1.2 True TRUE
TRUE

*/
