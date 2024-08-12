class Solution {
    int[] rank; 
    int[] head;
    public int[] findRedundantConnection(int[][] edges) {
        int numberOfNodes =0;
        for(int[] edge: edges) {
            numberOfNodes = Math.max(edge[1], numberOfNodes);
            numberOfNodes = Math.max(edge[0], numberOfNodes);
        }
        head = new int[numberOfNodes+1];
        rank = new int[numberOfNodes+1];
        for(int i = 0; i < head.length; i++) {
            head[i] = i;
        }
        for(int[] edge : edges) {
            if(isConnected(edge[1], edge[0])) return edge;

            union(edge[0], edge[1]);

        }
        return new int[2];

    }

    private void union(int x , int y) {
        int xhead = find(x);
        int yhead = find(y);

        if(rank[xhead] > rank[yhead]) {
            head[yhead] = xhead;
        }else if(rank[xhead] < rank[yhead]){
            head[xhead] = yhead;
        }else {
            head[yhead] = xhead;
            rank[xhead]++;
        }
    }
    private int find (int x) {
        if(x == head[x]) {
            return x;
        }
    return head[x]= find(head[x]);
    }
    private boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}