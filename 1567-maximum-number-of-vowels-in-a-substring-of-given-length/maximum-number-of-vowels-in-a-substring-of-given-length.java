class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int maxcount = 0;
        int i = 0;
        for(int j = 0; j < s.length(); j++){
            if(Vowel(s.charAt(j))){
                count++;
            }
            if(j - i + 1 > k){
                if(Vowel(s.charAt(i))){
                    count--;
                }
                i++;
            }
            if(j - i +1 == k){
                maxcount = Math.max(count,maxcount);
            }
        }
        return maxcount;
    }
    private boolean Vowel(char c){
        return c =='a' || c == 'e' || c =='i' || c == 'o' || c =='u';
    }
}