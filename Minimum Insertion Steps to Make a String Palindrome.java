// the idea is that the no of minimum insertions needed to make a string pallindrome would be
// total length of the string - longest pallindromic subsequence

// to make any string pallindrome the max no of insertions would be the length of the string 
// eg : str="abc"   pallindromic string : " abc cba" , hence the no of insertions is 3

// eg : str="mbadm" length: 5 
// LCS = 3 "mam" 
// to make it a pallindromic subsequence m  bd   a   db  m 
// hence only two insertions required 
// as well as 5-3 = 2 , the ans

class Solution {
    public static int lenLPS(String s){
        // longest pallindromic subsequence
        String text1=s;
        StringBuilder text2=new StringBuilder();
        text2.append(s);
        text2.reverse();
        text2.toString();
        
        //longest common subsequence 
        int len1=text1.length();
            int len2=text2.length();
        int[] dp=new int[len2+1];
     
            Arrays.fill(dp,0);
        for(int i=0;i<=len2;i++)
            dp[i]=0;
        for(int i=1;i<=len1;i++){
            int[] temp=new int[len2+1];
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                  temp[j]=1+dp[j-1];
                else {
                  temp[j]=Math.max(dp[j],temp[j-1]); 
                }
       
            }
            dp=temp;  
        }

        return dp[len2];
    }
    public int minInsertions(String s) {
        return s.length()- lenLPS(s);
    }
}
