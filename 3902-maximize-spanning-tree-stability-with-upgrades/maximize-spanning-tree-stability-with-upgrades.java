class Solution {
    //union find
    class DSU{
        int[] parent;
        int count;
        DSU(int n){
            parent = new int[n+1];
            for(int i = 0; i <= n ; i++) parent[i] = i;
            count = 0;
        }
        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa == pb) return false;
            parent[pa] = pb;
            count++;
            return true;
        }   
    }
   
    public int maxStability(int n, int[][] edges, int k) {
        //binary search
        int max = 0;
       for(int[] e : edges) max = Math.max(max,e[2]);
        int left = 0;
        int right = max * 2;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canbuild(n,edges,k,mid)){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        return ans;
    }

    private boolean canbuild(int n, int[][] edges,int k, int target){
        DSU dsu = new DSU(n);
        //int used = 0;
        int upgrades = 0;
        for(int[] e : edges){
            int u= e[0];
            int v = e[1];
            int w = e[2];
            int must = e[3];
            if(must == 1){
                if(w < target) return false;
                if(!dsu.union(u,v)) return false;
               // used++;
            }
        }
        
        for(int[] e : edges){
            if(e[3] == 0 && e[2] >= target){
                dsu.union(e[0],e[1]);
            }
        }

        for(int[] e : edges){
            int u= e[0];
            int v = e[1];
            int w = e[2];
            int must = e[3];
            if(must == 0 && w < target && (long)w * 2 >= (long)target){
                if(upgrades < k){
                    if(dsu.union(u,v)){
                        upgrades++;
                    }
                }
            }
        }
        return dsu.count == n-1;
    }
}