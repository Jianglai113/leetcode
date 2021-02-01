package com.jianglai.algorithm.tree;

/**
 * @author leon
 * @ClassName TreeNode.java
 * @createTime 2021年01月20日 19:21:00
 */
public class TreeNode {
    private int val;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private int parent;

    public TreeNode(int val, TreeNode leftChild, TreeNode rightChild) {
        this.val = val;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

}
