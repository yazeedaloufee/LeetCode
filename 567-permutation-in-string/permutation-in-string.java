class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length() , length2 = s2.length();
        if(length1 > length2) return false;
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();

        int[] hm1 = new int[26];
        int[] hm2 = new int[26];
        

        for(char c : sc1) {
            hm1[c - 'a']++;
        }
        int l = 0, r = 0;
        while ( r < length2){
            hm2[sc2[r]-'a']++;
            if(r - l + 1 == length1 && compare(hm1, hm2)) {
                return true;
            }

            if(r - l + 1 >= length1){
                hm2[sc2[l] - 'a']--;
                l++;
            }
            r++;

        }

        
        
        return false;
    }
    public boolean compare(int[] first, int[] second){
        for(int i = 0; i < first.length; i++) {
            if(first[i] != second[i]) return false;
        }
        return true;
    }
}