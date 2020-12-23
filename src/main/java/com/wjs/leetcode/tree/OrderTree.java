package com.wjs.leetcode.tree;

import com.wjs.leetcode.tree.utils.TreeNode;

import java.util.*;

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
        //这个判断是可能cur是叶子节点，但是栈不空；
        while (!stack.isEmpty() || cur != null) {
            //1.这一步其实就是把根节点的最左的一部分找到，放在栈中
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //2.拿出当前栈顶也就是当前节点的最左边孩子的节点
            TreeNode node = stack.pop();
            res.add(node.val);
            //3.处理当前节点的右子树
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


    /**
     * @param root
     * @param res
     * @return 返回层序遍历的集合，分层展示 迭代
     * 算法思想：用一个队列，父节点先进队然后出队，这个时候左右节点再入队分别出队，循环这个过程，
     * 直到队列为空遍历完毕，层序遍历 要求输出每层的遍历的内容 形式就是：
     * 【1】
     * 【2，3】
     * 【4,5,6】
     * 这样的形式，其实也不难，因为我们其实每次入队都是一层一层的入，
     * 我们下面的算法是根据第k次循环一定是k层的元素，只要能保证这个点就行。
     * 这个算法根据数学归纳法可以证明。。。哈哈哈，
     */
    public List<List<Integer>> levelOrder (TreeNode root, List<List<Integer>> res) {
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            //获取当前层级有多少个节点,根据队列中的数据 遍历获取节点值
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
         res.add(level);
        }
        return res;
    }


    /**
     * @param treeNode
     * @return
     * 层序遍历递归做法
     */
    public List<List<Integer>> level(TreeNode treeNode) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (treeNode != null) return res;
        return levelOrderDg(treeNode,res,1);
    }

    /**
     * @param root
     * @param res
     * @return
     * 递归
     */
    public List<List<Integer>> levelOrderDg (TreeNode root, List<List<Integer>> res, Integer level) {
        if (res.size() < level) {
            res.add(new ArrayList<Integer>());
        }
        //将当前的节点值加入到当前层数，为什么减一，因为list的下标是从0开始，level是从1开始的
        res.get(level - 1).add(root.val);
        if (root.left != null) {
            levelOrderDg(root.left,res,level + 1);
        }
        if (root.right != null) {
            levelOrderDg(root.right,res,level + 1);
        }
        return res;
    }


    }
