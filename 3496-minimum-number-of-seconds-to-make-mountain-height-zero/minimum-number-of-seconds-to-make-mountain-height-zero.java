class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0;
        long right = (long)1e16;
        while(left < right){
            long mid = left + (right - left) / 2;
            if(canReduce(mid,mountainHeight,workerTimes)){
                right = mid;
            }
            else{
                left = mid +1;
            }
        }
        return left;
    }
        private boolean canReduce(long time, int H, int[] workerTimes){

        long total = 0;

        for(int t : workerTimes){

            long x = (long)(Math.sqrt((2.0*time)/t + 0.25) - 0.5);

            total += x;

            if(total >= H)
                return true;
        }

        return false;
    }
}