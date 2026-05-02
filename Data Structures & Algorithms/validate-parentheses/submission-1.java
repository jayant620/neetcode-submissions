class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c=='(' || c== '{' || c=='['){
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()) return false;
            char top = stack.peek();
            if(c==')' && top == '('){
                stack.pop();
            } else if(c=='}' && top == '{'){
                stack.pop();
            } else if(c==']' && top == '['){
                stack.pop();
            } else{
                return false;
            }

        }
        return stack.isEmpty();
    }
}
