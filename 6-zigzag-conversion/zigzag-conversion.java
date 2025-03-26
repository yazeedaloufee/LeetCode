class Solution {
    public String convert(String s, int numRows) {
        List<List<Character>> output = new ArrayList();
        if (numRows == 1) return s;
        
        for (int i = 0;i < numRows; i++) {
            output.add(new ArrayList<>());
        }
        int index = 0;
        int direction = 1;
        for(char c : s.toCharArray()) {
            output.get(index).add(c);
            if(direction == 1) {
                index++;
            } else {
                index--;
            }

            if(index < 0) {
               direction = 1; 
               index = 1;
            }else if (index > numRows-1) {
                direction = 0;
                index = numRows-2;
            }
        }

        StringBuilder sb = new StringBuilder();


        for(List<Character> l : output) {
            for(char c : l) {
                sb.append(c);
            }
        }

        return sb.toString();
        
    }
}