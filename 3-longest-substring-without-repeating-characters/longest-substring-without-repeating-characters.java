class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map<Character,Integer> map = new HashMap<>();
        // int left = 0;
        // int right = 0;
        // int len = 0;
        // for(right = 0; right < s.length(); right++){
        //     char ch = s.charAt(right);
        //     if(map.containsKey(ch)){
        //         left = Math.max(left,map.get(ch) + 1);
        //     }
        //     map.put(ch,right);
        //     len = Math.max(len, right - left + 1);
        // }
        // return len;
        int[] freq = new int[128];
        int left = 0;
        int right = 0;
        int len = 0;
        for(right=0; right < s.length();right++){
            char ch = s.charAt(right);
            freq[ch]++;

            while(freq[ch] > 1){
                char leftchar = s.charAt(left);
                freq[leftchar]--;
                left++;
            }
            len = Math.max(len,right - left + 1);
        }
        return len;
    }
}