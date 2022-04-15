// solving using dp

//Approach for recurssion but in this the time will exceed
//     public int countApproach(int sum ,int n){
    
//         if(sum==n)
//             return 1;
//         else if(sum>n)
//             return 0;
           
//        // else return 0;
        
//         sum=sum+1;
//         int step1=countApproach(sum,n);
//         sum=sum-1;
//         sum=sum+2;
//         int step2=countApproach(sum,n);
//         return step1+step2;
//     }

// solution with dp for lesser time complexity
class Solution {
    public int climbStairs(int n) {
        int sum=0;
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);    
       dp[n]=1;
        System.out.println(n);
        for(int i=n-1;i>=0;i--){
            if(i+2>n){
                dp[i]=dp[i+1]+0;
            }
            else 
                dp[i]=dp[i+1]+dp[i+2];  
        }
       return dp[sum];
    }
}
