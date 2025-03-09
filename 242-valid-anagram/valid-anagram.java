class Solution {
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length()) return false;
        
        int[] map = new int[27];
        int[] map2 = new int[27];

        for (int i = 0; i < t.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map2[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 27; i++) {
            if(map[i] !=  map2[i]) return false;
        }
        return true;
        // return map.equals(map2);
    }
}