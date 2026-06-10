import java.util.*;

class Solution {
    static class Node {
        int l, r;
        long val;

        Node(int l, int r, long val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }

    private int[][] stMax;
    private int[][] stMin;
    private int[] log2;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        buildSparseTables(nums);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        // Seed heap with the best candidate of each start index l => subarray [l..n-1]
        for (int l = 0; l < n; l++) {
            long val = getValue(l, n - 1);
            pq.offer(new Node(l, n - 1, val));
        }

        long ans = 0L;

        for (int picked = 0; picked < k; picked++) {
            Node cur = pq.poll();
            ans += cur.val;

            // Move to the next candidate in the same monotonic list for this l
            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                long nextVal = getValue(cur.l, nr);
                pq.offer(new Node(cur.l, nr, nextVal));
            }
        }

        return ans;
    }

    private void buildSparseTables(int[] nums) {
        int n = nums.length;
        log2 = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log2[i] = log2[i / 2] + 1;
        }

        int K = log2[n] + 1;
        stMax = new int[K][n];
        stMin = new int[K][n];

        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }

        for (int j = 1; j < K; j++) {
            int len = 1 << j;
            int half = len >> 1;
            for (int i = 0; i + len <= n; i++) {
                stMax[j][i] = Math.max(stMax[j - 1][i], stMax[j - 1][i + half]);
                stMin[j][i] = Math.min(stMin[j - 1][i], stMin[j - 1][i + half]);
            }
        }
    }

    private int rangeMax(int l, int r) {
        int len = r - l + 1;
        int j = log2[len];
        return Math.max(stMax[j][l], stMax[j][r - (1 << j) + 1]);
    }

    private int rangeMin(int l, int r) {
        int len = r - l + 1;
        int j = log2[len];
        return Math.min(stMin[j][l], stMin[j][r - (1 << j) + 1]);
    }

    private long getValue(int l, int r) {
        return (long) rangeMax(l, r) - rangeMin(l, r);
    }
}