import java.util.*;
class HelloWorld {
    public static void func(int index,  List<List<Integer>> list,int[] arr, int n,int sum,int required,List<Integer> temp){
        
      if(index==n){
          if(sum==required){
              list.add(new ArrayList<>(temp));
          }
             
             return;
      }
      temp.add(arr[index]);
      sum=sum+arr[index];
      func(index+1,list,arr,n,sum,required,temp);
      temp.remove(temp.size()-1);
      sum=sum-arr[index];
      func(index+1,list,arr,n,sum,required,temp);
    }
    public static void main(String[] args) {
      int arr[]={1,2,1,4,5,6};
      int n=6;
      int sum=0;
      int required=2;
       List<List<Integer>>  list =new ArrayList();
      func(0,list,arr,n,sum,required,new ArrayList<>());
      System.out.println(list);
    }
}

// suppose you want to print only  a single subsequence
import java.util.*;
class HelloWorld {
    public static boolean func(int index,  List<List<Integer>> list,int[] arr, int n,int sum,int required,List<Integer> temp){
        
      if(index==n){
          //condition satisfied
          if(sum==required){
              list.add(new ArrayList<>(temp));
              return true;
          }
            // condition not satisfied 
             else return false;
      }
      temp.add(arr[index]);
      sum=sum+arr[index];
      if(func(index+1,list,arr,n,sum,required,temp)) 
          return true;
      temp.remove(temp.size()-1);
      sum=sum-arr[index];
     if( func(index+1,list,arr,n,sum,required,temp))
       return true;
    return false;   
    }
    public static void main(String[] args) {
      int arr[]={1,2,1,4,5,6};
      int n=6;
      int sum=0;
      int required=2;
       List<List<Integer>>  list =new ArrayList();
      func(0,list,arr,n,sum,required,new ArrayList<>());
      System.out.println(list);
    }
}
