// recursion 
class Solution {
    static int longestIncSub(int index,int prev_index,int[] nums){
        if(index==nums.length) return 0;

        int pick=0;
        if(prev_index==-1 || nums[index]>nums[prev_index])
            pick= 1+longestIncSub(index+1,index,nums);
        int not_pick=0+longestIncSub(index+1,prev_index,nums);
        return Math.max(pick,not_pick);
    }
    public int lengthOfLIS(int[] nums) {
        int m =nums.length;
      return longestIncSub(0, -1,nums);  
    }
}

// memoization 
class Solution {
    static int longestIncSub(int index,int prev_index,int[] nums,int[][] dp){
        if(index==nums.length) return 0;
        
        if(dp[index][prev_index+1]!=-1 ) return dp[index][prev_index+1];
        int pick=0;
        if(prev_index==-1 || nums[index]>nums[prev_index])
            pick= 1+longestIncSub(index+1,index,nums,dp);
        int not_pick=0+longestIncSub(index+1,prev_index,nums,dp);
        return dp[index][prev_index+1]=Math.max(pick,not_pick);
    }
    public int lengthOfLIS(int[] nums) {
        int m =nums.length;
        int[][] dp=new int[m][m+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
      return longestIncSub(0, -1,nums,dp);  
    }
}
