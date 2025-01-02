package String.Anangram;

import java.util.HashMap;
import java.util.Map;

class IsAnagrams{
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> dic =  new HashMap<>();

        for( char c : s.toCharArray()){
            if(dic.containsKey(c)){
                dic.put(c, dic.get(c)+1);
            } else{
                dic.put(c, 1);
            } 
        }

        for( char c : t.toCharArray()){
            if (dic.containsKey(c) && dic.get(c)!=0){
                dic.put(c, dic.get(c)-1);
            }
            else{
                return false;
            }
        }

        for(char c : dic.keySet()){
            if(dic.get(c)!=0){
                return false;
            }
        }
        return true;
        
    }
}