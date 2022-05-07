// same as printing LCS with some slight changes


class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        // LCS
         int len1=str1.length();
            int len2=str2.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int[] r : dp)
            Arrays.fill(r,0);
        for(int i=0;i<=len2;i++)
            dp[0][i]=0;
        for(int j=0;j<=len1;j++)
            dp[j][0]=0;

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
              // if character matches
                if(str1.charAt(i-1)==str2.charAt(j-1))
                  dp[i][j]=1+dp[i-1][j-1];
              // if the charcter does not matches
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]); 
                }

            }

        }
        
        int n =dp[len1][len2]; 
        StringBuilder s=new StringBuilder();
        int i=len1;int j=len2;
        while(i>0 && j >0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                s.append(str1.charAt(i-1));
               
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]) {
                s.append(str1.charAt(i-1));
                i--;
               
            }
            else {
               s.append(str2.charAt(j-1));
                j--;
                
            };
        }
        while(i>0) {
           s.append(str1.charAt(i-1));
            i--;
         
        }
         while(j>0) {
            s.append(str2.charAt(j-1));
            j--;
             
        }
          s.reverse();
        return s.toString();
        
    }
}
