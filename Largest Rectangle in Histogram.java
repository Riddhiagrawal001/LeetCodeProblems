class Solution {
    public int largestRectangleArea(int[] heights) {
         Stack<Integer> stk = new Stack();  
        int maxA=0;
        int n=heights.length;
        for(int i=0;i<=n;i++){
            while(!stk.empty() && (i==n || heights[stk.peek()]>=heights[i])){ 
                int height=heights[stk.peek()];
                stk.pop();
                int width;
                if(stk.empty()) width=i;
                else width=i-stk.peek()-1;
                maxA=Math.max(maxA,width*height);
            }
            stk.push(i);
        }
        return maxA;
    }
}
