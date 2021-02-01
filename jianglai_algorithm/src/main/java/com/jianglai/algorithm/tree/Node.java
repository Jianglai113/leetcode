package com.jianglai.algorithm.tree;

/**
 * @author leon
 * @ClassName Node.java
 * @createTime 2021年01月20日 19:51:00
 */
public class Node<E> {
    private E data;
    private int index;

    public Node(E data, int index) {
        this.data = data;
        this.index = index;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", index=" + index +
                '}';
    }
}
