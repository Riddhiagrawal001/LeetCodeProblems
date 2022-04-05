class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            if(!stack.isEmpty() && c==')' && s.charAt(stack.peek())=='(')
                stack.pop();
            else 
              stack.push(i);
        }
        int index=-1;
        int max=0;
       
        for(int i:stack){
            max=Math.max(max,i-index-1);
            index=i;
        }
       max=Math.max(max,s.length()-index-1);
        return max;
    }
}
