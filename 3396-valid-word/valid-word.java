class Solution {
    String vowels = "aeiouAEIOU";

    public boolean isValid(String word) {
        int vowelsCount = 0;
        int consonantCount = 0;
        if (word.length() <3) return false;

        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if (vowels.indexOf(c) != -1) {
                vowelsCount++;
            } else if (Character.isLetter(c)) {
                consonantCount++;  
            }
        }
        return vowelsCount >= 1 && consonantCount >=1;
    }
}