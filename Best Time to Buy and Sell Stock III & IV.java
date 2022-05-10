// recursion  tc : exponential sc:O(n)
class Solution {
    static int buyAndSell(int index,int buy,int cap,int[] prices){
    if(cap==0)
        return 0;
    if(index==prices.length)
        return 0;
    
    int profit=0;
    if(buy==1){
        profit=Math.max((-prices[index]+buyAndSell(index+1,0,cap,prices)),(0+buyAndSell(index+1,1,cap,prices)));
    }
    else 
        profit=Math.max((prices[index]+buyAndSell(index+1,1,cap-1,prices)),(0+buyAndSell(index+1,0,cap,prices)));
    
    return profit;
}
    public int maxProfit(int[] prices) {
        int res=buyAndSell(0,1,2,prices);
        return res;
    }
}

// memoization tc: O(mx2x3) sc: O(mx2x3)+O(n)
class Solution {
    static int buyAndSell(int index,int buy,int cap,int[] prices,int[][][] dp){
    if(cap==0)
        return 0;
    if(index==prices.length)
        return 0;
    if(dp[index][buy][cap]!=-1) return dp[index][buy][cap];
    int profit=0;
    if(buy==1){
        profit=Math.max((-prices[index]+buyAndSell(index+1,0,cap,prices,dp)),(0+buyAndSell(index+1,1,cap,prices,dp)));
    }
    else 
        profit=Math.max((prices[index]+buyAndSell(index+1,1,cap-1,prices,dp)),(0+buyAndSell(index+1,0,cap,prices,dp)));
    
    return dp[index][buy][cap]=profit;
}
    public int maxProfit(int[] prices) {
        int m=prices.length;
        int[][][] dp =new int[m][2][3];
        for(int[][] r : dp){
            for(int[] c : r)
                Arrays.fill(c,-1);
        }
        int res=buyAndSell(0,1,2,prices,dp);
        return res;
    }
}

// tabulation  tc:O(mx2x3) sc:O(mx2x3)
class Solution {
    public int maxProfit(int[] prices) {
        int m=prices.length;
        int[][][] dp =new int[m+1][2][3];
        for(int[][] r : dp){
            for(int[] c : r)
                Arrays.fill(c,-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<=1;j++)
                dp[i][j][0]=0;
        }
        for(int b=0;b<=1;b++){
            for(int c=0;c<=2;c++ )
                dp[m][b][c]=0;
        }
        for(int i=m-1;i>=0;i--){
            for(int b=0;b<=1;b++){
                for(int c=1;c<=2;c++){
                    int profit=0;
                    if(b==1){
        profit=Math.max((-prices[i]+dp[i+1][0][c]),(0+dp[i+1][1][c]));
    }
    else 
        profit=Math.max((prices[i]+dp[i+1][1][c-1]),(0+dp[i+1][0][c]));
    
        dp[i][b][c]=profit;
                }
            }
        }
        return dp[0][1][2];
    }
}

// tabulation with space optimization
class Solution {

    public int maxProfit(int[] prices) {
        int m=prices.length;
        int[][] dp =new int[2][3];

        for(int i=0;i<m;i++){
            for(int j=0;j<=1;j++)
                dp[j][0]=0;
        }
        for(int b=0;b<=1;b++){
            for(int c=0;c<=2;c++ )
                dp[b][c]=0;
        }
        for(int i=m-1;i>=0;i--){
            int[][] curr =new int[2][3];
            for(int b=0;b<=1;b++){
                for(int c=1;c<=2;c++){
                    int profit=0;
                    if(b==1){
        profit=Math.max((-prices[i]+dp[0][c]),(0+dp[1][c]));
    }
    else 
        profit=Math.max((prices[i]+dp[1][c-1]),(0+dp[0][c]));
    
        curr[b][c]=profit;
                }
            }
            dp=curr;
        }
        return dp[1][2];
    }
}

//  BUY AND SELL STOCKS IV
class Solution {
    public int maxProfit(int k, int[] prices) {
        int m=prices.length;
        int[][] dp =new int[2][k+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<=1;j++)
                dp[j][0]=0;
        }
        for(int b=0;b<=1;b++){
            for(int c=0;c<=k;c++ )
                dp[b][c]=0;
        }
        for(int i=m-1;i>=0;i--){
            int[][] curr =new int[2][k+1];
            for(int b=0;b<=1;b++){
                for(int c=1;c<=k;c++){
                    int profit=0;
                    if(b==1){
        profit=Math.max((-prices[i]+dp[0][c]),(0+dp[1][c]));
    }
    else 
        profit=Math.max((prices[i]+dp[1][c-1]),(0+dp[0][c]));
    
        curr[b][c]=profit;
                }
            }
            dp=curr;
        }
        return dp[1][k];
    }
}
