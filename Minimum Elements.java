// recursion 
public class Solution {
	static int countCoins(int index,int x,int[] nums){
		if(index==0) {
			if(x%nums[0]==0) return x/nums[0];
			else return 999999;
		}
		
		int pick=99999;
		if(nums[index]<=x)
	     pick=1+countCoins(index,x-nums[index],nums);
		int notPick=0+countCoins(index-1,x,nums);
		
		return Math.min(pick,notPick);
	}
	
    public static int minimumElements(int num[], int x) {
        // Write your code here..
		int res=countCoins(num.length-1,x,num);
		return res>=9999 ? -1 : res;
    }

}

// memoization 
import java.util.*;
public class Solution {
	static int countCoins(int index,int x,int[] nums,int[][] dp){
		if(index==0) {
			if(x%nums[0]==0) return x/nums[0];
			else return 999999;
		}
		if(dp[index][x]!=-1) return dp[index][x];
		int pick=99999;
		if(nums[index]<=x)
	     pick=1+countCoins(index,x-nums[index],nums,dp);
		int notPick=0+countCoins(index-1,x,nums,dp);
		
		return dp[index][x]=Math.min(pick,notPick);
	}
    public static int minimumElements(int num[], int x) {
        // Write your code here..
		int[][] dp=new int[num.length][x+1];
		for(int[] r:dp)
			Arrays.fill(r,-1);
		int res=countCoins(num.length-1,x,num,dp);
		return res>=9999 ? -1 : res;
    }

}

//tabulation 
public static int minimumElements(int num[], int x) {
        // Write your code here..
		int[][] dp=new int[num.length][x+1];
		for(int[] r:dp)
			Arrays.fill(r,0);
		for(int t=0;t<=x;t++){
			if(t%num[0]==0) dp[0][t]=t/num[0];
			else dp[0][t]=99999;
		}
		for(int i=1;i<num.length;i++){
			for(int t=0;t<=x;t++){
				int pick=99999;
		if(num[i]<=t)
	     pick=1+dp[i][t-num[i]];
		int notPick=0+dp[i-1][t];
		dp[i][t]=Math.min(pick,notPick);
			}
		}
		
		return dp[num.length-1][x]>=9999 ? -1 : dp[num.length-1][x];
    }

// tabulation with space optimization
import java.util.*;
public class Solution {
	static int countCoins(int index,int x,int[] nums,int[][] dp){
		if(index==0) {
			if(x%nums[0]==0) return x/nums[0];
			else return 999999;
		}
		if(dp[index][x]!=-1) return dp[index][x];
		int pick=99999;
		if(nums[index]<=x)
	     pick=1+countCoins(index,x-nums[index],nums,dp);
		int notPick=0+countCoins(index-1,x,nums,dp);
		
		return dp[index][x]=Math.min(pick,notPick);
	}
    public static int minimumElements(int num[], int x) {
        // Write your code here..
		int[] dp=new int[x+1];
		Arrays.fill(dp,0);
		
		for(int t=0;t<=x;t++){
			if(t%num[0]==0) dp[t]=t/num[0];
			else dp[t]=99999;
		}
		for(int i=1;i<num.length;i++){
			int[] temp=new int[x+1];
			for(int t=0;t<=x;t++){
				int pick=99999;
		if(num[i]<=t)
	     pick=1+temp[t-num[i]];
		int notPick=0+dp[t];
		temp[t]=Math.min(pick,notPick);
			}
			dp=temp;
		}
		
		return dp[x]>=9999 ? -1 : dp[x];
    }

}
