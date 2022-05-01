// recursion 
public class Solution {
	static int knapSack(int index,int maxWt,int[] profit,int[] weight){
		if(index==0){
			if(weight[0]<=maxWt) return profit[0]*(maxWt/weight[0]);
			else return 0;
		}
		int pick=-999999;
		if(weight[index]<=maxWt)
			pick=profit[index]+knapSack(index,maxWt-weight[index],profit,weight);
		int notpick=0+knapSack(index-1,maxWt,profit,weight);
		return Math.max(pick,notpick);
	}
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
		int res=knapSack(weight.length-1,w,profit,weight);
		return res;
    }
}

// memoization 
import java.util.*;
public class Solution {
	static int knapSack(int index,int maxWt,int[] profit,int[] weight,int[][] dp){
		if(index==0){
			if(weight[0]<=maxWt) return profit[0]*(maxWt/weight[0]);
			else return 0;
		}
		if(dp[index][maxWt]!=-1) return dp[index][maxWt];
		int pick=-999999;
		if(weight[index]<=maxWt)
			pick=profit[index]+knapSack(index,maxWt-weight[index],profit,weight,dp);
		int notpick=0+knapSack(index-1,maxWt,profit,weight,dp);
		return dp[index][maxWt]=Math.max(pick,notpick);
	}
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
		int[][] dp=new int[weight.length][w+1];
		for(int[] r:dp)
			Arrays.fill(r,-1);
		int res=knapSack(weight.length-1,w,profit,weight,dp);
		return res;
    }
}

//tabulation
import java.util.*;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
		int[][] dp=new int[weight.length][w+1];
		for(int[] r:dp)
			Arrays.fill(r,0);
		for(int wt=weight[0];wt<=w;wt++){
			dp[0][wt]=profit[0]*(wt/weight[0]);
		}
		for(int index=1;index<weight.length;index++){
		   for(int wt=0;wt<=w;wt++){
			   int pick=-99999;
			   if(weight[index]<=wt)
				   pick=profit[index]+dp[index][wt-weight[index]];
			   int notpick=0+dp[index-1][wt];
			   dp[index][wt]=Math.max(pick,notpick);
		   }
		}
		return dp[weight.length-1][w];
    }
}

//tabulation with space optimization
import java.util.*;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
		int[] dp=new int[w+1];
		Arrays.fill(dp,0);
		for(int wt=weight[0];wt<=w;wt++){
			dp[wt]=profit[0]*(wt/weight[0]);
		}
		for(int index=1;index<weight.length;index++){
			int[] curr=new int[w+1];
		   for(int wt=0;wt<=w;wt++){
			   int pick=-99999;
			   if(weight[index]<=wt)
				   pick=profit[index]+curr[wt-weight[index]];
			   int notpick=0+dp[wt];
			   curr[wt]=Math.max(pick,notpick);
		   }
			dp=curr;
		}
		return dp[w];
    }
}

//optimizing 2 arrys to  just 1 array
// in case of Knapsaxk 0-1 we were having a problem while running loop from 0 to wt 
// because in that for each iteration we want previous array back data( non updated data)
// hence we had to run a  loop from wt to 0
// in this case we can run a loop from 0 to wt beacuse we want current array back data ( updated data)
// hence thi doesn't cause problem from running loop from 0 to wt
import java.util.*;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
		int[] dp=new int[w+1];
		Arrays.fill(dp,0);
		for(int wt=weight[0];wt<=w;wt++){
			dp[wt]=profit[0]*(wt/weight[0]);
		}
		for(int index=1;index<weight.length;index++){
		   for(int wt=0;wt<=w;wt++){
			   int pick=-99999;
			   if(weight[index]<=wt)
				   pick=profit[index]+dp[wt-weight[index]];
			   int notpick=0+dp[wt];
			   dp[wt]=Math.max(pick,notpick);
		   }
			
		}
		return dp[w];
    }
}


