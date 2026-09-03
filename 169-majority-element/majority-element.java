class Solution {
    public int majorityElement(int[] nums) {
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int n : nums){
        //     map.put(n, map.getOrDefault(n,0) + 1);
        // }
        // for(int key : map.keySet()){
        //     if(map.get(key) > nums.length / 2){
        //         return key;
        //     }
        // }
        // return -1;
        //boyer moore voting

        int candidate = 0;
        int count = 0;
        for(int n : nums){
            if(count == 0){
                candidate = n;
            }
            if(n == candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}