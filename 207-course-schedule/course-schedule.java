class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build djacency list

        Map<Integer, List<Integer>> hm = new HashMap<>();

        for(int[] pair : prerequisites){
            int course = pair[0];
            int pre = pair[1];
            hm.computeIfAbsent(pre, (k)->new ArrayList<>()).add(course);
        }
        int[] state = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, hm, state)) return false;
        }
        return true;
        
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> hm,int[] state) {
        if (state[node] == 1){return false;}
        if(state[node] == 2) {return true;}
        state[node] = 1;
        for(int n : hm.getOrDefault(node, new ArrayList<>())){
            if(!dfs(n, hm, state))return false;
        }

        state[node] = 2; 

        return true;


    }
}