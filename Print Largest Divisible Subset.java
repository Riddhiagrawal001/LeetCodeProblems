class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        Arrays.sort(nums);
     int m =nums.length;
        int[] dp=new int[m];
        int[] hash=new int[m];
        int last_index=0;
            Arrays.fill(dp,1);
        int maxi=1;
        for(int i=0;i<m;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
                    
                
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                last_index=i;
            }
        }
        System.out.println(last_index);
        int[] lis=new int[maxi];
        lis[0]=nums[last_index];
        int index=1;
        while(hash[last_index]!=last_index){
            last_index=hash[last_index];
            lis[index++]=nums[last_index];
        }
        
     for(int i=lis.length-1;i>=0;i--)
        res.add(lis[i]);
           
      return res;  
        
    }
}
