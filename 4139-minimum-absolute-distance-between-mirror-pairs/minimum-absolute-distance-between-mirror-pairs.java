class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int mdist = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                int dist = i - map.get(nums[i]);
                mdist = Math.min(dist,mdist);
            }
            int target = reverse(nums[i]);
            map.put(target, i);
        }

        return mdist == Integer.MAX_VALUE ? -1 : mdist;
    }
    private int reverse(int n){
        int rev = 0;
        while(n > 0){
            rev = rev * 10 + ( n % 10);
            n = n / 10;
        }
        return rev;
    }
}