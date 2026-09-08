class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        for(int[] interval : intervals){
            if(result.isEmpty() || result.get(result.size() -1)[1] < interval[0]){
                result.add(interval);
            }
            else{
                int[] end = result.get(result.size() - 1);
                end[1] = Math.max(end[1],interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}