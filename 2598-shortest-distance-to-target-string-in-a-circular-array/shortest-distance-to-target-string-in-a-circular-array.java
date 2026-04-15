class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int mdist = Integer.MAX_VALUE;

        for(int i = 0; i < n ; i++){
            if(words[i].equals(target)){
                int diff = Math.abs(i - startIndex);
                int dist = Math.min(diff, n - diff);
                mdist = Math.min(mdist,dist);
            }
        }
        return mdist == Integer.MAX_VALUE ? -1 : mdist;
    }
}

//  int n =  words.length;
//         for(int i = 0; i < n ; i++){
//             int left = (startIndex + i) % n;
//             int right = (startIndex - i + n) % n;

//             if(words[left].equals(target) || words[right].equals(target)){
//                 return i;
//             }
//         }
//         return -1;