class Solution {
    public boolean isValid(String s) {
        // Stack<Character> stack = new Stack<>();
        // for(char ch : s.toCharArray()){
        //     if(ch == '(' || ch == '{' || ch == '['){
        //         stack.push(ch);
        //     }
        //     else{
        //         if(stack.isEmpty()) return false;
        //         else{
        //             char top = stack.pop();
        //             if((top != '(' && ch == ')') ||
        //             (top != '[' && ch == ']') ||
        //             (top != '{' && ch == '}')
        //             ){
        //                 return false;
        //             }
        //         }
        //     }
        // }
        // return stack.isEmpty();
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
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