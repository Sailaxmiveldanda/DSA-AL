class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int n1 = str1.length();
        int n2 = str2.length();
        int length = gcd(n1,n2);
        return str1.substring(0,length);
    }
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a% b);
    }
}