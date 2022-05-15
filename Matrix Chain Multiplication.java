// recursion 
public class Solution {
	static int minOperations(int i , int j , int[] arr){
		if(i==j) return 0;
		
		int mini=9999999;
		for(int k=i;k<j;k++){
			int steps= arr[i-1]*arr[k]*arr[j] + minOperations(i,k,arr)+minOperations(k+1,j,arr);
			if(steps<mini) mini=steps;
		} 
		return mini; 
	}
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here 
		return minOperations(1,N-1,arr);
	}
}

// memoization
import java.util.*;
public class Solution {
	static int minOperations(int i , int j , int[] arr,int[][] dp){
		if(i==j) return 0;
		if(dp[i][j]!=-1) return dp[i][j];
		int mini=Integer.MAX_VALUE;
		for(int k=i;k<j;k++){
			int steps= arr[i-1]*arr[k]*arr[j] + minOperations(i,k,arr,dp)+minOperations(k+1,j,arr,dp);
			if(steps<mini) mini=steps;
		} 
		return dp[i][j]=mini; 
	}  
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here 
		int[][] dp=new int[N][N];
		for(int[] r:dp)
			Arrays.fill(r,-1);
		return minOperations(1,N-1,arr,dp);
	}
}


//tabulation
import java.util.*;
public class Solution { 
	public static int matrixMultiplication(int[] arr , int N) {
		// Write your code here 
		int[][] dp=new int[N][N];
		for(int[] r:dp)
			Arrays.fill(r,0);
		for(int i=N-1;i>=1  ;i--){
			for(int j=i+1;j<N;j++){
				int mini=Integer.MAX_VALUE;
		for(int k=i;k<j;k++){
			int steps= arr[i-1]*arr[k]*arr[j] + dp[i][k]+dp[k+1][j];
			if(steps<mini) mini=steps;
		} 
		 dp[i][j]=mini; 
			}
		}
		return dp[1][N-1];
	}
}

