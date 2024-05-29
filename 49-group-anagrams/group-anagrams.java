class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        
        for(String s : strs) {
            // build the
            String key = anagramString(getFrequencyArray(s));
            List<String> temp = hm.getOrDefault(key, new ArrayList<String>());
            temp.add(s);
            hm.put(key, temp);
            
        }
        List<List<String>> output = new ArrayList<>();
        for(List<String> curr : hm.values()) {
            output.add(curr);
        }
        return output;
        
    }
    
    
    
    
    
    private String anagramString(int[] array) {
        StringBuilder sb = new StringBuilder(); 
        
        for(int i = 0; i < array.length; i++) {
            sb.append("" + array[i] );
            sb.append('a'+i);
        }
        return sb.toString();
    }
    
    private int[] getFrequencyArray(String s) {
        
        int[] output = new int[26]; 
        
        char[] letters = s.toCharArray();
        for(char c : letters) {
            output[c - 'a']++;
        }
        return output;
    }
}