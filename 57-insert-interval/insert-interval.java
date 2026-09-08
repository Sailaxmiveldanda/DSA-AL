class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> all = new ArrayList<>();
        for(int[] i : intervals){
            all.add(i);
        }
        all.add(newInterval);
        all.sort((a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        for(int[] interval : all){
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