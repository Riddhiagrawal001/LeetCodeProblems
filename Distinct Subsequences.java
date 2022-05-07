// no of ocuurences s2 has on s1 

// recursion 
class Solution {
    public static int countWays(int i, int j ,String s , String t){
       
        if(j<0) return 1;
        if(i<0 ) return 0;
            
        // matching case
        if(s.charAt(i)==t.charAt(j))
                  // not matching the    // i m matching the current occurence
                  // current occurence   // with the current occurence of the second string
            return countWays(i-1,j,s,t)+countWays(i-1,j-1,s,t);
        
        //non matching case
        return countWays(i-1,j,s,t);
        
            
    }
    public int numDistinct(String s, String t) {
        int res=countWays(s.length()-1,t.length()-1,s,t);
        return res;
    }
}

// memoization 
class Solution {
    public static int countWays(int i, int j ,String s , String t, int[][] dp){
       
        if(j<0) return 1;
        if(i<0 ) return 0;
            
        if(dp[i][j]!=-1) return dp[i][j];
        // matching case
        if(s.charAt(i)==t.charAt(j))
                  // not matching the    // i m matching the current occurence
                  // current occurence   // with the current occurence of the second string
            return dp[i][j]=countWays(i-1,j,s,t,dp)+countWays(i-1,j-1,s,t,dp);
        
        //non matching case
        return dp[i][j]=countWays(i-1,j,s,t,dp);
        
            
    }
    public int numDistinct(String s, String t) {
        int m =s.length();
        int n=t.length();
        int[][] dp=new int[m+1][n+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
    int res=countWays(m-1,n-1,s,t,dp);
        return res;
    }
}

//tabulation
 public int numDistinct(String s, String t) {
        int m =s.length();
        int n=t.length();
        long[][] dp=new long[m+1][n+1];
        for(long[] r:dp)
            Arrays.fill(r,-1);
        for(int i=0;i<=m;i++)
            dp[i][0]=1;
        for(int j=1;j<=n;j++)
            dp[0][j]=0;
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                  dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
        else dp[i][j]=dp[i-1][j];
            }
        }
        return (int)dp[m][n];
    }

// tabulatioon with space optimization 
 public int numDistinct(String s, String t) {
        int m =s.length();
        int n=t.length();
        long[] dp=new long[n+1];
            Arrays.fill(dp,0);
            dp[0]=1;
        
        for(int i=1;i<=m;i++){
            long[] curr=new long[n+1];
            curr[0]=1;
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                  curr[j]=dp[j]+dp[j-1];
        else curr[j]=dp[j];
            }
            dp=curr;
        }
        return (int)dp[n];
    }

// further space optimization from 2 arrays to just 1 array 
 public int numDistinct(String s, String t) {
        int m =s.length();
        int n=t.length();
        long[] dp=new long[n+1];
            Arrays.fill(dp,0);
            dp[0]=1;
        
        for(int i=1;i<=m;i++){
            for(int j=n;j>=1;j--){
                if(s.charAt(i-1)==t.charAt(j-1))
                  dp[j]=dp[j]+dp[j-1];
        else dp[j]=dp[j];
            }
          
        }
        return (int)dp[n];
    }
