package DynamicProgramming;

public class UniquePath {
    public static int uniquePaths(int m, int n) {
        int prev[] = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    prev[j] = 1;
                    continue;
                }
                prev[j] = prev[j] + prev[j - 1];
            }
        }

        return prev[n - 1];
    }

}
