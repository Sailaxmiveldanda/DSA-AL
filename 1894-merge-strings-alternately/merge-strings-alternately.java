class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int m = word1.length();
        int n = word2.length();
        int max = Math.max(m,n);
        for(int i = 0; i < max ; i++){
            if(i < m){
                result.append(word1.charAt(i));
            }
            if(i < n){
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
        // int i = 0;
        // int j = 0;
        // while(i < m || j < n){
        //     if(i < m){
        //         result.append(word1.charAt(i));
        //         i++;
        //     }
        //     if(j < n){
        //         result.append(word2.charAt(j));
        //         j++;
        //     }
        // }
       // return result.toString();
    }
}