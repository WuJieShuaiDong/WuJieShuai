package com.wjs.leetcode.tree.utils;


/**
 * @version 1.0
 * @Description: 树的节点
 * @Author: WuJieShuaiDong
 * @Date: 2020/12/20 5:05 下午
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
