class Solution {
    public String countAndSay(int n) {
        String answer = "1";
        for (int i = 2; i <=n;i++) {
            answer = encoding(answer);
        }
        return answer;
    }

    private String encoding (String input) {
        if(input == null || input.length() == 0) return "";
        char[] chars= input.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length;i++) {
            char c = chars[i];
            int count = 1;
            while(i+1 < chars.length && chars[i+1] == c) {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(c);

        }
        return sb.toString();

    }
}

// base case if n -- 1 return "1";
// find countAndSay(n - 1)
// run encoding  algorthythem
//return it. 