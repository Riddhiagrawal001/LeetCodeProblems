// recursion 
class Solution {
    public static int lenSub(int len1,int len2,String text1,String text2){
        if(len1<0 || len2<0 ) return 0;
        
        if(text1.charAt(len1)==text2.charAt(len2))
            return 1+lenSub(len1-1,len2-1,text1,text2);
        return Math.max(lenSub(len1-1,len2,text1,text2),lenSub(len1,len2-1,text1,text2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length()-1;
            int len2=text2.length()-1;
         int res=lenSub(len1,len2,text1,text2);
        return res;
    }
}

// memoization 
class Solution {
    public static int lenSub(int len1,int len2,String text1,String text2,int[][] dp){
        if(len1<0 || len2<0 ) return 0;
        
        if(dp[len1][len2]!=-1) return dp[len1][len2];
        if(text1.charAt(len1)==text2.charAt(len2))
            return dp[len1][len2]=1+lenSub(len1-1,len2-1,text1,text2,dp);
        return  dp[len1][len2]=Math.max(lenSub(len1-1,len2,text1,text2,dp),lenSub(len1,len2-1,text1,text2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
            int len2=text2.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int[] r : dp)
            Arrays.fill(r,-1);
         int res=lenSub(len1-1,len2-1,text1,text2,dp);
        return res;
    }
}

//tabulation
class Solution {
   
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
            int len2=text2.length();
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
                if(text1.charAt(i-1)==text2.charAt(j-1))
                  dp[i][j]=1+dp[i-1][j-1];
              // if the charcter does not matches
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]); 
                }
       
            }
            
        }

        return dp[len1][len2];
    }
}


// tabulation with space optimization 
class Solution {
   
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
            int len2=text2.length();
        int[] dp=new int[len2+1];
     
            Arrays.fill(dp,0);
        for(int i=0;i<=len2;i++)
            dp[i]=0;
        // for(int j=0;j<=len1;j++)
        //     dp[j][0]=0;
        
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
}


// to print the longest common subsequece 
import java.util.*;
class HelloWorld {
    
    public static void main(String[] args) {
        String s1="abcde";
        String s2="bdgek";
        int len1=s1.length();
            int len2=s2.length();
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
                if(s1.charAt(i-1)==s2.charAt(j-1))
                  dp[i][j]=1+dp[i-1][j-1];
              // if the charcter does not matches
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]); 
                }

            }

        }

        int n =dp[len1][len2]; 
        Character[] ans=new Character[n];
        Arrays.fill(ans,'-');
        int index=n-1;
        int i=len1;int j=len2;
        while(i>0 && j >0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans[index]=s1.charAt(i-1);
                index--;
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]) i--;
            else j--;
        }
        StringBuilder s=new StringBuilder();
        for(Character c : ans)
          s.append(c);
        System.out.println(s);
    }
}
