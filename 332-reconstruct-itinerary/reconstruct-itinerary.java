class Solution {
    Map<String, PriorityQueue<String>> hm;
    Deque<String> stack;
    public List<String> findItinerary(List<List<String>> tickets) {
        hm = new HashMap<>();
        stack = new ArrayDeque<>();
        // create adjacency list
        for(List<String> ticket : tickets) {
            hm.computeIfAbsent(ticket.get(0),(x) -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs("JFK");
        List<String> output = new ArrayList<>();
        while(!stack.isEmpty()) {
            output.add(stack.pollFirst());
        }
        return output;
    }

    private void dfs(String dep) {
        PriorityQueue<String> destenations = hm.get(dep);
        while(destenations != null && !destenations.isEmpty() ){
            dfs(destenations.poll());
        }
        stack.push(dep);
    }
}