// as the constraint is given that we have to the operation with no extra space 
// hence we have to change the original array itself


// the solution set will contain from the range [1 ,........., length of array+1]
// eg: [1,5,9,0]  ------> 2 ( range : [1.....4+1=5])
// [11,50,1000] --------> 1 ( range :[1.....3+1=4])
class Solution {
    public int firstMissingPositive(int[] nums) {
      // step 1: First convert all the negative values to 0 as we have to find the value greater than or equal to 1
        for(int i=0;i<nums.length;i++)
            if(nums[i]<0)
                nums[i]=0;
        
        // step 2 : loop through the array and find the absolute value of the current position value 
      // if the value lies in the range (1....length(arr)) { if arr[i]>0 (means not negative already) 
      // then convert the value at arr[arr[i-1]] to negative value
      // and if the value is already 0 then convert the value to negative of nums.length+1 [ as this value will always be out of bound and will never be on the solutin set]   
 //   }  
         for(int j=0;j<nums.length;j++){
               int val=Math.abs(nums[j]);
             if(val>=1 && val<=nums.length){
                 if(nums[val-1]>0)
                  nums[val-1]*=-1;
                 else if (nums[val-1]==0)
                     nums[val-1]=-1*(nums.length+1);
             }
         }
         // after converting loop through the range of the solution set 
      // if the value at arr[i-1] <0 that means the value exists somewhere 
      // if the value at arr[i-1] >0 means that the value doesn't exist anywhere hence the value has not been changed to negative value
        for(int k=1;k<=nums.length;k++){
            if(nums[k-1]>=0)
                return k;
        }
        // suppose if all the value exist then the answer would be the upper limit of the solution set +1
        return nums.length+1;
    }
}
