class Solution {
    public int minChanges(String s) {
        // 1001
        char[] chars = s.toCharArray();
        int index = 0; 
        int changes = 0; 
        while(index < chars.length) {
            char c = chars[index];
            int counter = 0;

            while (index < chars.length && chars[index] == c) {
                index++;
                counter++;
            }
            if (counter % 2 == 1  && index < chars.length) {
                changes++;
                index++;
            }

        }
        return changes;
    }
}