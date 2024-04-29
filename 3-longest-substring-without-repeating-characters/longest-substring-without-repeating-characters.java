class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int length = s.length();
        if(length < 2) {
            return length;
        }
        Set<Character> hs = new HashSet<>();
        int max = 0; 
        int l = 0; 
        int r = 0; 

        while( r < length) {
            char  c = s.charAt(r);
            if(hs.contains(c)) {
                hs.remove(s.charAt(l));
                l++;

            } else {
                max = Math.max(max, r - l +1);
                hs.add(c);
                r++;
            }
        }
        return max;
    }
}