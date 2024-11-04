class Solution {
    public String compressedString(String word) {

        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int counter = 0;
            char c = chars[i];
            //// a a a a a a a a a

            ////// 0 1 2 3 4 5 6 7 8
            // i// 0 1 2 3 4 5 6 7 8
            // c//
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