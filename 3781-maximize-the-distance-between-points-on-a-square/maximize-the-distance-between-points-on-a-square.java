class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            
            if (y == 0) {
                pos[i] = x;
            } else if (x == side) {
                pos[i] = side + y;
            } else if (y == side) {
                pos[i] = 2L * side + (side - x);
            } else {
                pos[i] = 3L * side + (side - y);
            }
        }
        Arrays.sort(pos);
        long perimeter = 4L * side;
        long[] extendedPos = new long[2 * n];
        for (int i = 0; i < n; i++) {
            extendedPos[i] = pos[i];
            extendedPos[i + n] = pos[i] + perimeter;
        }
        
        long low = 1;
        long high = perimeter / k;
        long ans = 1;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (check(extendedPos, n, k, mid, perimeter)) {
                ans = mid;        // mid is possible, try for a larger distance
                low = mid + 1;
            } else {
                high = mid - 1;   // mid is too large, search lower
            }
        }
        
        return (int) ans;
    }
    private boolean check(long[] pos, int n, int k, long dist, long perimeter) {
        for (int i = 0; i < n; i++) {
            int count = 1;
            long lastPos = pos[i];
            long targetEnd = pos[i] + perimeter;
            int curr = i;
            
            for (int j = 1; j < k; j++) {
                int nextIdx = lowerBound(pos, curr + 1, pos.length, lastPos + dist);
                
                // If we run out of valid points in our wrap-around window
                if (nextIdx >= i + n) {
                    count = -1;
                    break;
                }
                
                lastPos = pos[nextIdx];
                curr = nextIdx;
                count++;
            }
            
            // If we successfully placed k points AND the gap back to the start is valid
            if (count == k && (targetEnd - lastPos) >= dist) {
                return true;
            }
        }
        return false;
    }
    private int lowerBound(long[] arr, int start, int end, long target) {
        int low = start;
        int high = end - 1;
        int ans = end; // Default to out of bounds
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
      
}