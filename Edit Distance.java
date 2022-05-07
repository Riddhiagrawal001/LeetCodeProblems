// the question is to find the minimum no of operations to convert word 1 to word 2 
// with insertions , deletions , replacement 

// the max no of operations to convert word 1 to word 2 would be n+m
// n=len(word1) -------> no of deletions
// m =len(word2) --------> no of insertions 

// recursion 
class Solution {
    static int countWays(int i,int j , String w1, String w2){
        if(j<0) return i+1;
        if(i<0) return j+1;
        
        // matching case
        if(w1.charAt(i)==w2.charAt(j))
            return 0+countWays(i-1,j-1,w1,w2);
        
         return Math.min(1+ countWays(i,j-1,w1,w2)  , Math.min(1+ countWays(i-1,j,w1,w2) , 1+ countWays(i-1,j-1,w1,w2))); 
          // insertion 1+ countWays(i,j-1,w1,w2)
         // deletion 1+ countWays(i-1,j,w1,w2)
        // replacing     countways(i-1,j-1,w1,w2)
        
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n =word2.length();
        int res=countWays(m-1,n-1,word1,word2);
        return res;
    }
}

// memoization 
class Solution {
    static int countWays(int i,int j , String w1, String w2,int[][] dp){
        if(j<0) return i+1;
        if(i<0) return j+1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        // matching case
        if(w1.charAt(i)==w2.charAt(j))
            return dp[i][j] = 0+countWays(i-1,j-1,w1,w2,dp);
        
         return dp[i][j] = Math.min(1+ countWays(i,j-1,w1,w2,dp)  , Math.min(1+ countWays(i-1,j,w1,w2,dp) , 1+ countWays(i-1,j-1,w1,w2,dp))); 
          // insertion 1+ countWays(i,j-1,w1,w2)
         // deletion 1+ countWays(i-1,j,w1,w2)
        // replacing     countways(i-1,j-1,w1,w2)
        
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n =word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        int res=countWays(m-1,n-1,word1,word2,dp);
        return res;
    }
}

// tabulation 
 public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n =word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        for(int i=0;i<=m;i++)
            dp[i][0]=i;
        for(int j=1;j<=n;j++)
            dp[0][j]=j;
        
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
            if(word1.charAt(i-1)==word2.charAt(j-1))
              dp[i][j] = 0+dp[i-1][j-1];
        
       else dp[i][j] = Math.min(1+ dp[i][j-1]  , Math.min(1+ dp[i-1][j] , 1+dp[i-1][j-1])); 
            }
        }
        return dp[m][n];
    }

// tabulation with space optimization
class Solution {

    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n =word2.length();
        int[] dp=new int[n+1];
            Arrays.fill(dp,-1);
        
        
        for(int j=0;j<=n;j++)
            dp[j]=j;
  
        
        
        for(int i=1;i<=m;i++){
            int[] curr=new int[n+1];
                curr[0]=i; 
            for(int j=1;j<=n;j++){
                
            if(word1.charAt(i-1)==word2.charAt(j-1))
              curr[j] = 0+dp[j-1];
        
       else curr[j] = Math.min(1+ curr[j-1]  , Math.min(1+ dp[j] , 1+dp[j-1])); 
            }
            dp=curr;
        }
        return dp[n];
    }
}
