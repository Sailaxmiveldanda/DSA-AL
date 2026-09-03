class Solution {
    public boolean isAnagram(String s, String t) {
        // if(s.length() != t.length()){
        //     return false;
        // }
        // HashMap<Character,Integer> map1 = new HashMap<>();
        // HashMap<Character,Integer> map2 = new HashMap<>();

        // for(char ch : s.toCharArray()){
        //     map1.put(ch, map1.getOrDefault(ch , 0) +1);
        // }
        // for(char ch : t.toCharArray()){
        //     map2.put(ch, map2.getOrDefault(ch,0) +1);
        // }
        // return map1.equals(map2);
        // //time - O(n) space - O(k)

        //freq method
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char ch : s.toCharArray()){
            freq1[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            freq2[ch - 'a']++;
        }
        return Arrays.equals(freq1,freq2);
        //time - O(n) space O(1)
    }
}