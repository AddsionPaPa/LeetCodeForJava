package testbank;

public class FlattenBinaryTreeToLinkedList_114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        /**
         * 1. 查看是否有左节点
         * 2. 有则将root的右节点连接到前序遍历下 root的左节点下最后一个节点
         * 3.  root的左节点连接到root的右节点
         */
//        if (root==null)return;
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre= pre.right;
                }
                pre.right=root.right;
                root.right=root.left;
                root.left=null;
                root=root.right;
            }
//            root=root.right;
        }

    }
}
