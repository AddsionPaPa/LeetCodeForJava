package testbank;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree_108 {
      public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
        TreeNode(int x) { val = x; }
   }

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int i=nums.length/2;

        TreeNode root = new TreeNode(nums[i]);

        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,i));

        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,i+1,nums.length));

        return  root;
    }

}
