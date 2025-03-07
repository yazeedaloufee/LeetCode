import java.util.*;

class Solution {
    public int[] closestPrimes(int left, int right) {
        // Generate all prime numbers in the range [left, right]
        boolean[] isPrime = allPrimesCheck(right);
        List<Integer> primes = new ArrayList<>();
        
        for (int i = Math.max(2, left); i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        // If there are less than 2 primes, return [-1, -1]
        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }
        
        // Find the pair of consecutive primes with the smallest difference
        int[] result = new int[]{-1, -1};
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
            }
        }
        
        return result;
    }
    
    private boolean[] allPrimesCheck(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
}