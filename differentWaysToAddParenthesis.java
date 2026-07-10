class Solution {
    HashMap<String,List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
         try {
            result.add(Integer.parseInt(expression));
            return result;
        } catch (NumberFormatException e) {
            if(memo.containsKey(expression)){
                return memo.get(expression);
            }
            for(int i=0;i<expression.length();i++){
                if(Character.isDigit(expression.charAt(i)))continue;
                else{
                    String left = expression.substring(0,i);
                    String right = expression.substring(i+1,expression.length());
                    List<Integer> leftRes = diffWaysToCompute(left);
                    List<Integer> rightRes = diffWaysToCompute(right); 
                    for(int num1 : leftRes){
                        for(int num2 : rightRes){
                            int res = switch (expression.charAt(i)) {
                                case '+' -> num1 + num2;
                                case '-' -> num1 - num2;
                                case '*' -> num1 * num2;
                                default -> {
                                    System.out.println("Invalid operator: " + expression.charAt(i));
                                    yield 0;
                                }
                            };
                            result.add(res);
                        }
                    }
                }
            }
            memo.put(expression,result);
            return result;
        }
    }
}