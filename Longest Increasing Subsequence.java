// recursion 
class Solution {
    static int longestIncSub(int index,int prev_index,int[] nums){
        if(index==nums.length) return 0;

        int pick=0;
        if(prev_index==-1 || nums[index]>nums[prev_index])
            pick= 1+longestIncSub(index+1,index,nums);
        int not_pick=0+longestIncSub(index+1,prev_index,nums);
        return Math.max(pick,not_pick);
    }
    public int lengthOfLIS(int[] nums) {
        int m =nums.length;
      return longestIncSub(0, -1,nums);  
    }
}

// memoization 
class Solution {
    static int longestIncSub(int index,int prev_index,int[] nums,int[][] dp){
        if(index==nums.length) return 0;
        
        if(dp[index][prev_index+1]!=-1 ) return dp[index][prev_index+1];
        int pick=0;
        if(prev_index==-1 || nums[index]>nums[prev_index])
            pick= 1+longestIncSub(index+1,index,nums,dp);
        int not_pick=0+longestIncSub(index+1,prev_index,nums,dp);
        return dp[index][prev_index+1]=Math.max(pick,not_pick);
    }
    public int lengthOfLIS(int[] nums) {
        int m =nums.length;
        int[][] dp=new int[m][m+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
      return longestIncSub(0, -1,nums,dp);  
    }
}

//tabulation 
 public int lengthOfLIS(int[] nums) {
        int m =nums.length;
        int[][] dp=new int[m+1][m+1];
        for(int[] r:dp)
            Arrays.fill(r,0);
        
        for(int i=m-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int pick=0;
        if(j==-1 || nums[i]>nums[j])
            pick= 1+dp[i+1][i+1];
        int not_pick=0+dp[i+1][j+1];
       dp[i][j+1]=Math.max(pick,not_pick);
            }
        }
        
      return dp[0][0];  
    }
}

//tabulation with space optimizaton  tc:O(n^2) sc:O(n)x2

  public int lengthOfLIS(int[] nums) {
        int m =nums.length;
        int[] dp=new int[m+1];

            Arrays.fill(dp,0);
        
        for(int i=m-1;i>=0;i--){
             int[] curr=new int[m+1];
            for(int j=i-1;j>=-1;j--){
                int pick=0;
        if(j==-1 || nums[i]>nums[j])
            pick= 1+dp[i+1];
        int not_pick=0+dp[j+1];
       curr[j+1]=Math.max(pick,not_pick);
            }
            dp=curr;
        }
        
      return dp[0];  
    }

// another method tc:O(n^2)  sc:O(n)
 public int lengthOfLIS(int[] nums) {
        int m =nums.length;
        int[] dp=new int[m];

            Arrays.fill(dp,1);
        int maxi=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    dp[i]=Math.max(1+dp[j],dp[i]);
                
            }
            maxi=Math.max(maxi,dp[i]);
        }
        
        
      return maxi;  
    }


// printing the lis
// print the lis in reverse order or reverse the array 
class Solution {
    public int lengthOfLIS(int[] nums) {
        int m =nums.length;
        int[] dp=new int[m];
        int[] hash=new int[m];
        int last_index=0;
            Arrays.fill(dp,1);
        int maxi=1;
        for(int i=0;i<m;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
                    
                
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                last_index=i;
            }
        }
        int[] lis=new int[maxi];
        lis[0]=nums[last_index];
        int index=1;
        while(hash[last_index]!=last_index){
            last_index=hash[last_index];
            lis[index++]=nums[last_index];
        }
        
     for(int i=lis.length-1;i>=0;i--)
         System.out.println(lis[i]);
           
      return maxi;  
    }
}
