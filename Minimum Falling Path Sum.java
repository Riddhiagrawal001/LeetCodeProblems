// recursion
class Solution {
    public static int minWay(int r,int c,int[][] matrix){
        if(c< 0 || c>=matrix.length-1 ) return 9999; 
        if(r==0)
             return matrix[r][c];
        int down= matrix[r][c]+minWay(r-1,c,matrix);
        int ldiag= matrix[r][c]+minWay(r-1,c-1,matrix);
        int rdiag= matrix[r][c]+minWay(r-1,c+1,matrix);

        return Math.min(Math.min(down,rdiag),rdiag);
    }
    public int minFallingPathSum(int[][] matrix) {
        int row=matrix.length-1;
        
        int[] resArray=new int[row];
        for(int i=0;i<row;i++)
         resArray[i]=minWay(row,i,matrix);
        
        return Arrays.stream(resArray)
      .min()
      .getAsInt();
    }
}

// memoization
class Solution {
    public static int minWay(int r,int c,int[][] matrix,int[][] dp){
        if(c<0 || c>matrix.length-1) return 999999; 
        if(r==0 ){
            System.out.println(r+" "+c);
             return matrix[0][c];
        }
            
        if(dp[r][c]!=-1) return dp[r][c];
        int down= matrix[r][c]+minWay(r-1,c,matrix,dp);
        int ldiag= matrix[r][c]+minWay(r-1,c-1,matrix,dp);
        int rdiag= matrix[r][c]+minWay(r-1,c+1,matrix,dp);
        System.out.println(down+" "+ldiag+" "+rdiag);
        return dp[r][c]=Math.min(down,Math.min(rdiag,ldiag));
    }
    public int minFallingPathSum(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        //int[] resArray=new int[row];
        
        
        int[][] dp=new int[row+1][row+1];
        int minn=999999;
        for(int[] r:dp)
            Arrays.fill(r,-1);
       // System.out.println(row+" "+col);
        for(int i=0;i<col;i++)
         minn=Math.min(minn,minWay(row-1,i,matrix,dp));
        
        return minn;
    }
}

//tabulation
  public int minFallingPathSum(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] dp=new int[row+1][row+1];
        int minn=999999;
        for(int[] r:dp)
            Arrays.fill(r,0);
 
        for(int i=0;i<row;i++)
            dp[0][i]=matrix[0][i];
        
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                
                    int ldiag=0;
                int rdiag=0;
                    int down= matrix[i][j]+dp[i-1][j];
        if(j-1>=0) ldiag= matrix[i][j]+dp[i-1][j-1]; else ldiag=999999;
        if(j+1<matrix.length-1) rdiag= matrix[i][j]+dp[i-1][j+1];   else rdiag=999999;
                    dp[i][j]=Math.min(down,Math.min(rdiag,ldiag)); 
                
            }
        }
        
        for(int i=0;i<col;i++)
         minn=Math.min(minn,dp[row-1][i]);
        
        return minn;
    }
}
