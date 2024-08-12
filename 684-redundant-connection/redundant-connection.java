class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (union(edge[0], edge[1], parent, rank))
                return edge;
        }
        return new int[0];

    }

    public int find(int node, int[] parent) {
        if (parent[node] != node)
            parent[node] = find(parent[node], parent);
        return parent[node];
    }

    public boolean union(int edge1, int edge2, int[] parent, int[] rank) {
        int parent1 = find(edge1, parent);
        int parent2 = find(edge2, parent);
        if (parent1 == parent2)
            return true;
        if (rank[parent2] > rank[parent1]) {
            parent[parent1] = parent2;
            rank[parent2] += rank[parent1];
        } else {
            parent[parent2] = parent1;
            rank[parent1] += rank[parent2];
        }
        return false;
    }
}