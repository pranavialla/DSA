package Graph.DisjoinSets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountMerge {
int[] parent;
    int[] rank;

    int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]); // Path compression
        return parent[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;

        // Union by rank
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        Map<String, Integer> emailToId = new HashMap<>();

        // Step 1: Union all account IDs that share emails
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToId.containsKey(email)) {
                    union(i, emailToId.get(email));
                } else {
                    emailToId.put(email, i);
                }
            }
        }

        // Step 2: Group emails by final leader
        Map<Integer, List<String>> leaderToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToId.entrySet()) {
            String email = entry.getKey();
            int leader = find(entry.getValue());
            leaderToEmails.computeIfAbsent(leader, k -> new ArrayList<>()).add(email);
        }

        // Step 3: Build final merged accounts
        List<List<String>> merged = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : leaderToEmails.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(entry.getKey()).get(0)); // name
            account.addAll(emails);
            merged.add(account);
        }

        return merged;
    }
}
