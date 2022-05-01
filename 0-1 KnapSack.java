// intuition is to maximize the value and take weights that equal to or lesser than the given Weight

// recursion ( TC: O(2^n) SC : O(n) ) 
public class Solution{
	static int knapSack(int index,int maxw,int[] weight,int[] value){
		if(index==0){
			if(weight[0]<=maxw) return value[0];
			else return 0;
		}
		int pick=-99999;
		
		if(weight[index]<=maxw)
			pick=value[index]+knapSack(index-1,maxw-weight[index],weight,value);
		int notPick=0+knapSack(index-1,maxw,weight,value);
		return Math.max(pick,notPick);
	}
	
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
       int res=knapSack(weight.length-1, maxWeight,weight,value);
		return res;
    }
}

//memoization
import java.util.*;
public class Solution{
	static int knapSack(int index,int maxw,int[] weight,int[] value,int[][] dp){
		if(index==0){
			if(weight[0]<=maxw) return value[0];
			else return 0;
		}
		if(dp[index][maxw]!=-1) return dp[index][maxw];
		int pick=-99999;
		
		if(weight[index]<=maxw)
			pick=value[index]+knapSack(index-1,maxw-weight[index],weight,value,dp);
		int notPick=0+knapSack(index-1,maxw,weight,value,dp);
		return dp[index][maxw]=Math.max(pick,notPick);
	}
	
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
		int[][] dp=new int[weight.length][maxWeight+1];
		for(int[] r:dp)
			Arrays.fill(r,-1);
       int res=knapSack(weight.length-1, maxWeight,weight,value,dp);
		return res;
    }
}

//tabulation 
static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
		int[][] dp=new int[weight.length][maxWeight+1];
		for(int[] r:dp)
			Arrays.fill(r,0);
		for(int i=weight[0];i<=maxWeight;i++)
			dp[0][i]=value[0];
		for(int index=1;index<weight.length;index++){
			for(int wt=0;wt<=maxWeight;wt++){
				int pick=-99999;	
		if(weight[index]<=wt)
			pick=value[index]+dp[index-1][wt-weight[index]];
		int notPick=0+dp[index-1][wt];
		 dp[index][wt]=Math.max(pick,notPick);
			}
		}
		return dp[weight.length-1][maxWeight];
    }

// tabulation with space optimization 
import java.util.*;
public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
		int[] dp=new int[maxWeight+1];
		Arrays.fill(dp,0);
		
		for(int i=weight[0];i<=maxWeight;i++)
			dp[i]=value[0];
		
		for(int index=1;index<weight.length;index++){
			int[] temp=new int[maxWeight+1];
			for(int wt=0;wt<=maxWeight;wt++){
				int pick=-99999;	
		if(weight[index]<=wt)
			pick=value[index]+dp[wt-weight[index]];
		int notPick=0+dp[wt];
		 temp[wt]=Math.max(pick,notPick);
			}
			dp=temp;
		}
		
		return dp[maxWeight];
    }
}

// further space optimization with only using one dp array 
// as for the current weight (w) we only require the [0...w-1] columns
// and if we start filling from right to left we would still have the previous values
// and if case we start filling from left to right the previous value nedded for computation of the current that will be already be replaced by the updated value 
// which would give a wrong value for the current index
static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
		int[] dp=new int[maxWeight+1];
		Arrays.fill(dp,0);
		
		for(int i=weight[0];i<=maxWeight;i++)
			dp[i]=value[0];
		
		for(int index=1;index<weight.length;index++){
			
			for(int wt=maxWeight;wt>=0;wt--){
				int pick=-99999;	
		if(weight[index]<=wt)
			pick=value[index]+dp[wt-weight[index]];
		int notPick=0+dp[wt];
		 dp[wt]=Math.max(pick,notPick);
			}
		}
		return dp[maxWeight];
    }

