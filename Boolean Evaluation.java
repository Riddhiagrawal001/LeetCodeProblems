// recursion 
public class Solution {
	static final int mod=1000000007;
	static long countWaysToTrue(int i , int j ,int isTrue, String exp){
		if(i>j) return 0; 
		if(i==j){
			if(isTrue ==1 ) return exp.charAt(i)=='T'? 1:0;
			else return exp.charAt(i)=='F'? 1:0;
		}
		long ways=0;
		for(int ind=i+1;ind<=j-1;ind+=2){
			long lT=countWaysToTrue(i,ind-1,1,exp);
			long lF=countWaysToTrue(i,ind-1,0,exp);
			long rT= countWaysToTrue(ind+1,j,1,exp);
			long rF=countWaysToTrue(ind+1,j,0,exp);
			if(exp.charAt(ind)=='&') {
				
				if(isTrue==1) ways=(ways+(rT*lT)%mod)%mod;
				else  ways=(ways+(lT*rF)%mod+(lF*rT)%mod+(lF*rF)%mod)%mod;
				
			}
			else  if(exp.charAt(ind)=='|')	{
				if(isTrue==1) ways=(ways+ (rT*lF)%mod+(lT*rF)%mod+(lT*rT)%mod)%mod;
				else  ways=(ways+(lF*rF)%mod)%mod;
				
			}
			else {
				if(isTrue==1) ways=(ways+(rF*lT)%mod+(lF*rT)%mod)%mod;
			    else ways=(ways+(rT*lT)%mod+(lF*rF)%mod)%mod;
				
			}	
		}
		return ways;
	}
    public static int evaluateExp(String exp) {
        // Write your code here.
		//long res=;
		int m =exp.length();
		return (int)countWaysToTrue(0,m-1,1,exp);
    }
}

// memoization 
import java.util.*;
public class Solution {
	static final int mod=1000000007;
	static long countWaysToTrue(int i , int j ,int isTrue, String exp,long[][][] dp){
		if(i>j) return 0; 
		if(i==j){
			if(isTrue ==1 ) return exp.charAt(i)=='T'? 1:0;
			else return exp.charAt(i)=='F'? 1:0;
		}
		if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];
		long ways=0;
		for(int ind=i+1;ind<=j-1;ind+=2){
			long lT=countWaysToTrue(i,ind-1,1,exp,dp);
			long lF=countWaysToTrue(i,ind-1,0,exp,dp);
			long rT= countWaysToTrue(ind+1,j,1,exp,dp);
			long rF=countWaysToTrue(ind+1,j,0,exp,dp);
			if(exp.charAt(ind)=='&') {
				
				if(isTrue==1) ways=(ways+(rT*lT)%mod)%mod;
				else  ways=(ways+(lT*rF)%mod+(lF*rT)%mod+(lF*rF)%mod)%mod;
				
			}
			else  if(exp.charAt(ind)=='|')	{
				if(isTrue==1) ways=(ways+ (rT*lF)%mod+(lT*rF)%mod+(lT*rT)%mod)%mod;
				else  ways=(ways+(lF*rF)%mod)%mod;
				
			}
			else {
				if(isTrue==1) ways=(ways+(rF*lT)%mod+(lF*rT)%mod)%mod;
			    else ways=(ways+(rT*lT)%mod+(lF*rF)%mod)%mod;
				
			}	
		}
		return dp[i][j][isTrue]=ways;
	}
    public static int evaluateExp(String exp) {
        // Write your code here.
		//long res=;
		int m =exp.length();
		long [][][] dp=new long[m][m][2];
		for(long[][]r : dp)
			for(long[] c: r)
				Arrays.fill(c,-1);
		return (int)countWaysToTrue(0,m-1,1,exp,dp);
    }
}

//tabulation
import java.util.*;
public class Solution {
	static final int mod=1000000007;
    public static int evaluateExp(String exp) {
        // Write your code here.
		//long res=;
		int m =exp.length();
		long [][][] dp=new long[m][m][2];
		for(long[][]r : dp)
			for(long[] c: r)
				Arrays.fill(c,0);
		
		for(int i=0;i<m;i++){
			if(exp.charAt(i)=='T') dp[i][i][1]=1;
			else if(exp.charAt(i)=='F') dp[i][i][0]=1;
		}
		
		for(int i=m-1;i>=0;i--){
			for(int j=0;j<m;j++){
				
					
		
		long ways=0;
		for(int ind=i+1;ind<=j-1;ind+=2){
			long lT=dp[i][ind-1][1];
			long lF=dp[i][ind-1][0];
			long rT= dp[ind+1][j][1];
			long rF=dp[ind+1][j][0];
			if(exp.charAt(ind)=='&') {
				dp[i][j][1]=(dp[i][j][1]+(rT*lT)%mod)%mod;
				dp[i][j][0]=(dp[i][j][0]+(lT*rF)%mod+(lF*rT)%mod+(lF*rF)%mod)%mod;
			}
			else  if(exp.charAt(ind)=='|')	{
				dp[i][j][1]=(dp[i][j][1]+ (rT*lF)%mod+(lT*rF)%mod+(lT*rT)%mod)%mod;
				dp[i][j][0]=(dp[i][j][0]+(lF*rF)%mod)%mod;
				
			}
			else {
				dp[i][j][1]=(dp[i][j][1]+(rF*lT)%mod+(lF*rT)%mod)%mod;
			    dp[i][j][0]=(dp[i][j][0]+(rT*lT)%mod+(lF*rF)%mod)%mod;
				
			}	
		}
			}
		}

		return (int)dp[0][m-1][1];
    }
}
