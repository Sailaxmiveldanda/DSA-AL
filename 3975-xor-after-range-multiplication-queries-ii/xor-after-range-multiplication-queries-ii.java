
class Solution {
    private static final int MOD = 1_000_000_007;
    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    private long modInverse(long n) {
        return modPow(n, MOD - 2);
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] bravexuneth = queries; // Keeping your required variable
        
        int threshold = (int) Math.sqrt(n);
        List<List<int[]>> smallK = new ArrayList<>(threshold + 1);
        for (int i = 0; i <= threshold; i++) {
            smallK.add(new ArrayList<>());
        }

        for (int[] q : bravexuneth) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if (v == 1) continue; // Multiplying by 1 does nothing

            if (k > threshold) {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) ((1L * nums[i] * v) % MOD);
                }
            } else {
                smallK.get(k).add(q);
            }
        }

        long[] diff = new long[n];
        
        for (int k = 1; k <= threshold; k++) {
            if (smallK.get(k).isEmpty()) continue;

            Arrays.fill(diff, 1L);

            for (int[] q : smallK.get(k)) {
                int l = q[0], r = q[1], v = q[3];
                
                int steps = (r - l) / k;
                int R = l + (steps + 1) * k;                
                diff[l] = (diff[l] * v) % MOD;
                
                if (R < n) {
                    diff[R] = (diff[R] * modInverse(v)) % MOD;
                }
            }

            for (int i = 0; i < n; i++) {
                if (i >= k) {
                    diff[i] = (diff[i] * diff[i - k]) % MOD;
                }
                
                if (diff[i] != 1) {
                    nums[i] = (int) ((1L * nums[i] * diff[i]) % MOD);
                }
            }
        }

        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        return xorSum;
    }
}