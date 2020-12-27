package com.wjs.leetcode.tree.utils;


/**
 * @version 1.0
 * @Description: 树的节点
 * @Author: WuJieShuaiDong
 * @Date: 2020/12/20 5:05 下午
 **/
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer val) {
        this.val = val;
    }

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
