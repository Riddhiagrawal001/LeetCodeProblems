// recursive way but time exceded  ( tc: O(2^n) sc:O(n) )
class Solution {
    public int func(int index,int[] arr){
        if(index==0) return arr[index];
        if(index<0) return 0;
        
        int pick = arr[index]+func(index-2,arr);
        int nonPick=0+func(index-1,arr);
        return Math.max(pick,nonPick);
    } 
    
    public int rob(int[] nums) {
        int res=func(nums.length-1,nums);
        return res;
        
    }
}

// memoized way ( tc:O(n) sc:O(n) + (n)[array space+ stack space] ) due to a dp array
class Solution {
    public int func(int index,int[] arr,int[] dp){
        if(index==0) return arr[index];
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        
        int pick = arr[index]+func(index-2,arr,dp);
        int nonPick=0+func(index-1,arr,dp);
        return dp[index]=Math.max(pick,nonPick);
    } 
    
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int res=func(nums.length-1,nums,dp);
        return res;
        
    }
}

// tabular way  ( tc:O(n) sc:O(n) [array space] ) 
public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        int neg=0;
        // int res=func(nums.length-1,nums,dp);
       // int max=0;
        for(int i=1;i<=nums.length-1;i++){
               int pick=0;
            if(i-2<0) pick=nums[i]+neg;
            else pick=nums[i]+dp[i-2];
       
            int nonpick=0+dp[i-1];
            dp[i]=Math.max(pick,nonpick);
        }
        
        return dp[nums.length-1];
        
    }

// tabular way with space optimization
 public int rob(int[] nums) {
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<=nums.length-1;i++){
               int pick=0;
            pick=nums[i]+prev2;
            int nonpick=0+prev;
            int curr =Math.max(pick,nonpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
        
    }
