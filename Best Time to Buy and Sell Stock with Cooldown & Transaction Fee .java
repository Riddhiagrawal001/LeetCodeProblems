//  Best Time to Buy and Sell Stock with Cooldown
// the question is exactly same as Buy and sell stock 2 
// with a constraint called as cooldown 
// cooldown means we cannot immediately buy a stock just after selling

// hence the slightest change would be in case of selling 
// rather than shifting directly to index+1 we will shift to index+2 so that we dont imediately buy after selling
// tabulation and memoization code would be similar to as od Buy and sell 2

//recursion 
class Solution {
    public static int buyAndSell(int index,int buy,int[] prices){
        if(index>=prices.length) return 0;
       
        int profit=0;
        // if allowed to buy 
        if(buy==1){      
                           // buying the current stock                   // not buying the current stock
        profit=Math.max((-prices[index]+buyAndSell(index+1,0,prices)), (0+buyAndSell(index+1,1,prices)) ) ;
        }
            
            
        // if not allowed to buy (selling)
        else {             // selling the current stock                  //not selling the current stock
          profit=Math.max((prices[index]+buyAndSell(index+2,1,prices)), (0+buyAndSell(index+1,0,prices)) ) ;  
        }    
        return profit; 
    }
    public int maxProfit(int[] prices) {
        return buyAndSell(0,1,prices);
    }
}

// memoization 
class Solution {
    public static int buyAndSell(int index,int buy,int[] prices,int[][] dp){
        if(index>=prices.length) return 0;
       if(dp[index][buy]!=-1) return dp[index][buy];
        int profit=0;
        // if allowed to buy 
        if(buy==1){      
                           // buying the current stock                   // not buying the current stock
        profit=Math.max((-prices[index]+buyAndSell(index+1,0,prices,dp)), (0+buyAndSell(index+1,1,prices,dp)) ) ;
        }
            
            
        // if not allowed to buy (selling)
        else {             // selling the current stock                  //not selling the current stock
          profit=Math.max((prices[index]+buyAndSell(index+2,1,prices,dp)), (0+buyAndSell(index+1,0,prices,dp)) ) ;  
        }    
        return dp[index][buy]=profit; 
    }
    public int maxProfit(int[] prices) {
        int m =prices.length;
        int[][]  dp=new int[m][2];
        for(int[] r : dp)
            Arrays.fill(r,-1);
        return buyAndSell(0,1,prices,dp);
    }
}

//tabulation 
class Solution {
  
    public int maxProfit(int[] prices) {
        int m =prices.length;
        int[][]  dp=new int[m+2][2];
        for(int[] r : dp)
            Arrays.fill(r,0);
        
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                int profit=0;
        if(j==1)      
        profit=Math.max((-prices[i]+dp[i+1][0]), (0+dp[i+1][1]) ) ;
        

        else 
          profit=Math.max((prices[i]+dp[i+2][1]), (0+dp[i+1][0]) ) ;  
         
      dp[i][j]= profit;  
            }
        }
        return dp[0][1];
    }
}

//  Best Time to Buy and Sell Stock with Transaction fee
// the fee will only be deduced when ever a transaction is complete

//recursion 
class Solution {
    public static int buyAndSell(int index,int buy,int[] prices,int fee){
         if(index>=prices.length) return 0;
       
        int profit=0;

        if(buy==1){      
     
        profit=Math.max((-prices[index]+buyAndSell(index+1,0,prices,fee)), (0+buyAndSell(index+1,1,prices,fee)) ) ;
        }
            
        else {            
          profit=Math.max((prices[index]-fee+buyAndSell(index+1,1,prices,fee)), (0+buyAndSell(index+1,0,prices,fee)) ) ;  
        }    
        return profit; 
    }
    public int maxProfit(int[] prices, int fee) {
        return buyAndSell(0,1,prices,fee);
    }
}

// memoization 
class Solution {
    public static int buyAndSell(int index,int buy,int[] prices,int fee,int[][] dp){
         if(index>=prices.length) return 0;
       if(dp[index][buy]!=-1) return dp[index][buy];
        int profit=0;

        if(buy==1){      
     
        profit=Math.max((-prices[index]+buyAndSell(index+1,0,prices,fee,dp)), (0+buyAndSell(index+1,1,prices,fee,dp)) ) ;
        }
            
        else {            
          profit=Math.max((prices[index]-fee+buyAndSell(index+1,1,prices,fee,dp)), (0+buyAndSell(index+1,0,prices,fee,dp)) ) ;  
        }    
        return dp[index][buy]=profit; 
    }
    public int maxProfit(int[] prices, int fee) {
        int m=prices.length;
        int[][] dp=new int[m+1][2];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        return buyAndSell(0,1,prices,fee,dp);
    }
}

// tabulation 
class Solution {
   
    public int maxProfit(int[] prices, int fee) {
        int m =prices.length;
        int[][]  dp=new int[m+2][2];
        for(int[] r : dp)
            Arrays.fill(r,0);
        
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                int profit=0;
        if(j==1)      
        profit=Math.max((-prices[i]+dp[i+1][0]), (0+dp[i+1][1]) ) ;
        

        else 
          profit=Math.max((prices[i]-fee+dp[i+1][1]), (0+dp[i+1][0]) ) ;  
         
      dp[i][j]= profit;  
            }
        }
        return dp[0][1];
    }
}

// tabulation with space optimization
class Solution {
   
    public int maxProfit(int[] prices, int fee) {
        int m =prices.length;
        int[] dp=new int[2];
  
        for(int i=m-1;i>=0;i--){
              int[] curr=new int[2];
            for(int j=0;j<=1;j++){
                int profit=0;
        if(j==1)      
        profit=Math.max((-prices[i]+dp[0]), (0+dp[1]) ) ;
        

        else 
          profit=Math.max((prices[i]-fee+dp[1]), (0+dp[0]) ) ;  
         
      curr[j]= profit;  
            }
           dp=curr; 
        }
        return dp[1];
    }
}
