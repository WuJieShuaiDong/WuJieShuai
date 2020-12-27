package com.wjs.leetcode.tree.utils;

import java.util.List;

/**
 * @version 1.0
 * @Description: 创建一棵二叉树
 * @Author: WuJieShuaiDong
 * @Date: 2020/12/27 12:05 下午
 **/
public class CreateTree {
//    public TreeNode root;
//
//    public CreateTree(List<Integer> array) {
//        root = createBinaryTreeByArray(array, 0);
//    }


    public static TreeNode createBinaryTreeByArray(List<Integer> array, int index) {
        TreeNode tn = null;
        if (index < array.size()) {
            Integer value = array.get(index);
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }


}
