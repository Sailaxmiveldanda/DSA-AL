class Solution {
    int count = 0;
    String ans = "";
    public String getHappyString(int n, int k) {
        dfs("",n,k);
        return ans;
    }
    private void dfs(String curr, int n, int k){
        if(curr.length() == n){
            count++;
            if(count  == k){
                ans = curr;
            }
            return;
        }
        for(char c : new char[]{'a','b','c'}){
            if(curr.length() > 0 && curr.charAt(curr.length() - 1) == c) continue;
            dfs(curr+c,n,k);
            if(!ans.equals("")) return;
        }
    }
}