class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        Map<Integer, List<Integer>>  hm = new HashMap<>();

        for(int[] edge : edges) {
            int parentV = edge[0];
            int childV = edge[1];
            hm.computeIfAbsent(parentV, k -> new ArrayList<>()).add(childV);
            hm.computeIfAbsent(childV, k -> new ArrayList<>()).add(parentV);
        }

        return dfs(source, destination, hm, new HashSet<>());
        
    }

    private boolean dfs(int source, int destination, Map<Integer, List<Integer>>  hm, Set<Integer> set){
        List<Integer> children = hm.getOrDefault(source, new ArrayList<>());
        if(set.contains(source)) return false;
        set.add(source);
        for(int i : children) {
            if(i == destination) 
                return true;
            if(dfs(i, destination, hm, set)) return true;
        }
        return false;
    }
}