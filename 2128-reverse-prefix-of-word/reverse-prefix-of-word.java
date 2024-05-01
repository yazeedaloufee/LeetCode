class Solution {
    public String reversePrefix(String word, char ch) {
        String s = "";
        int i = 0;
        while(i < word.length() && word.charAt(i) != ch){
            s = word.charAt(i) + s;
            i++;
        }
        if(i >= word.length()) {
            return word;
        }
        s = word.charAt(i) + s;
        i++;
        while(i < word.length()) {
            s =  s+ word.charAt(i) ;
            i++;
        }

        return s;




        
    }
}