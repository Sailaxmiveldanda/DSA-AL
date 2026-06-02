class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        return Math.min(
            solve(landStartTime, landDuration, waterStartTime, waterDuration),
            solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    private int solve(int[] start1, int[] duration1,
                      int[] start2, int[] duration2) {
        int firstFinish = Integer.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {
            firstFinish = Math.min(firstFinish, start1[i] + duration1[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < start2.length; i++) {
            int secondStart = Math.max(firstFinish, start2[i]);
            int finishTime = secondStart + duration2[i];
            ans = Math.min(ans, finishTime);
        }

        return ans;
    }
}