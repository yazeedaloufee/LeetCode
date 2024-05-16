class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq  = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < k; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i] ){
            dq.removeLast();
            }
            dq.addLast(i);// we can adda condition to only add max value and pop the least one
            max = Math.max(max, nums[i]);
        }
        result[0] = max;

        for (int i = k; i < nums.length; i++) {

            if( dq.peekFirst() == i - k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i] ){
            dq.removeLast();
            }
            dq.addLast(i);
            result[i-k+1] = nums[dq.peekFirst()];
        }

        return result;
        
    }
}