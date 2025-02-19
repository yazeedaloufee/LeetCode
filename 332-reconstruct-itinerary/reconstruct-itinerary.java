import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> hm;
    Deque<String> stack;

    public List<String> findItinerary(List<List<String>> tickets) {
        hm = new HashMap<>();
        stack = new ArrayDeque<>();

        // Build the adjacency list
        for (List<String> ticket : tickets) {
            hm.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        // Start DFS from "JFK"
        dfs("JFK");

        // Convert the stack to a list
        List<String> output = new ArrayList<>();
        while (!stack.isEmpty()) {
            output.add(stack.pollFirst());
        }

        return output;
    }

    private void dfs(String current) {
        PriorityQueue<String> destinations = hm.get(current);
        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll());
        }
        stack.push(current);
    }
}