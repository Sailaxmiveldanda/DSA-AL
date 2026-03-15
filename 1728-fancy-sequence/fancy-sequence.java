class Fancy {

    long mul = 1;
    long add = 0;
    int MOD = 1_000_000_007;

    List<Long> list;

    public Fancy() {
        list = new ArrayList<>();
    }
    
    public void append(int val) {

        long inv = modInverse(mul);

        long base = ((val - add) % MOD + MOD) % MOD;
        base = (base * inv) % MOD;

        list.add(base);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }
    
    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }
    
    public int getIndex(int idx) {

        if(idx >= list.size()) return -1;

        long val = list.get(idx);

        return (int)((val * mul + add) % MOD);
    }

    private long modInverse(long x){
        return modPow(x, MOD - 2);
    }

    private long modPow(long x, long n){
        long res = 1;

        x %= MOD;

        while(n > 0){

            if((n & 1) == 1)
                res = (res * x) % MOD;

            x = (x * x) % MOD;
            n >>= 1;
        }

        return res;
    }
}