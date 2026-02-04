// 3650. Minimum Cost Path with Edge Reversals
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a directed, weighted graph with n nodes labeled from 0 to n - 1, and an array edges where edges[i] = [ui, vi, wi] represents a directed edge from node ui to node vi with cost wi.

// Each node ui has a switch that can be used at most once: when you arrive at ui and have not yet used its switch, you may activate it on one of its incoming edges vi → ui reverse that edge to ui → vi and immediately traverse it.

// The reversal is only valid for that single move, and using a reversed edge costs 2 * wi.

// Return the minimum total cost to travel from node 0 to node n - 1. If it is not possible, return -1.

 

// Example 1:

// Input: n = 4, edges = [[0,1,3],[3,1,1],[2,3,4],[0,2,2]]

// Output: 5

// Explanation:



// Use the path 0 → 1 (cost 3).
// At node 1 reverse the original edge 3 → 1 into 1 → 3 and traverse it at cost 2 * 1 = 2.
// Total cost is 3 + 2 = 5.
// Example 2:

// Input: n = 4, edges = [[0,2,1],[2,1,1],[1,3,1],[2,3,3]]

// Output: 3

// Explanation:

// No reversal is needed. Take the path 0 → 2 (cost 1), then 2 → 1 (cost 1), then 1 → 3 (cost 1).
// Total cost is 1 + 1 + 1 = 3.
 

// Constraints:

// 2 <= n <= 5 * 104
// 1 <= edges.length <= 105
// edges[i] = [ui, vi, wi]
// 0 <= ui, vi <= n - 1
// 1 <= wi <= 1000


import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {

        // Adjacency list: graph[u] = {v, cost}
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            graph.get(u).add(new int[]{v, cost});
            graph.get(v).add(new int[]{u, 2 * cost}); // reverse edge with double cost
        }

        // Dijkstra setup
        int[] minCost = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        minCost[0] = 0;
        pq.offer(new int[]{0, 0}); // {node, cost}

        // Dijkstra algorithm
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int costSoFar = curr[1];

            if (visited[node]) continue;
            visited[node] = true;

            if (node == n - 1) break; // reached destination

            for (int[] nei : graph.get(node)) {
                int nextNode = nei[0];
                int edgeCost = nei[1];

                if (visited[nextNode]) continue;

                int newCost = costSoFar + edgeCost;
                if (newCost < minCost[nextNode]) {
                    minCost[nextNode] = newCost;
                    pq.offer(new int[]{nextNode, newCost});
                }
            }
        }

        return minCost[n - 1] == Integer.MAX_VALUE ? -1 : minCost[n - 1];
    }
}
