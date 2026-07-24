class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            freq[c-'a']--;
            if(visited[c-'a']==true)continue;
            while(!stack.isEmpty() && stack.peek()>c && freq[stack.peek()-'a']>0){
                visited[stack.peek()-'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c-'a'] = true;
        }
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        str.reverse();
        return str.toString();
    }
}