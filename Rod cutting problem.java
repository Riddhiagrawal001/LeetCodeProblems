//recursion 
public class Solution {
	static int findMax(int index,int tar,int[] arr){
		if(index==0){
			if(tar%(index+1)==0) return arr[0]*(tar/(index+1));
			return 0;
		}
		
		int pick=-99999;
		if(tar>=index+1)
			pick=arr[index]+findMax(index,tar-(index+1),arr);
		int notpick=0+findMax(index-1,tar,arr);
	
		return Math.max(pick,notpick);
			
	}
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int res=findMax(price.length-1,n,price);
		return res;
	}
}

//memoization 
import java.util.*;
public class Solution {
	static int findMax(int index,int tar,int[] arr,int[][] dp){
		if(index==0){
			if(tar%(index+1)==0) return arr[0]*(tar/(index+1));
			return 0;
		}
		if(dp[index][tar]!=-1) return dp[index][tar];
		int pick=-99999;
		if(tar>=index+1)
			pick=arr[index]+findMax(index,tar-(index+1),arr,dp);
		int notpick=0+findMax(index-1,tar,arr,dp);
	
		return dp[index][tar]=Math.max(pick,notpick);
			
	}
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[][] dp=new int[price.length][n+1];
		for(int[] r:dp)
			Arrays.fill(r,-1);
		int res=findMax(price.length-1,n,price,dp);
		return res;
	}
}

//tabulation 
import java.util.*;
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[][] dp=new int[price.length][n+1];
		for(int[] r:dp)
			Arrays.fill(r,-1);
		
		for(int i=0;i<=n;i++){
			dp[0][i]=price[0]*(i);
		}
		for(int i=1;i<price.length;i++){
			for(int tar=0;tar<=n;tar++){
					int pick=-99999;
		if(tar>=i+1)
			pick=price[i]+dp[i][tar-(i+1)];
		int notpick=0+dp[i-1][tar];
	
		dp[i][tar]=Math.max(pick,notpick);
			}
		}
		return dp[price.length-1][n];
	}
}

//tabulation with space optimization 
import java.util.*;
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[] dp=new int[n+1];
		Arrays.fill(dp,0);
		
		for(int i=0;i<=n;i++){
			dp[i]=price[0]*(i);
		}
		for(int i=1;i<price.length;i++){
			int[] curr=new int[n+1];
			for(int tar=0;tar<=n;tar++){
					int pick=-99999;
		if(tar>=i+1)
			pick=price[i]+curr[tar-(i+1)];
		int notpick=0+dp[tar];
	
		curr[tar]=Math.max(pick,notpick);
			}
			dp=curr;
		}
		return dp[n];
	}
}

// 2 array to 1 array 
import java.util.*;
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[] dp=new int[n+1];
		Arrays.fill(dp,0);
		
		for(int i=0;i<=n;i++){
			dp[i]=price[0]*(i);
		}
		for(int i=1;i<price.length;i++){
			for(int tar=0;tar<=n;tar++){
					int pick=-99999;
		if(tar>=i+1)
			pick=price[i]+dp[tar-(i+1)];
		int notpick=0+dp[tar];
	
		dp[tar]=Math.max(pick,notpick);
			}
			
		}
		return dp[n];
	}
}
