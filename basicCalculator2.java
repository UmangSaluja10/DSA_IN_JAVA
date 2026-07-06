class Solution {
    public static void process(char prevOp, int num, ArrayDeque<Integer> stack){
        if(prevOp == '+'){
            stack.push(num);
        }
        else if(prevOp == '-'){
            stack.push(-num);
        }
        else if(prevOp == '*'){
            stack.push(stack.pop() * num);
        }
        else if(prevOp == '/'){
            stack.push(stack.pop() / num);
        }
    }

    public int calculate(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char prevOp = '+';

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                process(prevOp, num, stack);

                // 🔴 FIX: update ONLY if operator
                if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                    prevOp = ch;
                }

                num = 0;
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;
    }
}