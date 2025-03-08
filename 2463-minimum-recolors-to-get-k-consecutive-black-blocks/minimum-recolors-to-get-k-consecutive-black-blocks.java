class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] chars = blocks.toCharArray();

        int l = 0; 
        int r = 0; 
        int min = chars.length;
        int whiteBlocks = 0;

        while(r < chars.length) {
            if (chars[r] == 'W') {
                whiteBlocks++;
            }
            if(r - l + 1 == k) {
                min = Math.min(whiteBlocks, min);
                if(min == 0) return 0;
                if(chars[l++] == 'W') {
                    whiteBlocks--;
                }
            }
            r++;
        }
        return min;
    }
}