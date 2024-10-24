class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderFreq = new HashMap<>();

        // Calculate remainder frequencies (keep negative remainders)
        for (int num : arr) {
            int remainder = num % k;
            // Normalize the remainder to always be positive
            if (remainder < 0) {
                remainder += k;
            }
            remainderFreq.put(remainder, remainderFreq.getOrDefault(remainder, 0) + 1);
        }

        // Iterate through each remainder and check for valid pairs
        for (Map.Entry<Integer, Integer> entry : remainderFreq.entrySet()) {
            int remainder = entry.getKey();
            int frequency = entry.getValue();

            // Handle remainder 0 (they need to form pairs with each other)
            if (remainder == 0) {
                if (frequency % 2 != 0) {
                    return false; // If there's an odd number of remainder 0s, return false
                }
            } else {
                // For positive remainders, check their complements
                int complement = k - remainder;
                if (!remainderFreq.containsKey(complement) || remainderFreq.get(complement) < frequency) {
                    return false; // If not enough complements, return false
                }
            }
        }

        return true;
        
    }
}