//recursion 
class Solution {
    int maxPartition(int i,int[] arr, int k){
        int n=arr.length;
        if(i==n) return 0;
        int len=0;
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        int maxAns=0;
        for(int j=i;j<Math.min(n,j+k);j++){
            len++;
            maxi=Math.max(maxi,arr[j]);
            sum=(len*maxi)+maxPartition(j+1,arr,k);
            maxAns=Math.max(maxAns,sum);
            if(len>(k-1)) len=0;
        }
        return maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return maxPartition(0,arr,k);
    }
}

// memoization
class Solution {
    int maxPartition(int i,int[] arr, int k,int[] dp){
        int n=arr.length;
        if(i==n) return 0;
        
        if(dp[i]!=-1) return dp[i];
        
        int len=0;
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        int maxAns=0;
        for(int j=i;j<Math.min(n,j+k);j++){
            len++;
            maxi=Math.max(maxi,arr[j]);
            sum=(len*maxi)+maxPartition(j+1,arr,k,dp);
            maxAns=Math.max(maxAns,sum);
            if(len>(k-1)) len=0;
        }
        return dp[i]=maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return maxPartition(0,arr,k,dp);
    }
}

// tabulation
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
         int n=arr.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,0);
        dp[n]=0;
        
        for(int i=n-1;i>=0;i--){
            int len=0;
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        int maxAns=0;
        for(int j=i;j<Math.min(n,j+k);j++){
            len++;
            maxi=Math.max(maxi,arr[j]);
            sum=(len*maxi)+dp[j+1];
            maxAns=Math.max(maxAns,sum);
            if(len>(k-1)) len=0;
        }
       dp[i]=maxAns;
        }
        return dp[0];
    }
}
