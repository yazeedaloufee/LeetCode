class Solution {
    Map<Integer, List<Character>> hm;
    char[] chars;
    List<String> output;
    public List<String> letterCombinations(String digits) {
        hm = new HashMap<>();
        chars = digits.toCharArray();
        output= new ArrayList<String>();
        if(chars.length == 0) return output;
        hm.put(2, new ArrayList<Character>(Arrays.asList('a','b','c')));
        hm.put(3, new ArrayList<Character>(Arrays.asList('d','e','f')));
        hm.put(4, new ArrayList<Character>(Arrays.asList('g','h','i')));
        hm.put(5, new ArrayList<Character>(Arrays.asList('j','k','l')));
        hm.put(6, new ArrayList<Character>(Arrays.asList('m','n','o')));
        hm.put(7, new ArrayList<Character>(Arrays.asList('p','q','r', 's')));
        hm.put(8, new ArrayList<Character>(Arrays.asList('t','u','v')));
        hm.put(9, new ArrayList<Character>(Arrays.asList('w','x','y', 'z')));
        helper(0, new StringBuilder());

        return output;
    }

    private void helper(int index, StringBuilder sb) {
        if(index == chars.length) {
            output.add(sb.toString());
            return;
        }
        for(char c: hm.get((int)(chars[index] - '0'))){
            sb.append(c);
            helper(index+1, sb);
            sb.deleteCharAt(sb.length() -1);
        }

    }
}