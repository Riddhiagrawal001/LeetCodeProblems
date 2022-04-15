// through memoization  tc=O(2^n) sc=O(n)
import java.util.*;
class HelloWorld {
    public static int func(int n ,int[] dp,int[] arr){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int right=0;
        int left=func(n-1,dp,arr)+Math.abs(arr[n]-arr[n-1]);
        if(n>1){
             right=func(n-2,dp,arr)+Math.abs(arr[n]-arr[n-2]);
        }
    return  dp[n]=Math.min(left,right);
    }
    public static void main(String[] args) {
        int n=6 ;
        int arr[]={30,10,60,10,60,50};
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        int result=func(n-1,dp,arr);
        System.out.println(result);
    }
}

// tabulation method Tc: O(n) sc: O(n)+O(n) as extra space is needed for storing the dp array
public static void main(String[] args) {
        int n=6 ;
        int arr[]={30,10,60,10,60,50}; 
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        dp[0]=0;
        for(int i=1;i<=n-1;i++){
            int right=0;
           int left=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
           if(i>1)
           right=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
           dp[i]=Math.min(left,right);
        }
         
        // int result=func(n-1,dp,arr);
        System.out.println(dp[n-1]);
    }

// tabulation method with space optimization tc=O(n) sc=O(1) as no extra space is required to store the dp array
public static void main(String[] args) {
        int n=6 ;
        int arr[]={30,10,60,10,60,50}; 
        int prev=0;
        int prev2=0;
        for(int i=1;i<=n-1;i++){
            int right=0;
           int left=prev+Math.abs(arr[i]-arr[i-1]);
           if(i>1)
           right=prev2+Math.abs(arr[i]-arr[i-2]);
          int curr=Math.min(left,right);
           prev2=prev;
           prev=curr;
        }
        System.out.println(prev);
    }
