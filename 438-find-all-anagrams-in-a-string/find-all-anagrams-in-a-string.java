class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()){
            return result;
        }
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(char ch : p.toCharArray()){
            f1[ch - 'a']++;
        }
        int left = 0;
        for(int right = 0; right < s.length() ; right++){
            f2[s.charAt(right) - 'a']++;
            if(right - left + 1 > p.length()){
                f2[s.charAt(left) - 'a']--;
                left++;
            }
            if(Arrays.equals(f1,f2)){
                result.add(left);
            }
        }
        return result;
    }
}