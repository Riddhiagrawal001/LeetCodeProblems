// the main idea is to find the max from the right to the current element and then max from the left of the current element
// then finding the minimum of the both max of right and left , then subtracting the current height with the min .

// one way to find the max of left and right is : for the current element (i) find the max from index 0 to i [left max]
// find the max from i to arr.length-1 [right max ]
// but for this solution the time complexity would be O(n^2) as we for every element we are iterating every element to find left max & right max

// in the other solution we find the prefixMax & SuffixMax
// the time complexity for this approach is O(n) => O(n)[to create prefixMax]+O(n)[to create suffixMax]+O(n)[to find the sum of the water retained]---> O(3.n)=O(n)
class Solution {
  // function to create prefix max : 
  // iterate over every element , then if current height is > than the previous height set max to current height otherwise let the height be max
  // iterate from 0 to arr.length-1
    private void createPrefixMax(int[] height,int[] prefixMax){
        int max=height[0];
        prefixMax[0]=max;
        for(int i=1;i<=height.length-1;i++){
         
            if(prefixMax[i-1]<height[i]){
                prefixMax[i]=height[i];
                max=height[i];
            }
            else 
                prefixMax[i]=max;
        }
    }  
 // function to create suffix max : 
  // iterate over every element , then if current height is > than the previous height set max to current height otherwise let the height be max
  // iterate from arr.length-1 to 0
    private void createSuffixMax(int[] height,int[] suffixMax){
        int max=height[height.length-1];
        suffixMax[height.length-1]=max;
        for(int i=height.length-2;i>=0 ;i--){
            if(suffixMax[i+1]<height[i]){
                suffixMax[i]=height[i];
                max=height[i];
            }
            else 
                suffixMax[i]=max;
        }
    }
  //function to find the water retained 
  // iterate over ever element , find the min of prefixMax & suffixMax for the current element 
  // subtract current height to the min , and then add it to sum
    public int calculateSum(int[] height,int[] suffix, int[] prefix){
        int sum=0;
        for(int i=0;i<height.length;i++){
            int min=Math.min(prefix[i],suffix[i]);
            sum=sum+(min-height[i]);
        }
        System.out.println(sum);
        return sum;
    }
    public int trap(int[] height) {
        int[] prefixMax=new int[height.length];
        int[] suffixMax=new int[height.length];
        createPrefixMax(height,prefixMax);
        createSuffixMax(height,suffixMax);
        int res=calculateSum(height,prefixMax,suffixMax);
        return res;
    }
}
