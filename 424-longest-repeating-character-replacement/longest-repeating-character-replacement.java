class Solution {
    public int characterReplacement(String s, int k) {
        int r=0,l=0;
        int n=s.length();
        int hash[]=new int[26];
         int maxfreq=0;
         int maxlen=0;
        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxfreq =Math.max(maxfreq,hash[s.charAt(r)-'A']);

          if((r-l+1)-maxfreq>k){
                hash[s.charAt(l)-'A']--;
                l++;
            }

            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}