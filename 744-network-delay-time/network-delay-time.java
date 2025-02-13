class Solution {
    Set<Integer> visited;
    Set<Integer> visitedDfs;
    int max;
    HashMap<Integer, Integer> min;
    Map<Integer, List<int[]>> hm;

    public int networkDelayTime(int[][] times, int n, int k) {
        hm = new HashMap<>();
        visited = new HashSet<>();
        visitedDfs = new HashSet<>();
        min = new HashMap<>();
        max = 0;
        
        // build chilren hashmap
        for (int[] time : times) {
            List<int[]> children = hm.computeIfAbsent(time[0], x -> new ArrayList<>());
            children.add(new int[] { time[1], time[2] });
            hm.put(time[0], children);
        }

        dfs(k, 0);

        for (int i : min.values()) {
            max = Math.max(max, i);
        }

        if (visited.size() == n) {
            return max;
        }

        return -1;
    }

    private void dfs(int n, int time) {
        if(time > min.getOrDefault(n, Integer.MAX_VALUE)) return;
        if( !visitedDfs.contains(n)){
            min.put(n, Math.min(min.getOrDefault(n, Integer.MAX_VALUE), time));
            visited.add(n);
            visitedDfs.add(n);

            if(hm.get(n) != null)
            for (int[] child: hm.get(n)){
                dfs(child[0], time + child[1]);
            }

            visitedDfs.remove(n);
        }
    }
}