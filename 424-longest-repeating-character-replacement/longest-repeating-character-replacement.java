class Solution {
    public int characterReplacement(String s, int k) {
        int r=0,l=0;
        int n=s.length();
        int hash[]=new int[26];
        char[] cArray = s.toCharArray();
         int maxfreq=0;
         int maxlen=0;
        while(r<n){
            hash[cArray[r]-'A']++;
            maxfreq =Math.max(maxfreq,hash[cArray[r]-'A']);

          if((r-l+1)-maxfreq>k){
                hash[cArray[l]-'A']--;
                l++;
            }

            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}