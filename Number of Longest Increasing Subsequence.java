// concept is same , just we will have an count array which will save the the no of maximum lis till the index i

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int m =nums.length;
        int[] dp=new int[m];
        int[] count=new int[m];
            Arrays.fill(dp,1); 
        Arrays.fill(count,1);
        
        int maxi=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    count[i]=count[j];
                }
                else if(nums[j]<nums[i] && 1+dp[j]==dp[i]){
                    count[i]+=count[j];
                } 
            }
            maxi=Math.max(maxi,dp[i]); 
        }
        
        int count_max=0;
        for(int i=0;i<m;i++){
             if(dp[i]==maxi) count_max+=count[i];
        }
           

      return count_max;  
    }
}
