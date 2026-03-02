class Solution {
    public int compress(char[] chars) {
        int read = 0;
        int write = 0;
        while(read < chars.length){
            char currentchar = chars[read];
            int count = 0;
            while(read < chars.length && chars[read] == currentchar){
                read++;
                count++;
            }
            chars[write] = currentchar;
            write++;
            if(count > 1){
                String value = String.valueOf(count);
                for(char ch : value.toCharArray()){
                    chars[write] = ch;
                    write++;
                }
            }
        }
        return write;
    }
}