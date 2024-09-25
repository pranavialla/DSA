package Trie;


class Trie{
    boolean isWord;
    Trie[] children = new Trie[26];
}
public class InsertSearchStartswith {
    Trie root;
    public void insert(String word){
        Trie curTriNode = root;
        for(int i = 0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curTriNode.children[index]==null){
                curTriNode.children[index] = new Trie();
            }
            curTriNode = curTriNode.children[index];
        }
        curTriNode.isWord = true;
    }

    public boolean search(String word){
        Trie curTriNode = root;
        for(int i = 0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curTriNode.children[index]==null) return false;
            curTriNode = curTriNode.children[index];
        }
        return curTriNode!=null && curTriNode.isWord;

    }

    public boolean startsWith(String prefix){
        Trie curTriNode = root;
        for(int i = 0; i<prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(curTriNode.children[index]==null) return false;
            curTriNode = curTriNode.children[index];
        }
        return true;

    }
}
