class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            List<Integer> temp = new ArrayList<>();
            while(num > 0){
                int n = num %10;
                temp.add(n);
                num /= 10;
            }
            Collections.reverse(temp);
            list.addAll(temp);
        }
        int[] res = new int[list.size()];
        for(int i =0; i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
        
    }

}