import java.util.*;
class HelloWorld {
    public static int func(int index,int[] arr, int n,int sum,int required){
        
      if(index==n){
          //condition satisfied
          if(sum==required){
            return 1;
          }
            // condition not satisfied 
             else return 0;
      }
     //pick
      sum=sum+arr[index];
    int l=func(index+1,arr,n,sum,required);
      sum=sum-arr[index];
     // not pick 
    int r=func(index+1,arr,n,sum,required);
    return l+r;   
    }
    public static void main(String[] args) {
      int arr[]={1,2,1,4,5,6};
      int n=6;
      int sum=0;
      int required=2;
      int res=func(0,arr,n,sum,required);
      System.out.println(res);
    }
}
