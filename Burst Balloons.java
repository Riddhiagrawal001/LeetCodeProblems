// recursion 
class Solution {
    public int burstBallons(int i , int j , int[] nums ){
        if(i>j) return 0 ;
        
        int maxi=Integer.MIN_VALUE;
        for(int k=i ;k<=j;k++){
            int cost=nums[i-1]*nums[k]*nums[j+1]+burstBallons(i,k-1,nums)+burstBallons(k+1,j,nums);
            maxi=Math.max(maxi,cost);
        }
        return maxi;
    }
    public int maxCoins(int[] nums) {
    int[] newNums=new int[nums.length+2];
      newNums[0]=1;
      for(int i=0;i<nums.length;i++)
          newNums[i+1]=nums[i];
      newNums[nums.length+1]=1;
        return burstBallons(1,nums.length,newNums);
    }
}

//memoization
class Solution {
    public int burstBallons(int i , int j , int[] nums,int[][] dp ){
        if(i>j) return 0 ;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxi=Integer.MIN_VALUE;
        for(int k=i ;k<=j;k++){
            int cost=nums[i-1]*nums[k]*nums[j+1]+burstBallons(i,k-1,nums,dp)+burstBallons(k+1,j,nums,dp);
            maxi=Math.max(maxi,cost);
        }
        return dp[i][j]=maxi;
    }
    public int maxCoins(int[] nums) {
    int[] newNums=new int[nums.length+2];
      newNums[0]=1;
      for(int i=0;i<nums.length;i++)
          newNums[i+1]=nums[i];
      newNums[nums.length+1]=1;
        int[][] dp=new int[nums.length+2][nums.length+2];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        return burstBallons(1,nums.length,newNums,dp);
    }
}

//tabulation
class Solution {
    public int maxCoins(int[] nums) {
    int[] newNums=new int[nums.length+2];
      newNums[0]=1;
      for(int i=0;i<nums.length;i++)
          newNums[i+1]=nums[i];
      newNums[nums.length+1]=1;
        int[][] dp=new int[nums.length+2][nums.length+2];
        for(int[] r:dp)
            Arrays.fill(r,0);
        for(int i=nums.length;i>=1;i-- ){
            for(int j=1;j<=nums.length;j++){
                if(i>j) continue;
                 int maxi=Integer.MIN_VALUE;
        for(int k=i ;k<=j;k++){
            int cost=newNums[i-1]*newNums[k]*newNums[j+1]+dp[i][k-1]+dp[k+1][j];
            maxi=Math.max(maxi,cost);
        }
        dp[i][j]=maxi;
            }
        }
        return dp[1][nums.length];
    }
}
