public class WordSearch_079 {
    int col;
    int row;
    String word;
    char[][] board;
    boolean flag=false;
    boolean[][] isLocated;
    public static void main(String[] args){
        char[][] board = {{'a'}};
        String word="ab";
        System.out.println(board.length+" ---"+board[0].length+" ==="+word.length());
    }
    public boolean exist(char[][] board,String word){
        this.word=word;
        this.board=board;
        this.row=board.length;
        this.col=board[0].length;
        this.isLocated=new boolean[row][col];
        if (word.length()==0){
            return true;
        }
        for (int i =0 ; i<row;i++){
            for (int j=0; j<col ; j++){
                if (dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int i, int j, int k){
        if (k==word.length()-1){
            return board[i][j] == word.charAt(k);
        }
        if (board[i][j] == word.charAt(k)){
            isLocated[i][j]=true;
            if (j<col-1 && !isLocated[i][j+1]){
                if (dfs(i,j+1,k+1)){
                    return  true;
                }
            }
            if(i>0&& !isLocated[i-1][j]){
               if (dfs(i-1,j,k+1)){
                   return true;
               }
            }
            if (j>0 && !isLocated[i][j-1]){
                if(dfs(i,j-1,k+1)){
                    return  true;
                }
            }
            if (i<row-1 && !isLocated[i+1][j]){
                if(dfs(i+1,j,k+1)){
                    return true;
                }
            }

            isLocated[i][j]=false;
        }
        return false;
    }
}
