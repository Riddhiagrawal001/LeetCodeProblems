// the idea for this question is to find the lcs between the two strings 
//hence it would be the part that we dont have to change 
// for the remaining part in the string 1 will be the no of deletions 
// where as the remaining part other thna the common in string 2 would be the no of insertions 

// hence result would be insertions + deletions 
// where deletions = String 1 - Longest common Subsequence 
// insertions = String 2- Longest common Subsequence 


import java.util.*;
public class Solution {
	public static int longestCommonSub(String text1 , String text2){
		int len1=text1.length();
            int len2=text2.length();
        int[] dp=new int[len2+1];
     
            Arrays.fill(dp,0);
        for(int i=0;i<=len2;i++)
            dp[i]=0;
        for(int i=1;i<=len1;i++){
            int[] temp=new int[len2+1];
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                  temp[j]=1+dp[j-1];
                else {
                  temp[j]=Math.max(dp[j],temp[j-1]); 
                }
       
            }
            dp=temp;  
        }

        return dp[len2];
	}
    public static int canYouMake(String str, String ptr) {
        // Write your code here.
		int res=longestCommonSub(str,ptr);
		return (str.length()-res)+(ptr.length()-res);
    }

}
