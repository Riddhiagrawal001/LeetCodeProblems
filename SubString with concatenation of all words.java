class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen=words[0].length();
        int arrayLen=words.length;
        List<Integer> res=new ArrayList<Integer>();
        HashMap<String,Integer> dict=new HashMap<String,Integer>();
        
        if(wordLen*arrayLen > s.length())
            return res;
        for(String word: words)
        {
            if(dict.containsKey(word))
                dict.put(word,dict.get(word)+1);
            else 
                dict.put(word,1);
        }
       
        for(int i=0;i<=s.length()-(wordLen*arrayLen);i++){
             HashMap<String,Integer> wordused=new HashMap<String,Integer>();
            for(int j=i;j<i+(wordLen*arrayLen);j=j+wordLen){
                String wor=s.substring(j,j+wordLen);
                if(!dict.containsKey(wor))
                    break;
                else {
                    if(wordused.containsKey(wor))
                        wordused.put(wor,wordused.get(wor)+1);
                    else 
                        wordused.put(wor,1);
                }
                 if(wordused.get(wor)>dict.get(wor))
                    break; 
            }
            if(dict.equals(wordused))
                res.add(i);
            
        }
        
        return res;
    }
}
