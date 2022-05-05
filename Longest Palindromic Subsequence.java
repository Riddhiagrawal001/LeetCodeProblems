class Solution {
    public static int longestCommonSub(String text1,String text2){
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
    
    public int longestPalindromeSubseq(String s) {
        String str1=s;
        StringBuilder str2=new StringBuilder();
        str2.append(s);
        str2.reverse();
       int res=longestCommonSub(str1,str2.toString());
        return res;
    }
}
