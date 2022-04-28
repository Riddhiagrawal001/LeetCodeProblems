// recursion
class HelloWorld {
    static boolean subsetK(int index,int[] arr,int target){
        if(target==0) return true;
        if(index==0) return (arr[0]==target);
        
        boolean pick=false;
        if(target>=arr[index])
        pick=subsetK(index-1,arr,target-arr[index]);
        boolean notpick=subsetK(index-1,arr,target);
        
        return pick||notpick;
    }
    public static void main(String[] args) {
        int[] arr={1,1,1};
        int k=2;
        boolean res=subsetK(arr.length-1,arr,k);
        System.out.println(res);
        
    }
}

// memoization 
import java.util.*;
class HelloWorld {
    static boolean subsetK(int index,int[] arr,int target,int[][] dp){
        if(target==0) return true;
        if(index==0) return (arr[0]==target);
        if(dp[index][target]!=0)  return true;
        boolean pick=false;
        if(target>=arr[index])
        pick=subsetK(index-1,arr,target-arr[index],dp);
        boolean notpick=subsetK(index-1,arr,target,dp);
        
        boolean bol=pick||notpick;
        if(bol) dp[index][target]=1;
        else dp[index][target]=0;
        return bol ;
    } 
    public static void main(String[] args) {
        int[] arr={2,5,1,6,7};
        int k=4;
        int[][] dp=new int[arr.length][k+1]; 
        for(int[] r:dp)
        Arrays.fill(r,0);
        boolean res=subsetK(arr.length-1,arr,k,dp);
        System.out.println(res);
        
    }
}

// tabulation
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int[] arr={4,3,2,1};
        int k=5;
        boolean[][] dp=new  boolean[arr.length][k+1]; 
        for(boolean[] r:dp)
        Arrays.fill(r,false);
        
        for(int i=0;i<arr.length;i++)
          dp[i][0]=true;
        dp[0][arr[0]]=true;
        for(int i=1;i<arr.length;i++){
            for(int tar=1;tar<=k;tar++){
        boolean pick=false;
        if(tar>=arr[i])
        pick=dp[i-1][tar-arr[i]];
        boolean notpick=dp[i-1][tar];
        dp[i][tar]=pick||notpick;
            }
        }
        System.out.println(dp[arr.length-1][k]);
        
    }
}


//tabulation with space optimization
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int[] arr={4,3,2,1};
        int k=5;
        boolean[] dp=new  boolean[k+1]; 
        Arrays.fill(dp,false);
        dp[0]=true;
        dp[arr[0]]=true;
        
        
        for(int i=1;i<arr.length;i++){
            boolean[] temp=new boolean[k+1];
            temp[0]=true;
            for(int tar=1;tar<=k;tar++){
        boolean pick=false;
        if(tar>=arr[i])
        pick=dp[tar-arr[i]];
        boolean notpick=dp[tar];
        temp[tar]=pick||notpick;
            }
            dp=temp;
        }
        System.out.println(dp[k]);
    }
}
