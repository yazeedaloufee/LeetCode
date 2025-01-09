class Solution {
    Map<String, Set<String>> hm;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // build an adjacency list of allword that are have 1 letter difference;
        hm = new HashMap<>();

        for (String word : wordList) {
            for (String s : getVariations(word)) {
                Set<String> current = hm.getOrDefault(s, new HashSet<>());
                current.add(word);
                hm.put(s, current);
            }
        }
        for (Set<String> s : hm.values()) {
            System.out.println(s);

        }

        Deque<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        for (String s : getVariations(beginWord)) {
            for (String word : hm.getOrDefault(s, new HashSet<>())) {
                q.add(word);
                visited.add(word);
            }
        }

        int counter = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            counter++;
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(endWord))
                    return counter;
                for (String s : getVariations(curr)) {
                    for (String word : hm.getOrDefault(s, new HashSet<>())) {
                        if (!visited.contains(word)) {
                            visited.add(word);
                            q.add(word);
                        }
                    }
                }

            }
        }
        return 0;

    }

    public List<String> getVariations(String word) {
        List<String> list = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char c = chars[i];
            chars[i] = '*';
            list.add(new String(chars));
            chars[i] = c;
        }
        return list;
    }

}