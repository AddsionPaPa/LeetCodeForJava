package testbank;
import org.junit.Test;
import tools.UnionFind;
public class NumIslands_200 {

    public int numIslads(char[][] grid) {
        if (grid.length==0 || grid[0].length==0) {
            return 0;
        }

        UnionFind unionFind = new UnionFind(grid);
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < col ; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if(i-1>=0 && grid[i-1][j] =='1'){
                        unionFind.union(i*col+j,(i-1)*col+j);
                    }
                    if(j-1>=0 && grid[i ][j-1] =='1'){
                        unionFind.union(i*col+j,i*col+j-1);
                    }
                    if(i<row-1 && grid[i+1][j] =='1'){
                        unionFind.union(i*col+j,(i+1)*col+j);
                    }
                    if(j<col-1 && grid[i ][j+1] =='1' ){
                        unionFind.union(i*col+j,i *col+j+1);
                    }
                }
            }
        }
        return unionFind.getCount();
    }

    @Test
    public void fun() {
        char[][] c= new char[][]{
                {'1','1','1','1','1','1','1'} ,
                {'0','0','0','0','0','0','1'},
                {'1','1','1','1','1','0','1'},
                {'1','0','0','0','1','0','1'},
                {'1','0','1','0','1','0','1'},
                {'1','0','1','1','1','0','1'},
                {'1','1','1','1','1','1','1'}};
//        char[][] c = new char[][]{
//                {'1','1','1','1','1'},
//                {'1','0','0','0','1'},
//                {'1','0','1','0','1'},
//                {'1','1','1','1','1'}
//        };
        System.out.println(numIslads(c));


    }

}
