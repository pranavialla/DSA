package Recurssion.partition;

import java.util.ArrayList;

public class WordBreak {
    public ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        ArrayList<String> possibleSentences = new ArrayList<>();
        String currentSentence = "";
        recursiveWordBreak(s, dictionary, 0, possibleSentences, currentSentence);
        return possibleSentences;
    }

    private void recursiveWordBreak(String word, ArrayList<String> dictionary, int startIndex, ArrayList<String> possibleSentences, String currentSentence) {
        if(startIndex > word.length()-1){
            possibleSentences.add(currentSentence);
            return;
        }
        for(int i=startIndex; i<word.length(); i++){
            if(isCurrentWordInDictionary(word.substring(startIndex, i+1), dictionary)){
                int previousWordLength = currentSentence.length();
                if(currentSentence.length()!=0){
                    currentSentence=currentSentence+" ";
                }

                currentSentence+=word.substring(startIndex, i+1);

                recursiveWordBreak(word, dictionary, i+1, possibleSentences, currentSentence);

                currentSentence = removerLastWord(currentSentence, previousWordLength);
            }
        }
        return;
    }

    private String removerLastWord(String currentSentence, int previousWordLength) {
        return currentSentence.substring(0, previousWordLength);
    }

    private boolean isCurrentWordInDictionary(String substring, ArrayList<String> dictionary) {
        for(String word : dictionary){
            if(word.equals(substring)){
                return true;
            }
        }
        return false;
    }


}
