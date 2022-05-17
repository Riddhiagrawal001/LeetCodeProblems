// recursion 
class Solution {
   static boolean isPallindrome(int i ,int j, String str){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
       return true;
    }
    static int minPartition(int i,String s){ 
        if(i==s.length()) return 0;
        
        int mini=Integer.MAX_VALUE;
          int cost=0;
        for(int j=i;j<s.length();j++){
            if(isPallindrome(i,j,s)){
                 cost=1+minPartition(j+1,s);
            mini=Math.min(mini,cost);
            }
        }
        return mini;
    }
    public int minCut(String s) {
        return minPartition(0,s)-1;
        
    }
}

//memoization 
class Solution {
   static boolean isPallindrome(int i ,int j, String str){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
       return true;
    }
    static int minPartition(int i,String s,int[] dp){ 
        if(i==s.length()) return 0;
        
        if(dp[i]!=-1) return dp[i];
        int mini=Integer.MAX_VALUE;
          int cost=0;
        for(int j=i;j<s.length();j++){
            if(isPallindrome(i,j,s)){
                 cost=1+minPartition(j+1,s,dp);
            mini=Math.min(mini,cost);
            }
        }
        return dp[i]=mini;
    }
    public int minCut(String s) {
        int m=s.length();
        int[] dp=new int[m];
        Arrays.fill(dp,-1);
        return minPartition(0,s,dp)-1;
        
    }
}

//tabulation 
class Solution {
   static boolean isPallindrome(int i ,int j, String str){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
       return true;
    }
    public int minCut(String s) {
        int m=s.length();
        int[] dp=new int[m+1];
        Arrays.fill(dp,0);
        dp[m]=0;
        for(int i=m-1;i>=0;i--){
            int mini=Integer.MAX_VALUE;
          int cost=0;
        for(int j=i;j<m;j++){
            if(isPallindrome(i,j,s)){
                 cost=1+dp[j+1];
            mini=Math.min(mini,cost);
            }
        }
        dp[i]=mini;
        }
        
        return dp[0]-1;
        
    }
}
