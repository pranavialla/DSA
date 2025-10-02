package String;

class StringIsRepeatedString {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for(int i=1; i<=l/2;i++){
            int repeat = l/i;
            StringBuilder sb= new StringBuilder();
            String subs = s.substring(0,i);
            while(repeat!=0){
                sb.append(subs);
                repeat--;
            }
            if(sb.toString().equals(s)) return true;
        }
        return false;
    }

    /*

    Why It Works
    Let’s break it down:

    Suppose s is made by repeating a substring t multiple times. For example: s = "abcabc" → t = "abc" repeated twice.

    When you do s + s, you get: "abcabcabcabc"

    Now, if you remove the first and last characters, you get: "bcabcabcab"

    If s is truly made of repeated substrings, then this trimmed version will still contain s somewhere in the middle, because the repeated pattern overlaps.

    But if s is not made of repeated substrings, then this overlap won’t happen, and s won’t be found in the trimmed version.


    */

    public boolean repeatedSubstringPatternOptimised(String s) {
        String doubled = s+s;
        String trimmed = doubled.substring(1, doubled.length()-1);
        return trimmed.contains(s);
    }
}