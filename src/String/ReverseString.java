package String;

public class ReverseString {
   
    // public String reverseWords(String s) {
    //     StringBuilder reversedWord = new StringBuilder();
    //     int l=0, r= s.length()-1;
        
    //     boolean isStartingWord = true ;

    //     //left trim
    //     while(l<=r && s.charAt(l)==' '){
    //         l++ ;
    //     }

    //     //right trim
    //     while(l<=r && s.charAt(r)==' '){
    //         r-- ;
    //     }

    //     int i=r;
    //     //now we can push the word and multiple space characters with single space
    //     while(i>=0){
    //         char letter = s.charAt(i);
    //         StringBuilder word = new StringBuilder();
    //         while(i>=0 && s.charAt(i)!=' '){
    //             letter = s.charAt(i);
    //             word.append(letter);
    //             i--;
    //         }
    //         reversedWord.append(word.reverse());

    //         while(i>=0 && s.charAt(i)==' '){
    //             i--;
    //         } 
    //         if(i>=l){
    //             reversedWord.append(" ");
    //         }
    //         //System.out.println(word.reverse());       
    //     }
    //     return reversedWord.toString();
    // }


    public String reverseWords(String s) {
        int sLength= s.length();
        int  end = sLength-1, offset = 0  ;
        char[] output = new char[sLength];

        while(end>=0){
            while(end>=0 && s.charAt(end)==' ') end--;
            
            int wordEnd = end;
            while(end>=0 && s.charAt(end)!=' ') end--;
            int wordStart = end+1;

            //need to add space before every word
            if(offset!=0 && wordEnd!=end) output[offset++] = ' ';

            for(int i = wordStart; i<=wordEnd ; i++){
                output[offset++] = s.charAt(i);
            }
        }

        return new String(output, 0, offset);
    }



}

