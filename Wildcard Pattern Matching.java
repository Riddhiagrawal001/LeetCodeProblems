// recursion 
public class Solution {
	public static boolean stringMatch(int i,int j,String pattern,String text){
	
		if(j<0 && i<0) return true;
		if(i<0 && j>=0) return false;
		if(j<0 && i>=0 ){
			for(int x=i;x>=0;x--)
				if(pattern.charAt(x)!='*') 
					return false;
			return true;
		}
	   
		// matching condition 
		boolean match=false;
		if(pattern.charAt(i)==text.charAt(j) || pattern.charAt(i)=='?')
		return stringMatch(i-1,j-1,pattern,text);
		
		// if the current chracter in the string is a star
		if(pattern.charAt(i)=='*')
		return stringMatch(i-1,j,pattern,text) || stringMatch(i,j-1,pattern,text);
		
		// if not matching
		return false;
	
	}
	public static boolean wildcardMatching(String pattern, String text) {
		// Write your code here.
	    int m=pattern.length();
	    int n=text.length();
		boolean res=stringMatch(m-1,n-1,pattern,text);
		return res;
	}
}

//memoization 
import java.util.*;
public class Solution {
	public static int stringMatch(int i,int j,String pattern,String text,int[][] dp){
	
		if(j<0 && i<0) return 1;
		if(i<0 && j>=0) return 0;
		if(j<0 && i>=0 ){
			for(int x=i;x>=0;x--)
				if(pattern.charAt(x)!='*') 
					return 0;
			return 1;
		}
	   
		if(dp[i][j]!=-1) return dp[i][j];
		// matching condition 
		boolean match=false;
		if(pattern.charAt(i)==text.charAt(j) || pattern.charAt(i)=='?')
			return stringMatch(i-1,j-1,pattern,text,dp);;
		
		
		
		// if the current chracter in the string is a star
		if(pattern.charAt(i)=='*')
			return (stringMatch(i-1,j,pattern,text,dp)==1 || stringMatch(i,j-1,pattern,text,dp)==1 )? 1 :0;
		
		// if not matching
		return  0;
	
	}
	public static boolean wildcardMatching(String pattern, String text) {
		// Write your code here.
	    int m=pattern.length();
	    int n=text.length();
		int[][] dp=new int[m+1][n+1];
		for(int[] r:dp)
			Arrays.fill(r,-1);
		int res=stringMatch(m-1,n-1,pattern,text,dp);
		return res==1?true:false;
	}
}

// tabulation 
import java.util.*;
public class Solution {
	public static boolean wildcardMatching(String pattern, String text) {
		// Write your code here.
	    int m=pattern.length();
	    int n=text.length();
		boolean [][] dp=new boolean[m+1][n+1];
		dp[0][0]=true;
		for(int j=1;j<=n;j++)
			dp[0][j]=false;
		for(int i=1;i<=m;i++){
		boolean flag=true;
			for(int x=1;x<=i;x++)
				if(pattern.charAt(x-1)!='*') {
					flag=false;
					break;
				}
					
		dp[i][0]=flag;
		}
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
		if(pattern.charAt(i-1)==text.charAt(j-1) || pattern.charAt(i-1)=='?')
		dp[i][j]=dp[i-1][j-1];
		
		else {
			if(pattern.charAt(i-1)=='*')
			dp[i][j]=dp[i-1][j] || dp[i][j-1];
				
			else dp[i][j]=false;
		}
			}
		}
		return dp[m][n];
	}
}

//tabulation with space optimization 
public class Solution {
	public static boolean wildcardMatching(String pattern, String text) {
		// Write your code here.
	    int m=pattern.length();
	    int n=text.length();
		boolean [] dp=new boolean[n+1];
		dp[0]=true;
		for(int j=1;j<=n;j++)
			dp[j]=false;
		for(int i=1;i<=m;i++){
			boolean[] temp=new boolean[n+1];
			boolean flag=true;
			for(int x=1;x<=i;x++)
				if(pattern.charAt(x-1)!='*') {
					flag=false;
					break;
				}	
		temp[0]=flag;
			
			
			for(int j=1;j<=n;j++){
		if(pattern.charAt(i-1)==text.charAt(j-1) || pattern.charAt(i-1)=='?')
		temp[j]=dp[j-1];
		
		else {
			if(pattern.charAt(i-1)=='*')
			temp[j]=dp[j] || temp[j-1];
				
			else temp[j]=false;
		}
			}
			dp=temp;
		}
		return dp[n];
	}
}
