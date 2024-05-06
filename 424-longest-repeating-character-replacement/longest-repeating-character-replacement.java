class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0; 
        Map<Character, Integer> hm = new HashMap<>();

        int r = 0;
        int l = 0; 
        int maxR = 0;
        int length = s.length();
        while (r < length){
            char c = s.charAt(r); 
            hm.put(c, hm.getOrDefault(c, 0) +  1);// updating the counter for the current letter

            int rep = hm.get(c);// get the counter 
            maxR = Math.max(rep, maxR);
            int width = r - l + 1;// calculate the width 
            System.out.println(rep);
            if (maxR + k >= width ){ // check if the width I am it is allowed? and calculat max;
                max = Math.max(width, max);
            }else{            // if not start poping charcters from the left side and decrement the counter
                char cl =s.charAt(l);
                while( l<r && maxR + k < r - l + 1 ){// keep poping while the width is not allowed.
                    hm.put(cl, hm.get(cl) -  1);
                    l++;
                    cl =s.charAt(l);
                }

            }
            r++;
        }
        return max;
        
    }
}