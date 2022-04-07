class Solution {
    public int firstOcc(int[] arr,int low,int high,int target){
        if(high>=low){
            int mid=low+(high-low)/2;
            if((mid==0 || target>arr[mid-1]) && arr[mid]==target)
                return mid;
            else if(target>arr[mid])
               return firstOcc(arr,mid+1,high,target);
            else 
                return firstOcc(arr,low,mid-1,target);
        }
        return -1;
    }
    public int lastOcc(int [] arr,int low,int high,int target){
         if(high>=low){
            int mid=low+(high-low)/2;
            if((mid==arr.length-1 || target<arr[mid+1]) && arr[mid]==target)
                return mid;
            else if(target<arr[mid])
               return lastOcc(arr,low,mid-1,target);
            else 
               return lastOcc(arr,mid+1,high,target);
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int error[]={-1,-1};
        if (nums.length==0)
            return error;
        System.out.println(firstOcc(nums,0,nums.length-1,target));
         System.out.println(lastOcc(nums,0,nums.length-1,target));
        error[0]=firstOcc(nums,0,nums.length-1,target);
        error[1]=lastOcc(nums,0,nums.length-1,target);
        return error;
    }
}
