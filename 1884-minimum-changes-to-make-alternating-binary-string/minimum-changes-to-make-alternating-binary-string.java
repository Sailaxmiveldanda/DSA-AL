class Solution {
    public int minOperations(String s) {
        int p1 =0;
        int p2 =0;
        for(int i =0; i < s.length();i++){
            char ch = s.charAt(i);
            if(i % 2 == 0){
                if(ch != '0') p1++;
                if(ch != '1') p2++;
            }
            else{
                if(ch != '1') p1++;
                if(ch != '0') p2++;
            }
        }
        return Math.min(p1,p2);
    }
}