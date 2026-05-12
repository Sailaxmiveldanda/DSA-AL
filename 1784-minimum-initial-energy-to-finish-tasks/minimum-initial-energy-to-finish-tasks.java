class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a,b) -> {
            return (b[1]-b[0]) - (a[1]-a[0]);
        });
        int energy = 0;
        int res = 0;
        for(int[] task : tasks){
            int actual = task[0];
            int minimum = task[1];
            if(energy < minimum){
                res += (minimum - energy);
                energy = minimum;
            }
            energy -= actual;
        }
        return res;
    }
}