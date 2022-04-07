class Solution {
  // fucntion to check all the suduko conditions 
    public boolean isSafe(char[][] board,int r,int c,int n){
        //for row and column
        for(int i=0;i<board.length;i++){
            if(board[i][c]==(char)(n+'0'))
                return false;
            if(board[r][i]==(char)(n+'0'))
                return false;
        }
        
        //grid
        // to find the starting most value of a grid
        int sr=(r/3)*3;
        int sc=(c/3)*3;
        
        for(int k=sr;k<sr+3;k++){
            for(int j=sc;j<sc+3;j++){
                if(board[k][j]==(char)(n+'0'))
                    return false;
            }
        }
        return true;
    }
    public boolean helper(char[][] board,int r,int c){
      // condition if my board if filled 
        if(r==board.length)
            return true;
      // setting up the no of row & column for next recurssion 
        int nr=0;
        int nc=0;
      // condition if my current column is not the last column
        if(c!=board.length-1){
            nr=r;
            nc=c+1;
        }
        // condition if my current column is the last column
      else {
            nr=r+1;
            nc=0;
        }
      
      // checking if my cell is already filled , if yes then call the next recurrsion 
        if(board[r][c]!='.'){
            if(helper(board,nr,nc))
                return true;
        }
      
      // if my cell is empty then check the rules of a sudoko, if the condition satisfies then put that value in that particular cell 
      // (char)(i+'0') === to change my int value to char
        else {
            for(int i=1;i<=9;i++) {
                if(isSafe(board,r,c,i)){
                    board[r][c]=(char)(i+'0');
                    if(helper(board,nr,nc))
                        return true;
                    else 
                      // if supppose after a certain point we find that the number we put was wrong so back-track and change it to empty ('.')
                        board[r][c]='.';
                }
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}
