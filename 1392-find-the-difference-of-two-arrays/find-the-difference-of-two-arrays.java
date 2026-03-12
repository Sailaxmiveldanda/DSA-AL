class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> map1 = new HashSet<>();
        Set<Integer> map2 =  new HashSet<>();
        for(int n : nums1) map1.add(n);
        for(int n : nums2) map2.add(n);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int n : map1){
            if(!map2.contains(n)){
                list1.add(n);
            }
        }
        for(int n : map2){
            if(!map1.contains(n)){
                list2.add(n);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);
        return result;
    }
}