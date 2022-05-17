// using the concept of largest area in the histogram 
// for every row consider the blocks length as a histogram and pass it into the function
class Solution {
    // largest area in the histogram 
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
    public int maximalRectangle(char[][] matrix) {
        int col=matrix[0].length;
        int row=matrix.length;
        int[] temp=new int[col];
        Arrays.fill(temp,0);
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1') temp[j]++;
                else temp[j]=0;
            }
            int area=largestRectangleArea(temp);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}
