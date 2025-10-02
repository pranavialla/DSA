import java.util.ArrayList;
import java.util.List;

class LetterCombinations {
    private static final String[] KEYS = {
        "",    "",    "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return res;
        backtrack(0, digits, new StringBuilder(), res);
        return res;
    }

    private void backtrack(int idx, String digits, StringBuilder path, List<String> res) {
        if (idx == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letters = KEYS[digits.charAt(idx) - '0'];
        for (char ch : letters.toCharArray()) {
            path.append(ch);
            backtrack(idx + 1, digits, path, res);
            path.deleteCharAt(path.length() - 1); // backtrack
        }
    }
}
