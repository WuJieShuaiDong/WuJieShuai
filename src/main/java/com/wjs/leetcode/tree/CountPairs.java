package com.wjs.leetcode.tree;

import com.wjs.leetcode.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: 好叶子节点 leetCode第1530题，两个叶子节点的最短路径小于某一个数
 * 给你二叉树的根节点 root 和一个整数 distance 。
 * 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
 * 返回树中 好叶子节点对的数量 。
 * @Author: WuJieShuaiDong
 * @Date: 2021/1/4 6:19 上午
 * 思路(借鉴大佬的思路)：遍历到X结点时，针对其左右子树，分别求它们所有的叶子深度并存到lefts和rights里，
 * 再计算左右子树的叶子和X结点链接起来的长度（即左子树叶子深度集合和右子树叶子深度集合中的元素互相之和再加2）
 * 是否<=distance，是的话res++。继续dfs遍历重复以上操作
 **/
public class CountPairs {

    //方法一：时间复杂度有点高
    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        List<Integer> lefts = new ArrayList<Integer>();
        countDepth(root.left,0,lefts);
        List<Integer> rights = new ArrayList<Integer>();
        countDepth(root.right,0,rights);
        int res = 0;
        //针对当前节点所有左子树和右子树的所有叶子节点判断深度
        for (Integer left : lefts) {
            for (Integer right: rights) {
                if (left + right + 2 <= distance) {
                    res ++;
                }
            }
        }
        res += countPairs(root.left,distance);
        res += countPairs(root.right,distance);
        return res;
    }


    /**
     * @param node
     * @param depth
     * @param list
     * 递归求子树的深度
     */
    private void countDepth(TreeNode node, int depth, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(depth);
            return;
        }
        countDepth(node.left,depth+1,list);
        countDepth(node.right,depth+1,list);

    }


    //方法二：可以优化，在递归的过程中进行筛选，不满足distance的直接剔除掉,这个递归有点难理解
    private int res = 0;
    public int countPairsTwo(TreeNode root, int distance) {
        recur(root, distance);
        return res;
    }

    private List<Integer> recur(TreeNode root, int distance) {//抽象为每个子节点到自己的距离
        if(root == null) return new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        if(root.left == null && root.right == null) {
            list.add(1);
            return list;
        }
        //遍历左子树获得左侧叶子节点到本节点路径长度;
        List<Integer> left = recur(root.left, distance);
        for(int item : left) {
            if(++item > distance) continue;
            list.add(item);
        }
        //遍历左子树获得右侧叶子节点到本节点路径长度;
        List<Integer> right = recur(root.right, distance);
        for(int item : right) {
            if(++item > distance) continue;
            list.add(item);

        }
        for(int item1: left) {
            for(int item2: right) {
                res += (item1 + item2) <= distance ? 1 : 0;
            }
        }
        return list;
    }
}
