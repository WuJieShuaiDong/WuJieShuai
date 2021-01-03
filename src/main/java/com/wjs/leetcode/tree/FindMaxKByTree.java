package com.wjs.leetcode.tree;

import com.wjs.leetcode.tree.utils.TreeNode;

/**
 * @version 1.0
 * @Description: 寻找二叉搜索树的第k个最大的节点
 * @Author: WuJieShuaiDong
 * @Date: 2021/1/1 10:18 下午
 * 其实有个前提，二叉搜索树的中序遍历是排序好的
 **/
public class FindMaxKByTree {
    private int ans = 0, count = 1;
    public int kthLargest(TreeNode root, int k) {
        inOrder(root,k);
        return ans;
    }

    private void inOrder(TreeNode root, int k) {
        if (root.right != null) inOrder(root.right,k);
        if (count++ == k) {
            ans = root.val;
            return ;
        }
        if (root.left != null) inOrder(root.left,k);
    }
}
