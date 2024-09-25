package Trie;
import  Trie.Trie;


class TriePro extends Trie {

    int countPrifix;
    int countEndWith;
    TriePro[] children = new TriePro[26];
    public TriePro() {
        super();
        countPrifix = 0;
        countEndWith = 0;
    }
}
public class CountWordsStartWithDeleteWord {
    TriePro root;

    public void insert(String word){
        TriePro curTriNode = root;
        for(int i = 0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curTriNode.children[index]==null){
                curTriNode.children[index] = new TriePro();

            }
            curTriNode.countPrifix++;
            curTriNode = curTriNode.children[index];
        }
        curTriNode.countEndWith++;
        curTriNode.isWord = true;
    }

    public int countPrefix(String prefix){
        TriePro curTriNode = root;
        for(int i = 0; i<prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(curTriNode.children[index]==null) return 0;
            curTriNode = curTriNode.children[index];
        }
        return curTriNode.countPrifix;
    }

    public int countWordsEndWith(String suffix){
        TriePro curTriNode = root;
        for(int i = 0; i<suffix.length(); i++){
            int index = suffix.charAt(suffix.length()-1-i) - 'a';
            if(curTriNode.children[index]==null) return 0;
            curTriNode = curTriNode.children[index];
        }
        return curTriNode.countEndWith;
    }

    public void deleteWord(String word){
        TriePro curTriNode = root;
        TriePro toBeDeleted = null;
        InsertSearchStartswith utill =  new InsertSearchStartswith();
        if(!utill.search(word)){
            return;
        }

        // Iterating through the string word.
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';

            // Store the parent of current character.
            TriePro parent = curTriNode;
            //curTriNode = curTriNode.childern[index];
            if (curTriNode==null)
            curTriNode.countPrifix--;


            if(toBeDeleted != null){
                toBeDeleted = null;
            }


            // If the prefixCount of current node is 0 that means we have reached at the end of the word that has to be deleted.
            if(curTriNode.countPrifix == 0){
                if(toBeDeleted == null){
                    //parent.childern[index] = null;
                }
                toBeDeleted = curTriNode;
            }
        }

        curTriNode.countEndWith--;
        if(toBeDeleted != null){
            toBeDeleted = null;
        }

    }
}
