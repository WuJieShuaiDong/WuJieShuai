package com.wjs.leetcode.tree;

import com.wjs.leetcode.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @version 1.0
 * @Description: 二叉树的前、中、后序遍历,分为迭代和递归实现
 * @Author: liudaye
 * @Date: 2020/12/17 11:29 下午
 **/
public class OrderTree {

    /**
     * @param root 节点
     * @return 树节点值的集合
     * 递归实现的
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        //preorder(root,res);
        //inOrder(root,res);
        postOrder(root, res);
        return res;
    }

    /**
     * @param root 当前节点（前序）
     * @param res
     */
    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * @param root 当前节点（中序）
     * @param res
     */
    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        preorder(root.left, res);
        res.add(root.val);
        preorder(root.right, res);
    }


    /**
     * @param root 当前节点（后序）
     * @param res
     */
    private void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        preorder(root.left, res);
        preorder(root.right, res);
        res.add(root.val);
    }

    /**
     * @param root
     * @return 前序遍历集合
     * 非递归 迭代实现（前序）
     */
    public List<Integer> preOrderIteration(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    /**
     * @param root
     * @return 中序遍历集合
     * 中序遍历迭代
     */
    public List<Integer> inOrderIteration(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
        return res;
    }

    /**
     * @param root
     * @return
     * 后序迭代遍历
     */
    public List<Integer> postOrderIteration(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }
        return res;
    }


}
