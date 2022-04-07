class Solution {
    public int BinarySearch(int[] arr,int low,int high,int target){
      // if the target value is greater than the whole array
        if(target > arr[arr.length-1]) 
            return arr.length;
      
     // if the target value is smaller than the whole array
        if(target<arr[0])
            return 0;
      //normal binary search
        while(high>=low){
            int mid = low+(high-low)/2;
            if(arr[mid]==target )
                 return mid;
          
          // case when the target value is not present 
          // [1,3,4] and the target is 2 hence the mid value is now at 3
          // hence if target<arr[mid] (2<3) and  target>arr[mid-1] (2>1) and arr[mid]!=target (2!=3)
            if(arr[mid]>target && arr[mid-1]<target && arr[mid]!=target)
            return mid;
            
            else if(arr[mid]>target)
                return BinarySearch(arr,low,mid-1,target);
            else 
                return BinarySearch(arr,mid+1,high,target);
        }
        return -1;
    }
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0 )
            return 0 ;
        int getIndex=BinarySearch(nums,0,nums.length-1,target);
        return getIndex;
    }
}
