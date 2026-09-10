class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int write = 1;
        for(int read = 1; read <n ; read++){
            if(nums[read] != nums[write-1]){
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }
}