// recursion 
class Solution {
    static int coinChange(int index,int amount,int[] coins){
        
        if(index==0){
            if(amount % coins[index]==0) return 1;
            else return 0;
        }
        int pick=0;
        if(amount>=coins[index])
        pick=coinChange(index,amount-coins[index],coins);
        int notpick=coinChange(index-1,amount,coins);
        
        return pick+notpick;
    }
    public int change(int amount, int[] coins) {
        int res=coinChange(coins.length-1,amount,coins);
        return res;
    }
}

// memoization 
class Solution {
    static int coinChange(int index,int amount,int[] coins,int[][] dp){
        
        if(index==0){
            if(amount % coins[index]==0) return 1;
            else return 0;
        }
        if(dp[index][amount]!=-1) return dp[index][amount];
        int pick=0;
        if(amount>=coins[index])
        pick=coinChange(index,amount-coins[index],coins,dp);
        int notpick=coinChange(index-1,amount,coins,dp);
        
        return dp[index][amount]=pick+notpick;
    }
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        int res=coinChange(coins.length-1,amount,coins,dp);
        return res;
    }
}

//tabulation
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] r:dp)
            Arrays.fill(r,0);
        for(int amt=0;amt<=amount;amt++){
            if(amt % coins[0]==0) dp[0][amt]=1;
            else dp[0][amt]=0;
        }
        for(int c=1;c<coins.length;c++){
            for(int amt=0;amt<=amount;amt++){
                int pick=0;
                if(amt>=coins[c])
                    pick=dp[c][amt-coins[c]];
                int notpick=dp[c-1][amt];
                dp[c][amt]=pick+notpick;
            }
        }
        
        return dp[coins.length-1][amount];
    }
}

// tabulation with space optimization 
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,0);
        for(int amt=0;amt<=amount;amt++){
            if(amt % coins[0]==0) dp[amt]=1;
            else dp[amt]=0;
        }
        for(int c=1;c<coins.length;c++){
            int[] temp=new int[amount+1];
            for(int amt=0;amt<=amount;amt++){
                int pick=0;
                if(amt>=coins[c])
                    pick=temp[amt-coins[c]];
                int notpick=dp[amt];
                temp[amt]=pick+notpick;
            }
            dp=temp;
        }
        
        return dp[amount];
    }
}
