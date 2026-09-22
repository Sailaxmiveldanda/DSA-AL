class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch)){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty() || stack.pop() != map.get(ch)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}