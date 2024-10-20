class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        if(edges== null || edges.length == 0) return false;

         Set<Integer> visited = new HashSet<>();

         Map<Integer, List<Integer>> map = new HashMap<>();

         for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], (k) -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], (k) -> new ArrayList<>()).add(edge[0]);
         }

         Deque<Integer> queue = new ArrayDeque<>();
         queue.add(source);
         visited.add(source);

         while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int number : map.get(current)) {
                if (number == destination)
                    return true;
                if(!visited.contains(number)) {
                    queue.add(number);
                    visited.add(number);
                }
            }
         }

         return false;
    }
}