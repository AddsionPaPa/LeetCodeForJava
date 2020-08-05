package testbank;
import org.junit.Test;
import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightView_199 {

    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {

        dfs(root,0);
        return list;
    }
    public void  dfs(TreeNode root,int step){
        if (root != null) {
            if (step == list.size()) {
                list.add(root.val);
            }

            dfs(root.right,step+1);
            dfs(root.left,step+1);
        }
    }
    @Test
    public void fun() {
        int[] a = new int[5];
        a[1 ] = 2;
        a[4] = 3;
        for (int i = 0; i <5 ; i++) {
            System.out.println(a[i]);
        }
    }
}
