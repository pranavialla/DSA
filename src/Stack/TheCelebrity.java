package Stack;

class TheCelebrity{
    public static int Celebrity(int[][] M){
        if (M.length == 0) {
            return -1;
        }
        int start = 0;
        int end = M[0].length - 1;

        while (start < end) {
            if (M[start][end] == 1) {
                // start knows end → start can't be celebrity
                start++;
            } else {
                // start doesn't know end → end can't be celebrity
                end--;
            }
        }

        // Verify candidate
        int iknow = 0, theyKnow = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[start][i] == 1) {
                iknow++;
            }
            if (M[i][start] == 1) {
                theyKnow++;
            }
        }

        return iknow == 0 && theyKnow == M.length - 1 ? start : -1;

    }
}