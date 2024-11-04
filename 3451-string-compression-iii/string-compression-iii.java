class Solution {
    public String compressedString(String word) {

        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int counter = 0;
            char c = chars[i];
            while (counter + i < chars.length && counter < 9 && chars[counter + i] == c) {
                counter++;
            }
            sb.append(counter);
            sb.append(c);
            i = i + counter -1;
        }
        return sb.toString();
    }
}