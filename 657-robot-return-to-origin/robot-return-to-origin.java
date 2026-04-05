class Solution {
    public boolean judgeCircle(String moves) {
        if((moves.length() & 1) == 1) return false;
        int[] f = new int[4];
        for(int i = 0; i < moves.length(); i++){
            int c = moves.charAt(i);
            f[(c^ ( c>> 2)) & 3]++;
        }
        return f[0] == f[1] && f[2] == f[3];
    }
}