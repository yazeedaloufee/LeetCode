class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if(index == -1) return word;
        boolean flag = false;
        String s = "";

        for(char c : word.toCharArray()) {
            if(!flag) {
                s = c + s;
            }else {
                s = s + c;
            }
            if(c == ch) {
                flag = true;
            }
        }




        return s;
        
    }
}