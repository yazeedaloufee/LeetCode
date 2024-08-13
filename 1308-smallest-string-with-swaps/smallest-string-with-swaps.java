class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> edge : pairs) {
            int source = edge.get(0);
            int dest = edge.get(1);
            uf.union(source, dest);
        }

        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();
        for (int v = 0; v < s.length(); v++) {
            int root = uf.find(v);
            rootToComponent.putIfAbsent(root, new ArrayList<>());
            rootToComponent.get(root).add(v);
        }

        char[] smallestString = new char[s.length()];

        for(List<Integer> indices : rootToComponent.values()) {
            List<Character> characters = new ArrayList<>();
            for(int index : indices) {
                characters.add(s.charAt(index));
            }
            Collections.sort(characters);
            System.out.println(indices);
            for(int index = 0; index < indices.size(); index++) {
                smallestString[indices.get(index)] = characters.get(index);
            }
        }

        return new String(smallestString);
        
    }


}

class UnionFind {
    private int[] root;
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for(int i = 0; i  < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x) {
        if( x != root[x]) {
            x = find(root[x]);
        }
        return x;
    }
    public void union(int x, int y) {
        int rootx = find(x);
        int rooty  = find(y);
        if(rootx != rooty) {
            if(rank[rootx] >= rank[rooty]) {
                root[rooty] = rootx;
                rank[rootx] +=rank[rooty];
            } else {
            root[rootx] = rooty;
            rank[rooty] += rank[rootx];
        }
        }  
    }

}