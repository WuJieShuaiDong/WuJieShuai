package com.wjs.leetcode.tree;

import com.wjs.leetcode.tree.utils.CreateTree;
import com.wjs.leetcode.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description:判断是否是一棵平衡树
 * @Author: WuJieShuaiDong
 * @Date: 2020/12/26 11:20 下午
 **/
public class BalancedTree {

    public static boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private static int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public static void main(String[] args) {
        List<Integer> rootList =new ArrayList<Integer>();
        rootList.add(3);
        rootList.add(9);
        rootList.add(20);
        rootList.add(null);
        rootList.add(null);
        rootList.add(15);
        rootList.add(7);
        TreeNode tree = CreateTree.createBinaryTreeByArray(rootList,0);
        System.out.println("isBanlance : " + isBalanced(tree));
    }


}
