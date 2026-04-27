class Solution {
    public int majorityElement(int[] nums) {
        //Arrays.sort(nums);
        //return nums[nums.length /2];
        int candiadate = 0;
        int count = 0;
        for(int num : nums){
            if(count == 0){
                candiadate = num;
            }
            if(num == candiadate){
                count++;
            }else{
                count --;
            }
        }
        return candiadate;
    }
}