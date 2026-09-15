class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] s1freq = new int[26];
        int[] s2freq = new int[26];

        for(char ch : s1.toCharArray()){
            s1freq[ch - 'a']++;
        }

        int left = 0;
        for(int right = 0; right < s2.length();right++){
            char ch = s2.charAt(right);
            s2freq[ch - 'a']++;
            if(right - left + 1 > s1.length()){
                s2freq[s2.charAt(left) - 'a']--;
                left++;
            }
            if(Arrays.equals(s1freq,s2freq)){
                return true;
            }
        }
        return false;
    }
}