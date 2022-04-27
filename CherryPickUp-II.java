// recursion 
class Solution {
    public static int countWays(int i,int j1,int j2 ,int[][] grid){
        int rows=grid.length-1;
        int cols=grid[0].length-1;
        int[] dir={-1,0,1};
        // out of bound test case
        if(j1<0 || j1>cols || j2<0 || j2>cols)
             return -1;
        
        if(i==rows){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        int maxi=0;
        
       // explore all the path 
        for(int x: dir ){
            for(int y :dir){
                if(j1==j2 ) maxi=Math.max(maxi,grid[i][j1]+countWays(i+1,j1+x,j2+y,grid));
                else maxi=Math.max(maxi,grid[i][j1]+grid[i][j2]+countWays(i+1,j1+x,j2+y,grid));
            }
        }
       return maxi;
        
    }
    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
         int res=countWays(0,0,cols-1,grid);
        return res;
    }
}

// memoization 
class Solution {
    public static int countWays(int i,int j1,int j2 ,int[][] grid,int [][][] dp){
        int rows=grid.length-1;
        int cols=grid[0].length-1;
        int[] dir={-1,0,1};
        // out of bound test case
        if(j1<0 || j1>cols || j2<0 || j2>cols)
             return -99999;
        
        if(i==rows){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1)  return dp[i][j1][j2];
        int maxi=0;
        
       // explore all the path 
        for(int x: dir ){
            for(int y :dir){
                if(j1==j2 ) maxi=Math.max(maxi,grid[i][j1]+countWays(i+1,j1+x,j2+y,grid,dp));
                else maxi=Math.max(maxi,grid[i][j1]+grid[i][j2]+countWays(i+1,j1+x,j2+y,grid,dp));
            }
        }
       return dp[i][j1][j2]=maxi;
        
    }
    public int cherryPickup(int[][] grid) {
        int rows=grid.length-1;
        int cols=grid[0].length-1;
        int[][][] dp=new int[rows+1][cols+1][cols+1];
        
        for( int[][] r:dp){
            for(int[] c:r)
                 Arrays.fill(c,-1);
        }
         int res=countWays(0,0,cols,grid,dp);
        return res;
    }
}

//tabulation 
 public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][][] dp=new int[rows+1][cols+1][cols+1];
        
        for( int[][] r:dp){
            for(int[] c:r)
                 Arrays.fill(c,-1);
        }
        
        //base case
        for(int j1=0;j1<cols;j1++){
            for(int j2=0;j2<cols;j2++){
                if(j1==j2 ) dp[rows-1][j1][j2]=grid[rows-1][j1];
                else 
                    dp[rows-1][j1][j2]=grid[rows-1][j1]+grid[rows-1][j2];
            }
        }
       
   
        for(int i=rows-2;i>=0;i--){
            
            for(int j1=0;j1<cols;j1++){
                for(int j2=0;j2<cols;j2++){
                     int maxi=-99999; 
          for(int x=-1;x<=+1;x++){
              for(int y=-1;y<=+1;y++){
                int val=0;
                if(j1==j2 ){
                    val=grid[i][j1];
                } 
                else val=grid[i][j1]+grid[i][j2];
                if(j1+x>=0 && j1+x<cols && j2+y>=0 && j2+y<cols)
                    val+=dp[i+1][j1+x][j2+y];
                else val=val+(-99999);
               // System.out.println(maxi+" "+val);
               maxi=Math.max(maxi,val);
            }
        } dp[i][j1][j2]=maxi;
                }
            }
        }
        
        
         // int res=countWays(0,0,cols,grid,dp);
        return dp[0][0][cols-1];
    }

// tabulation with space optimization 
 public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] front=new int[cols][cols];
       
        
        
        //base case
        for(int j1=0;j1<cols;j1++){
            for(int j2=0;j2<cols;j2++){
                if(j1==j2 ) front[j1][j2]=grid[rows-1][j1];
                else 
                    front[j1][j2]=grid[rows-1][j1]+grid[rows-1][j2];
            }
        }
       
   
        for(int i=rows-2;i>=0;i--){
             int[][] curr=new int [cols][cols];
            for(int j1=0;j1<cols;j1++){
                for(int j2=0;j2<cols;j2++){
                     int maxi=-99999; 
          for(int x=-1;x<=+1;x++){
              for(int y=-1;y<=+1;y++){
                int val=0;
                if(j1==j2 ){
                    val=grid[i][j1];
                } 
                else val=grid[i][j1]+grid[i][j2];
                if(j1+x>=0 && j1+x<cols && j2+y>=0 && j2+y<cols)
                    val+=front[j1+x][j2+y];
                else val=val+(-99999);
               // System.out.println(maxi+" "+val);
               maxi=Math.max(maxi,val);
            }
        } curr[j1][j2]=maxi;
                }
            }
            front=curr;
        }
        return front[0][cols-1];
    }
}
