// recursion way 
import java.util.*;
class HelloWorld {
    public static int func(int day,int[][] arr,int last){
        if(day==0){
            int max=0;
            for(int i=0;i<=2;i++){
                if(i!=last)
                  max=Math.max(max,arr[0][i]);
            }
            return max;
        }
        int maxi=0;
        int points=0;
        for(int j=0;j<=2;j++){
            if(j!=last)
             points=arr[day][j]+func(day-1,arr,j);
             maxi=Math.max(maxi,points);
        }
         return maxi;  
    }
    public static void main(String[] args) {
        int  n=3;
       int[][] arr={{10,40,70},{20,50,80},{30,60,90}};
       int res=func(arr.length-1,arr,3);
       System.out.println(res);
    }
}

//memoized way
import java.util.*;
class HelloWorld {
    public static int func(int day,int[][] arr,int last,int[][] dp){
        if(day==0){
            int max=0;
            for(int i=0;i<=2;i++){
                if(i!=last)
                  max=Math.max(max,arr[0][i]);
            }
            return max;
        }
        if(dp[day][last]!=-1) return dp[day][last];
        int maxi=0;
        int points=0;
        for(int j=0;j<=2;j++){
            if(j!=last)
             points=arr[day][j]+func(day-1,arr,j,dp);
             maxi=Math.max(maxi,points);
        }
         return dp[day][last]=maxi;  
    }
    public static void main(String[] args) {
        int  n=3;
       int[][] arr={{10,40,70},{20,50,80},{30,60,90}};
       int[][] dp=new int [n+1][4];
       for(int[] r:dp)
         Arrays.fill(r,-1);
       int res=func(arr.length-1,arr,3,dp);
       System.out.println(res);
    }
}

//tabular way
public static void main(String[] args) {
        int  n=3;
       int[][] arr={{10,40,70},{20,50,80},{30,60,90}};
       int[][] dp=new int [n+1][4];
       for(int[] r:dp)
         Arrays.fill(r,-1);
        dp[0][0]=Math.max(arr[0][1],arr[0][2]);
        dp[0][1]=Math.max(arr[0][0],arr[0][2]);
         dp[0][2]=Math.max(arr[0][0],arr[0][1]);
         int tempmax=Math.max(arr[0][1],arr[0][2]);
          dp[0][3]=Math.max(tempmax,arr[0][0]); 
          int points=0;
          
          for(int i=1;i<n;i++){
              for(int j=0;j<=3;j++){
                dp[i][j]=0;
                for(int k=0;k<=2;k++){
            if(k!=j)
             points=arr[i][k]+dp[i-1][k];
             dp[i][j]=Math.max( dp[i][j],points);
        }
        }
          }
       System.out.println(dp[n-1][3]);
    }
