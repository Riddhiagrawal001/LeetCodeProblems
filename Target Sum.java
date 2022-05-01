// same concpet as question number of subsets with difference d

// same code with target modified
class Solution {
    static final int m=(int)(Math.pow(10,9)+7);
    public static int findWays(int num[], int tar) {
		int[] dp=new int[tar+1];
		
        if(num[0]==0) dp[0]=2;
		else dp[0]=1;
        
		if(num[0]!=0 && num[0]<=tar) dp[num[0]]=1;
        
		for(int i=1;i<num.length;i++){
			int[] temp=new int[tar+1];
			
			for(int t=0;t<=tar;t++){
		int pick=0;
		if(t>=num[i]) pick=dp[t-num[i]];
		int notPick=dp[t];
		temp[t]=(pick+notPick)%m;
			}
			dp=temp;
		}
		return dp[tar];
		
    }

		
    public int findTargetSumWays(int[] nums, int target) {
        int ts=0;
        if(nums.length==1 && nums[0]==Math.abs(target) )return 1;
       for(int i=0;i<nums.length;i++) ts+=nums[i];
      if((ts-target)<0 || (ts-target)%2==1) return 0;
    
        int tar=(ts-target)/2;
        int res=findWays(nums,tar);
        return res;
    }
}
