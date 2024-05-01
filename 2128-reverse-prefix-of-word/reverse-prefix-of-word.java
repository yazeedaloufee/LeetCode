class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if(index == -1) return word;
        boolean flag = false;
        StringBuilder s = new StringBuilder();
        char[] array = word.toCharArray();

        for(char c :array) {
            if(!flag) {
                s.insert(0, c);
            }else {
                s.append(c);
            }
            if(c == ch) {
                flag = true;
            }
        }




        return s.toString();
        
    }
}