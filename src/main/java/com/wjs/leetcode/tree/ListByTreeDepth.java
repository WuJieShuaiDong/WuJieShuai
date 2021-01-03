package com.wjs.leetcode.tree;

import com.wjs.leetcode.tree.utils.CreateTree;
import com.wjs.leetcode.tree.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @version 1.0
 * @Description: 通过二叉树的深度创建列表，每个列表的长度代表该高度树节点的个数，值夜与之对应。
 * 其实就是二叉树的层次遍历
 * @Author: WuJieShuaiDong
 * @Date: 2020/12/28 10:20 下午
 **/
public class ListByTreeDepth {

    public static class ListNode {
        Integer val;
        ListNode next;

        ListNode(Integer x) {
            val = x;
        }
    }

    public static ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(tree);
        List<ListNode> res = new ArrayList<ListNode>();  //先用List代替数组来保存每一个ListNode
        ListNode dummy = new ListNode(0);
        while (!queue.isEmpty()) {
            int len = queue.size();
            ListNode curr = dummy;
            for (int i = 0; i<len; i++) {
                TreeNode node = queue.poll();
                curr.next = new ListNode(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                curr = curr.next;
            }
            res.add(dummy.next);
            dummy.next = null;
        }
        return res.toArray(new ListNode[] {});
    }


    public static void main(String[] args) {
        List<Integer> rootList =new ArrayList<Integer>();
        rootList.add(1);
        rootList.add(2);
        rootList.add(3);
        rootList.add(7);
        rootList.add(5);
        rootList.add(null);
        rootList.add(8);
        TreeNode tree = CreateTree.createBinaryTreeByArray(rootList,0);

        ListNode [] node = listOfDepth(tree);
        for (int i = 0; i < node.length; i++) {
            System.out.println("node: " + node[i]);
        }
    }
}
