// idea is same as longest common substring 
// but only have a slightest change in case of a not match condition 
// in case the current characters doesn't match then instead of checking if any previous subsequences match 
// just replace it with 0 , because if in middle something doesn't matches up then it will no longer be a substring 

// where as in case if the character matches up 
// check if the previous characters also matched or not , it it matches then add 1 to the previous no of 
// consequtive characters matching 

import java.util.*;
public class Solution { 
	public static int lcs(String str1, String str2) {
		// Write your code here.
		int len1=str1.length();
            int len2=str2.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int[] r : dp)
            Arrays.fill(r,0);
        for(int i=0;i<=len2;i++)
            dp[0][i]=0;
        for(int j=0;j<=len1;j++)
            dp[j][0]=0;
        int maxii=0;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
              // if character matches
                if(str1.charAt(i-1)==str2.charAt(j-1)){
					 dp[i][j]=1+dp[i-1][j-1];
					maxii=Math.max(maxii,dp[i][j]);
				}
                 
              // if the charcter does not matches
                else {
                    dp[i][j]=0; 
                }
            } 
        }
		
		return maxii;
	}
}
