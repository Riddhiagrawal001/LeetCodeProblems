//recursion ( idea: if there exists one subset with thw sum =Total sum of the array/2 then there are subsets thats equal to the sum )
class Solution {
    public static boolean ifSubset(int index,int[] nums,int target){
        if(target==0) return true;
        if(index==0) return (nums[0]==target);
        
        boolean pick=false;
        if(target>=nums[index])
        pick=ifSubset(index-1,nums,target-nums[index]);
        boolean notpick=ifSubset(index-1,nums,target);
        
        return pick||notpick;
    }
    public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        boolean res=false;
        if(sum%2!=0) return res=false;
        else {
            int target=sum/2;
         res=ifSubset(nums.length-1,nums,target);
            
        }
        return res;
    }
}

// memoization & tabulation & tabulation with space optimization will be same as Subset sum equal to K 
// https://github.com/Riddhiagrawal001/LeetCodeProblems/commit/47d3f777bf5af890ed6af38c8c911fdd06784929

//memoization (but TLE)
class Solution {
    public static boolean ifSubset(int index,int[] nums,int target,int[][] dp){
        if(target==0) return true;
        if(index==0) return (nums[0]==target);
        
        if(dp[index][target]!=-1) return true;
        
        boolean pick=false;
        if(target>=nums[index])
        pick=ifSubset(index-1,nums,target-nums[index],dp);
        boolean notpick=ifSubset(index-1,nums,target,dp);
        
        boolean exp=pick||notpick;
        if(exp) dp[index][target]=1;
       
        return exp;
    }
    public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).sum();
          int target=sum/2;
        int[][] dp=new int[nums.length][target+1];
        
        for(int[] r:dp)
            Arrays.fill(r,-1);
        
        boolean res=false;
        if(sum%2!=0) return res=false;
        else 
         res=ifSubset(nums.length-1,nums,target,dp);
        return res;
    }
}

//tabulation
public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).sum();
          int target=sum/2;
        if(sum%2!=0) return false;
        
        boolean[][] dp=new boolean[nums.length][target+1];
        for(boolean[] r:dp)
            Arrays.fill(r,false);
        for(int i=0;i<nums.length;i++)
            dp[i][0]=true;
        for(int i=1;i<nums.length;i++){
            for(int tar=1;tar<=target;tar++){
                
                boolean pick=false;
        if(tar>=nums[i])
        pick=dp[i-1][tar-nums[i]];
        boolean notpick=dp[i-1][tar];
        
        dp[i][tar]=pick||notpick;
            }
        }
        return dp[nums.length-1][target];
    }
}


