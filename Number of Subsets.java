//recursion 
import java.util.*;
public class Solution {
	public static int countWays(int index,int tar,int[] num){
		if(tar==0) return 1;
		if(index==0){
			if(num[index]==tar) return 1;
			else return 0;
		}
		
		int pick=0;
		if(tar>=num[index]) pick=countWays(index-1,tar-num[index],num);
		int notPick=countWays(index-1,tar,num);
		return dp[index][tar]=pick+notPick;
	}
    public static int findWays(int num[], int tar) {
        // Write your code here..
		int res=countWays(num.length-1,tar,num);
		return res;
		
    }
}

//memoization 
import java.util.*;
public class Solution {
	public static int countWays(int index,int tar,int[] num,int[][] dp){
		if(tar==0) return 1;
		if(index==0){
			if(num[index]==tar) return 1;
			else return 0;
		}
		if(dp[index][tar]!=-1) return dp[index][tar];
		int pick=0;
		if(tar>=num[index]) pick=countWays(index-1,tar-num[index],num,dp);
		int notPick=countWays(index-1,tar,num,dp);
		return dp[index][tar]=pick+notPick;
	}
    public static int findWays(int num[], int tar) {
        // Write your code here..
		int[][] dp=new int[num.length][tar+1];
		for(int[] r:dp)
			Arrays.fill(r,-1);
		
		int res=countWays(num.length-1,tar,num,dp);
		return res;
		
    }
}

//tabulation
public static int findWays(int num[], int tar) {
        // Write your code here..
		int[][] dp=new int[num.length][tar+1];
  
  // fill the array with 0 as -1 will give a wrong answer 
		for(int[] r:dp)
			Arrays.fill(r,0);
		for(int index=0;index<num.length;index++) dp[index][0]=1;
		if(num[0]<=tar) dp[0][num[0]] =1;
		
		for(int i=1;i<num.length;i++){
			for(int t=0;t<=tar;t++){
		int pick=0;
		if(t>=num[i]) pick=dp[i-1][t-num[i]];
		int notPick=dp[i-1][t];
		dp[i][t]=pick+notPick;
			}
		}
		return dp[num.length-1][tar];
		
    }

// tabulation with space optimization 
 public static int findWays(int num[], int tar) {
        // Write your code here..
		int[] dp=new int[tar+1];
		Arrays.fill(dp,0);
		dp[0]=1;
		if(num[0]<=tar) dp[num[0]] =1;
		
		for(int i=1;i<num.length;i++){
			int[] temp=new int[tar+1];
			temp[0]=1;
			for(int t=0;t<=tar;t++){
		int pick=0;
		if(t>=num[i]) pick=dp[t-num[i]];
		int notPick=dp[t];
		temp[t]=pick+notPick;
			}
			dp=temp;
		}
		return dp[tar];
		
    }
