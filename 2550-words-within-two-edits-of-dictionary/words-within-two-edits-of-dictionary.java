class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for(String query : queries){
            for(String word : dictionary){
                int count = 0;
                for(int i = 0; i < query.length(); i++){
                    if(query.charAt(i) != word.charAt(i)){
                        count++;
                    }
                }
                if(count <= 2){
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }
}