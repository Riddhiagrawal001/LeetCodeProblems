class Solution {
        
    public String countAndSay(int n) {
       if(n==1) return "1";
    char[] arr=countAndSay(n-1).toCharArray();
        int count=1;
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<arr.length;i++){
         if(i<arr.length-1 && arr[i]==arr[i+1])
             count++;
         else {
             temp.append(count).append(arr[i]);
             count=1;
         }  
        
        }
        return temp.toString();
    }
}
