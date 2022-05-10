// recursion 
class Solution {
    public static int buyAndSell(int index, int buy,int[] prices ){
        if(index==prices.length)
            return 0;
        
        
        
        int profit=0;
        // if allowed to buy 
        if(buy==1){      
                           // buying the current stock                   // not buying the current stock
        profit=Math.max((-prices[index]+buyAndSell(index+1,0,prices)), (0+buyAndSell(index+1,1,prices)) ) ;
        }
            
            
        // if not allowed to buy (selling)
        else {             // selling the current stock                  //not selling the current stock
          profit=Math.max((prices[index]+buyAndSell(index+1,1,prices)), (0+buyAndSell(index+1,0,prices)) ) ;  
        }    
        return profit;    
        
    }
    public int maxProfit(int[] prices) {
        int m =prices.length;
        int res=buyAndSell(0,1,prices);
        return res;
    }
}

// memoization 
class Solution {
    public static int buyAndSell(int index, int buy,int[] prices,int[][] dp ){
        if(index==prices.length)
            return 0;
        if(dp[index][buy]!=-1) return dp[index][buy];  
        int profit=0;
        // if allowed to buy 
        if(buy==1){      
                           // buying the current stock                   // not buying the current stock
        profit=Math.max((-prices[index]+buyAndSell(index+1,0,prices,dp)), (0+buyAndSell(index+1,1,prices,dp)) ) ;
        }
            
            
        // if not allowed to buy (selling)
        else {             // selling the current stock                  //not selling the current stock
          profit=Math.max((prices[index]+buyAndSell(index+1,1,prices,dp)), (0+buyAndSell(index+1,0,prices,dp)) ) ;  
        }    
        return dp[index][buy]= profit;    
        
    }
    public int maxProfit(int[] prices) {
        int m =prices.length;
        int[][]  dp=new int[m][2];
        for(int[] r : dp)
            Arrays.fill(r,-1);
        int res=buyAndSell(0,1,prices,dp);
        return res;
    }
}

// tabulation
class Solution {
    public int maxProfit(int[] prices) {
        int m =prices.length;
        int[][]  dp=new int[m+1][2];
        for(int[] r : dp)
            Arrays.fill(r,-1);
        dp[m][0]=dp[m][1]=0;
        for(int i=m-1;i>=0;i--){
        for (int j=0;j<=1;j++){
            int profit=0;
        if(j==1)      
        profit=Math.max((-prices[i]+dp[i+1][0]), (0+dp[i+1][1]) ) ;
        

        else 
          profit=Math.max((prices[i]+dp[i+1][1]), (0+dp[i+1][0]) ) ;  
         
      dp[i][j]= profit;  
        }
        }
        return dp[0][1];
    }
}

//tabulation with space optimization 
class Solution {
    public int maxProfit(int[] prices) {
        int m =prices.length;
        int[]  dp=new int[2];
        Arrays.fill(dp,-1);
        dp[0]=dp[1]=0;
        for(int i=m-1;i>=0;i--){
             int[] temp=new int[2];
        for (int j=0;j<=1;j++){
            int profit=0;
        if(j==1)      
        profit=Math.max((-prices[i]+dp[0]), (0+dp[1]) ) ;
        

        else 
          profit=Math.max((prices[i]+dp[1]), (0+dp[0]) ) ;  
         
       temp[j]= profit;  
        }
            dp=temp;
        }
        return dp[1];
    }
}
