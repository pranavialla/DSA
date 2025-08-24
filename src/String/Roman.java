class Roman{
 public String intToRoman(int num) {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {
        "M", "CM", "D", "CD", "C", "XC", "L",
        "XL", "X", "IX", "V", "IV", "I"
    };

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < values.length; i++) {
        while (num >= values[i]) {
            sb.append(symbols[i]);
            num -= values[i];
        }
    }

    return sb.toString();
}

public int romanToInt(String s) {
    Map<Character, Integer> romanMap = Map.of(
        'I', 1, 'V', 5, 'X', 10, 'L', 50,
        'C', 100, 'D', 500, 'M', 1000
    );

    int total = 0;
    int prev = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
        int curr = romanMap.get(s.charAt(i));
        total += (curr < prev) ? -curr : curr;
        prev = curr;
    }

    return total;
}

} 




