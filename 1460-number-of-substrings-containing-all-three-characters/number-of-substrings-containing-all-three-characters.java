class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int[] lastPos = { -1, -1, -1 };
        int total = 0;

        for (int pos = 0; pos < len; pos++) {
            lastPos[s.charAt(pos) - 'a'] = pos;
            total += 1 + Math.min(lastPos[0], Math.min(lastPos[1], lastPos[2]));
        }

        return total;
    }
}