class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int minDigits = numberOfDigits(low);
        int maxDigits = numberOfDigits(high);
        List<Integer> output = new ArrayList<>(); 
        
        for(int i = minDigits; i<= maxDigits; i++) {
            for(int j = 1; j <= 10 - i; j++) {
                int temp = createNumber(j, i);
                if(temp >=low && temp <= high) {
                    output.add(temp);
                }
            }
        }
        return output;
        
    }
    
    private int numberOfDigits(int number) {
        int count = 0; 
        while(number > 0) {
            count++;
            number/=10;
        }
        return count;
    }
    
    private int createNumber(int start, int digits) {
        int number = start;
        
        for(int i = 1; i < digits; i++) {
            number = number*10;
            start++;
            number += start;
        }
        return number;
    }
}