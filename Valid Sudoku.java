// solution 1:
// Make 3 hash sets 
// iterate over everything and start putting the values in hashset
// check if theres any duplictaes 
// if there are no duplicates return true else false


// solution 2: The more optimized code as well as data structure solution 
// make just one hash map and put every row , column and sub boxes in that hash set only
// hashset.add value returns false if there's a duplicate value otherwise it just adds the value to the hash set
class Solution {
    public boolean isValidSudoku(char[][] board) {
    HashSet<String> seenval=new HashSet();
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c =board[i][j];
                if(c!='.'){
                    if(!seenval.add(c+" found in row "+i) || 
                       !seenval.add(c+" found in column "+j) || 
                       !seenval.add(c+" found in sub-box"+i/3+"-"+j/3) )
                        return false;
                }
            }
        }
        return true;
        
    }
}
