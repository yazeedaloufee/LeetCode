class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;

        s = s.trim();
        int index = s.length() - 1;
        int counter = 0; 
        while (index >=0 && s.charAt(index) != ' ') {
            counter++;
            index--;
        }
        return counter;
        
    }
}