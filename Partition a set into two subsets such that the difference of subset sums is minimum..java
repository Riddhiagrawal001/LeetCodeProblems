// will work only if the numbers in the array are all non-negative 
class Solution {
    public int minimumDifference(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++)
            total+=nums[i];
        int k=total;
        
        //subset sum with target k
        boolean[][] dp=new  boolean[nums.length][k+1]; 
        for(boolean[] r:dp)
        Arrays.fill(r,false);
        
        for(int i=0;i<nums.length;i++)
          dp[i][0]=true;
        if(k>=nums[0]) dp[0][nums[0]]=true;
        for(int i=1;i<nums.length;i++){
            for(int tar=1;tar<=k;tar++){
        boolean pick=false;
        if(tar>=nums[i])
        pick=dp[i-1][tar-nums[i]];
        boolean notpick=dp[i-1][tar];
        dp[i][tar]=pick||notpick;
            }
        }
        
       // dp[n-1][col-> 0 ............. total]
        int mini=999999;
        for(int i=0;i<=total/2;i++){
            if(dp[nums.length-1][i]){
                mini=Math.min(mini,Math.abs((total-i)-i));
            }
        }
        
        return mini;
        
        
    }
}


