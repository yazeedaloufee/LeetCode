class Solution {
    public int findDuplicate(int[] nums) {
     int fast = nums[0];
     int slow = nums[0]; 
    do {
        fast = nums[nums[fast]]; 
        slow = nums[slow];   
    } while (nums[fast] != nums[slow]);

    slow = nums[0];

    while(slow!=fast){
        slow = nums[slow];
        fast = nums[fast];
    }
    return slow;
    }
    
    
}