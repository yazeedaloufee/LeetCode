class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for(String s : strs) {
            int[] map = new int[26];
            for (char c : s.toCharArray()) {
                map[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append((char)(i +'a'));
                sb.append(map[i]);
            }
            String key = sb.toString();
            hm.computeIfAbsent(key, (x) -> new ArrayList<>()).add(s);
        }
        List<List<String>> output = new ArrayList<>();

        for (List<String> list : hm.values()) {
            output.add(list);
        }
        return output;
        
    }
}