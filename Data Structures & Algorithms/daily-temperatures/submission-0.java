class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int t = temperatures[i];
            while(!stack.isEmpty() && t>stack.peek()[1]){
                int[] pair = stack.pop();
                result[pair[0]] = i - pair[0];
            }
            stack.push(new int[]{i, t});
        }
        return result;
    }
}
