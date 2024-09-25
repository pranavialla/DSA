package Graph.BipatiteGraph;
import java.util.Arrays;

public class MaximumAcceptedInvitations {

        private int[][] grid; // The grid representing invitations
        private boolean[] visited; // To track if a column (person in right set) has been visited
        private int[] matched; // To store matched left-side people to right-side people
        private int columns; // Number of columns in the grid

        // Method to compute the maximum number of invitations
        public int maximumInvitations(int[][] grid) {
            int rows = grid.length; // Number of rows in the grid
            columns = grid[0].length; // Number of columns in the grid
            this.grid = grid;
            visited = new boolean[columns]; // Initialize visited array for tracking
            matched = new int[columns]; // Initialize matches array
            Arrays.fill(matched, -1); // Fill the matches array with -1 indicating no match
            int invitations = 0; // Initialize invitation count

            // Iterate over all rows (left side people) to find maximum matchings
            for (int i = 0; i < rows; ++i) {
                Arrays.fill(visited, false); // Reset the visited array for each iteration
                if (tryFindMatch(i)) {
                    invitations++; // If a match is found, increment the invitation count
                }
            }
            return invitations; // Return the maximum number of invitations
        }

        // Helper method to find a match for a person in the left set
        private boolean tryFindMatch(int personIdx) {
            for (int j = 0; j < columns; ++j) {
                // If there's an invitation from personIdx to right set person 'j' and 'j' is not visited
                if (grid[personIdx][j] == 1 && !visited[j]) {
                    visited[j] = true; // Mark 'j' as visited
                    // If 'j' is not matched, or we can find a match for 'j's current match
                    if (matched[j] == -1 || tryFindMatch(matched[j])) {
                        matched[j] = personIdx; // Match personIdx (left set) with 'j' (right set)
                        return true; // A match was successful
                    }
                }
            }
            return false; // No match was found for personIdx
        }
    }

