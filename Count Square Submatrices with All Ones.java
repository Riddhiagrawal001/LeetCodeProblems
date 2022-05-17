class Solution {
    public int countSquares(int[][] matrix) {
        int col=matrix[0].length;
            int row=matrix.length;
        int[][] dp=new int[row][col];

        for(int[] r:dp)
            Arrays.fill(r,0); 
                for(int j=0;j<col;j++) dp[0][j]=matrix[0][j];
        for(int i=0;i<row;i++) dp[i][0]=matrix[i][0];
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]==0) dp[i][j]=0;
                else {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        int sum=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                sum+=dp[i][j];
        }
        return sum;
    }
}
