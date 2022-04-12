// the question itself is a easy question but the main issue is with the BigInt

import java.math.BigInteger;

class Solution {
  // utility function that will convert the string number to a bigInt number
    public BigInteger returnNumber(String n){
      BigInteger number = BigInteger.valueOf(0);
        BigInteger mathPowVal;
        
        int len=n.length();
        for(int i=0;i<len;i++){
            char c=n.charAt(len-i-1);
            int val=c-'0';
            mathPowVal=BigInteger.valueOf(10).pow(i);
              mathPowVal=mathPowVal.multiply(BigInteger.valueOf(val));
            number=number.add(mathPowVal);
        }
        return number;
    }
  
    public String multiply(String num1, String num2) {
        BigInteger n1,n2,result;
        n1=returnNumber(num1);
        n2=returnNumber(num2);
         result=n1.multiply(n2);
        return String.valueOf(result);
    }
}
