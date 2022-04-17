class Solution {
    public int rob1(int[] nums) {
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<=nums.length-1;i++){
               int pick=0;
            pick=nums[i]+prev2;
            int nonpick=0+prev;
            int curr =Math.max(pick,nonpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int[] temp1=new  int[nums.length];
          int[] temp2=new  int[nums.length];
        if(nums.length==0) return 0; 
        else if(nums.length==1) return nums[0]; 
        else {
         temp1=Arrays.copyOfRange(nums, 0, nums.length-1);
            temp2=Arrays.copyOfRange(nums, 1, nums.length);
        int ans1=rob1(temp1);
         int ans2=rob1(temp2);

        System.out.println(ans1+" "+ans2);
        return Math.max(ans1,ans2);
        }
       
    }
}
