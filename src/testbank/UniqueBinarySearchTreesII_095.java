package testbank;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import sun.reflect.generics.tree.Tree;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII_095 {
    public static void main(String[] args) {

    }
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n==0){
            return new ArrayList<TreeNode>();
        }
        return sub_generate(1,n);
    }
    public List<TreeNode> sub_generate(int start, int end){
        List<TreeNode> res= new ArrayList<>();
        if (start>end){
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left_tree=sub_generate(start,i-1);

            List<TreeNode> right_tree=sub_generate(i+1,end);

            for (TreeNode j : left_tree) {
                for (TreeNode k : right_tree){
                    TreeNode root= new TreeNode(i);
                    root.left=j;
                    root.right=k;
                    res.add(root);
                }
            }
        }
        return res;
    }
}

