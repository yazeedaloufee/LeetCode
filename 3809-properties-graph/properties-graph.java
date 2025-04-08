class Solution {
    int count = 0;
    public int numberOfComponents(int[][] properties, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < properties.length; i++){
            for(int j=i+1; j < properties.length; j++){
                if(i == j) continue;
                if(intersect(properties[i], properties[j]) >= k) {
                    graph.computeIfAbsent(i, (x)-> new ArrayList<>()).add(j);
                    graph.computeIfAbsent(j, (x)-> new ArrayList<>()).add(i);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < properties.length; i++) {
            if(dfs(i, visited, graph)) {
                count++;
            }
        }
        return count;
    }
    public boolean dfs(int i, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        if(visited.contains(i)) return false;
        visited.add(i);

        for (int x : graph.getOrDefault(i, new ArrayList<>())){
            dfs(x, visited, graph);
        }
        return true;
    }
    public int intersect(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for (int x : a) setA.add(x);
        for (int x : b) setB.add(x);

        setA.retainAll(setB); 
        return setA.size();
    }
}