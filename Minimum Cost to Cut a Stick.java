// recursion
class Solution {
    static int minCostToCut(int i , int j , int[] cuts){
        if(i>j ) return 0;
    
        int mini=Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost=(cuts[j+1]-cuts[i-1])+minCostToCut(i,ind-1,cuts)+minCostToCut(ind+1,j,cuts);
            mini=Math.min(mini,cost);
        }
        return mini;
    }
    public int minCost(int n, int[] cuts) {
      int[] newCuts=new int[cuts.length+2];
      newCuts[0]=0;
      for(int i=0;i<cuts.length;i++)
          newCuts[i+1]=cuts[i];
      newCuts[cuts.length+1]=n;
      Arrays.sort(newCuts);  
      return minCostToCut(1,cuts.length,newCuts); 
    }
}

// memoization
class Solution {
    static int minCostToCut(int i , int j , int[] cuts,int[][] dp){
        if(i>j ) return 0;
    
        if(dp[i][j]!=-1) return dp[i][j];
        int mini=Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost=(cuts[j+1]-cuts[i-1])+minCostToCut(i,ind-1,cuts,dp)+minCostToCut(ind+1,j,cuts,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
    public int minCost(int n, int[] cuts) {
      int[] newCuts=new int[cuts.length+2];
      newCuts[0]=0;
      for(int i=0;i<cuts.length;i++)
          newCuts[i+1]=cuts[i];
      newCuts[cuts.length+1]=n;
      Arrays.sort(newCuts);  
      int[][] dp=new int[cuts.length+2][cuts.length+2]; 
        for(int[] r:dp)
            Arrays.fill(r,-1);
      return minCostToCut(1,cuts.length,newCuts,dp); 
    }
}

// tabulation 
class Solution {

    public int minCost(int n, int[] cuts) {
      int[] newCuts=new int[cuts.length+2];
      newCuts[0]=0;
      for(int i=0;i<cuts.length;i++)
          newCuts[i+1]=cuts[i];
      newCuts[cuts.length+1]=n;
      Arrays.sort(newCuts);  
      int[][] dp=new int[cuts.length+2][cuts.length+2]; 
        for(int[] r:dp)
            Arrays.fill(r,0);
      for(int i=cuts.length;i>=1;i--){
          for(int j=1;j<=cuts.length;j++){
                if(i>j ) continue;
              int mini=Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost=(newCuts[j+1]-newCuts[i-1])+dp[i][ind-1]+dp[ind+1][j];
            mini=Math.min(mini,cost);
        }
        dp[i][j]=mini;
          }
      }  
      return dp[1][cuts.length]; 
    }
}
