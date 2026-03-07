class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s = s + s;
        StringBuilder a1 = new StringBuilder(); //101010...
        StringBuilder a2 = new StringBuilder(); //010101...

        for(int i =0;i < s.length(); i++){
            a1.append(i%2 == 0 ? '0' : '1'); //0
            a2.append(i%2 == 0 ? '1' : '0'); //1
        }

        int diff1 =0;
        int diff2 = 0;
        int res =  Integer.MAX_VALUE;
        int left = 0;
        for(int right =0; right < s.length() ; right++){
            if(s.charAt(right) != a1.charAt(right)) diff1++;
            if(s.charAt(right) != a2.charAt(right)) diff2++;

            if(right - left + 1 > n){
                if(s.charAt(left) != a1.charAt(left)) diff1--;
                if(s.charAt(left) != a2.charAt(left)) diff2--;
                left++;
            }

            if(right - left + 1 == n){
                res = Math.min(res,Math.min(diff1,diff2));
            }
        }
        return res;
    }
}