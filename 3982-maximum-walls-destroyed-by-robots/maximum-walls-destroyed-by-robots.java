import java.util.Arrays;

class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        
        // Pack robot position and distance into a single long for efficient sorting
        // High 32 bits: position, Low 32 bits: distance
        long[] packed = new long[n];
        for (int i = 0; i < n; i++) {
            packed[i] = ((long) robots[i] << 32) | (distance[i] & 0xFFFFFFFFL);
        }
        Arrays.sort(packed);
        Arrays.sort(walls);
        
        int base = 0;
        int[] w = new int[walls.length];
        int wLen = 0;
        
        // Remove walls that are exactly at any robot's position
        // Since bullets destroy walls at the starting point unconditionally
        int rIdx = 0;
        for (int i = 0; i < walls.length; i++) {
            int wallPos = walls[i];
            while (rIdx < n) {
                int rPos = (int) (packed[rIdx] >>> 32);
                if (rPos < wallPos) {
                    rIdx++;
                } else {
                    break;
                }
            }
            if (rIdx < n && (int) (packed[rIdx] >>> 32) == wallPos) {
                base++;
            } else {
                w[wLen++] = wallPos;
            }
        }
        
        // Evaluate the 0th Segment (Walls to the left of the 1st robot)
        long firstX = packed[0] >>> 32;
        long firstD = packed[0] & 0xFFFFFFFFL;
        
        int segStart0 = 0;
        int segEnd0 = upperBound(w, wLen, firstX - 1);
        int S_0 = 0;
        if (segStart0 <= segEnd0) {
            int sStart = lowerBound(w, wLen, firstX - firstD);
            sStart = Math.max(sStart, segStart0);
            if (sStart <= segEnd0) {
                S_0 = segEnd0 - sStart + 1;
            }
        }
        
        int dp0 = S_0; // DP State: Robot i fires Left
        int dp1 = 0;   // DP State: Robot i fires Right
        
        // Evaluate strictly interior segments
        for (int i = 1; i < n; i++) {
            long leftX = packed[i - 1] >>> 32;
            long leftD = packed[i - 1] & 0xFFFFFFFFL;
            long rightX = packed[i] >>> 32;
            long rightD = packed[i] & 0xFFFFFFFFL;
            
            int segStart = lowerBound(w, wLen, leftX + 1);
            int segEnd = upperBound(w, wLen, rightX - 1);
            
            int P_i = 0, S_i = 0, B_i = 0;
            
            if (segStart <= segEnd) {
                int pEnd = upperBound(w, wLen, leftX + leftD);
                pEnd = Math.min(pEnd, segEnd);
                if (pEnd >= segStart) {
                    P_i = pEnd - segStart + 1;
                }
                
                int sStart = lowerBound(w, wLen, rightX - rightD);
                sStart = Math.max(sStart, segStart);
                if (sStart <= segEnd) {
                    S_i = segEnd - sStart + 1;
                }
                
                // Merge logic for B_i (When Left Robot fires Right, and Right Robot fires Left)
                if (P_i == 0) {
                    B_i = S_i;
                } else if (S_i == 0) {
                    B_i = P_i;
                } else {
                    int overlap = Math.max(0, pEnd - sStart + 1);
                    B_i = P_i + S_i - overlap;
                }
            }
            
            int nextDp0 = Math.max(dp0 + S_i, dp1 + B_i);
            int nextDp1 = Math.max(dp0, dp1 + P_i);
            
            dp0 = nextDp0;
            dp1 = nextDp1;
        }
        
        // Evaluate Segment N (Walls to the right of the final robot)
        long lastX = packed[n - 1] >>> 32;
        long lastD = packed[n - 1] & 0xFFFFFFFFL;
        
        int segStartN = lowerBound(w, wLen, lastX + 1);
        int segEndN = wLen - 1;
        int P_N = 0;
        
        if (segStartN <= segEndN) {
            int pEnd = upperBound(w, wLen, lastX + lastD);
            pEnd = Math.min(pEnd, segEndN);
            if (pEnd >= segStartN) {
                P_N = pEnd - segStartN + 1;
            }
        }
        
        return base + Math.max(dp0, dp1 + P_N);
    }
    
    // Finds the index of the first wall >= val
    private int lowerBound(int[] w, int wLen, long val) {
        int l = 0, r = wLen - 1;
        int ans = wLen;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (w[mid] >= val) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    // Finds the index of the last wall <= val
    private int upperBound(int[] w, int wLen, long val) {
        int l = 0, r = wLen - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (w[mid] <= val) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}