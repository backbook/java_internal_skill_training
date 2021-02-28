package leetcode;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode left = new TreeNode(7);
        TreeNode right = new TreeNode(11);
        treeNode.left = left;
        treeNode.right = right;
        System.out.println(treeNode);
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
//        levelOrderTraversal.levelOrder(treeNode);



    }


    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.println(queue);
            System.out.println(poll.val);
            if (root.left != null){
                queue.add(root.left);
            }
            if (root.right != null){
                queue.add(root.right);
            }
        }
    }



}
