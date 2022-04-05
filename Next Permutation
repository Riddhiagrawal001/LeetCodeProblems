class Solution {
     public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void reverse (int[] arr, int i,int j){
        while(i<j){
            swap(arr,i,j);
        i++;
        j--;
        }
    }

    public void nextPermutation(int[] nums) {
       
       //short code
//         int i = nums.length-2;
//         while(i>=0 && nums[i]>=nums[i+1])
//             i--;
        
        
//         if(i>=0){  
//             int j = nums.length-1;
//             while(nums[i]>=nums[j])
//             j--;
//             swap(nums,i,j);
//         }
    
//         reverse(nums,i+1,nums.length-1);
    
    //long code
        int index=0;
        
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                index=i;
                break;
            }
        }
        if(index==0 || nums.length==1){
            Arrays.sort(nums);
        }
        else if(nums.length==2){
            swap(nums,0,nums.length-1);
        }
        else {
             int justMin=index;
        for(int j=index;j<nums.length;j++){
            if(nums[j]>nums[index-1] && nums[j]<=nums[justMin]){
                justMin=j;
            }    
        }
           swap(nums,index-1,justMin);
            reverse(nums,index,nums.length-1);    
        }
      
    }
}
