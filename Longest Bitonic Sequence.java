// the idea is to first find the length od LIS from front 
// and then find the length of the LIS from the back 
// make another array which will have the length of the bitonic sequence till that particular index
// which will be calculated by (LIS from front till index i+ LIS from back till index i)-1
// and the max of Bitonic array will be the longest Bitonic Sequence 

import java.util.*;
public class Solution {
    public static int longestBitonicSequence(int[] arr, int n) {
        int m =arr.length;
		
		// lis for increasing from front 
        int[] dp1=new int[m];
        Arrays.fill(dp1,1);
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && 1+dp1[j]>dp1[i])
                    dp1[i]=1+dp1[j];                
            }
        }
		// lis for increasing from back 
        int[] dp2=new int[m];
        Arrays.fill(dp2,1);
        for(int i=m-1;i>=0;i--){
            for(int j=m-1;j>i;j--){
                if(arr[j]<arr[i] && 1+dp2[j]>dp2[i])
                    dp2[i]=1+dp2[j];                
            }
        }
          int[] bitonic=new int[m]; 
		int maxi=0;
		for(int i=0;i<m;i++){
			bitonic[i]=(dp1[i]+dp2[i])-1;
			maxi=Math.max(maxi,bitonic[i]);
		}
		return maxi;
    }
}
