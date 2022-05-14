class Solution {
    static boolean compare(String w1,String w2){
        if(w1.length() != w2.length()+1) return false;
        int fir=0;
        int sec=0;
        while(fir<w1.length()){
            if(sec<w2.length() && w1.charAt(fir)==w2.charAt(sec)){
                fir++;
                sec++;
            }
            else {
                fir++;
            }
        }
        if(fir==w1.length() && sec==w2.length() ) return true;
        return false;
    }
    public int longestStrChain(String[] words) {
          int m =words.length;
       Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        int[] dp=new int[m];
        Arrays.fill(dp,1);
        int maxi=1;
        for(int i=0;i<m;i++){
          
            for(int j=0;j<i;j++){
                if( compare(words[i],words[j]) && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    
                }
                    
                
            }
            if(dp[i]>maxi){
                maxi=dp[i];
               
            }
        }
        return maxi;
    }
}
