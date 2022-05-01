// the idea is: its given s1-s2=D and S1+S2=TotalSum 
// s1=TotalSum-S2
// (TotalSum-s2)-s2=D 
// s2= TotalSum-D/2 
 
// TotalSum-D >0 as the numbers are postive 
// totalSum-D has to be even to get 2 parts


// memoization 
import java.util.*;
public class Solution {
	public static int countWays(int index,int tar,int[] num,int[][] dp){
		if(index==0){
			if(tar==0 && num[0]==0) return 2;
			if(tar==0 || tar== num[0]) return 1;
			return 0;
		}
		if(dp[index][tar]!=-1) return dp[index][tar];
		int pick=0;
		if(tar>=num[index]) pick=countWays(index-1,tar-num[index],num,dp);
		int notPick=countWays(index-1,tar,num,dp);
	    int M = (int) 1000000007;
		return dp[index][tar]=(pick+notPick)%M;
	}
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int ts=0;
		for(int i=0;i<arr.length;i++) ts+=arr[i];
		if((ts-d)<0 || (ts-d)%2!=0) return 0;
		int tar=(ts-d)/2;
		int[][] dp=new int[arr.length][tar+1];
		for(int[] r:dp)
			Arrays.fill(r,-1);
		return countWays(arr.length-1,tar,arr,dp);
	}
}

// tabulation 
import java.util.*;
public class Solution {
	static final int M = (int) 1000000007;
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int ts=0;
		for(int i=0;i<arr.length;i++) ts+=arr[i];
		if((ts-d)<0 || (ts-d)%2!=0) return 0;
		int tar=(ts-d)/2;
		
		int[][] dp=new int[arr.length][tar+1];
  // fill the array with 0 as -1 will give a wrong answer 
		for(int[] r:dp)
			Arrays.fill(r,0);
		if(arr[0]==0) dp[0][0]=2;
		else dp[0][0]=1;
		
		if(arr[0]!=0 && arr[0]<=tar) dp[0][arr[0]] =1;

		for(int i=1;i<arr.length;i++){
			for(int t=0;t<=tar;t++){
		int pick=0;
		if(t>=arr[i]) pick=dp[i-1][t-arr[i]];
		int notPick=dp[i-1][t];
		dp[i][t]=(pick+notPick)%M;
			}
		}
		return dp[arr.length-1][tar];
	}
}

// tabulation with space optimization 
import java.util.*;
public class Solution {
	static final int M = (int) 1000000007;
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int ts=0;
		for(int i=0;i<arr.length;i++) ts+=arr[i];
		if((ts-d)<0 || (ts-d)%2!=0) return 0;
		int tar=(ts-d)/2;
		
		int[] dp=new int[tar+1];
  // fill the array with 0 as -1 will give a wrong answer 
		Arrays.fill(dp,0);
		if(arr[0]==0) dp[0]=2;
		else dp[0]=1;
		
		if(arr[0]!=0 && arr[0]<=tar) dp[arr[0]] =1;

		for(int i=1;i<arr.length;i++){
			int[] temp=new int[tar+1];
			temp[0]=1;
			for(int t=0;t<=tar;t++){
		int pick=0;
		if(t>=arr[i]) pick=dp[t-arr[i]];
		int notPick=dp[t];
		temp[t]=(pick+notPick)%M;
			}
			dp=temp;
		}
		return dp[tar];
	}
}
