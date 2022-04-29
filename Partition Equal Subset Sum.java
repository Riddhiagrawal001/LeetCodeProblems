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



