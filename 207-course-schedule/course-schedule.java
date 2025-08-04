class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> hm = new HashMap<>(); 
        int[] indegree = new int[numCourses];
        for(int[] pair: prerequisites) {
            hm.computeIfAbsent(pair[1], (k) -> new ArrayList<>()).add(pair[0]);
            indegree[pair[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int courses = 0; 
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            courses++;}
            
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int n : hm.getOrDefault(current, new ArrayList<>())) {
                indegree[n]--;
                if(indegree[n] == 0) {
                    queue.offer(n);
                    courses++;
                }
            }
        }
        return numCourses == courses;

        
    }
}