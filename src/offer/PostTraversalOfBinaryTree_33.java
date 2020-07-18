package offer;

import org.junit.Test;

public class PostTraversalOfBinaryTree_33 {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0 && postorder.length == 1) {
            return true;
        }
        return  recur(postorder,0,postorder.length-1);
    }

    public boolean recur(int[] postorder, int i, int j) {
        if (i>=j){
            return true;
        }
        int pos = i;
        while (pos < j) {
            if (postorder[pos] > postorder[j]) {
                break;
            }
            pos++;
        }
        int m = pos;
        while (pos <= j) {
            if (postorder[pos] <= postorder[j]) {
                break;
            }
            pos++;
        }
        return (pos == j) && recur(postorder,i,m-1) && recur(postorder,m,j-1);
    }
    @Test
    public void test() {
        int[] a =new int[]{4,6,7,5};
        verifyPostorder(a);


    }
}
