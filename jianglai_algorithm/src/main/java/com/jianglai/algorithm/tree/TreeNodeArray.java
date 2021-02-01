package com.jianglai.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author leon
 * @ClassName TreeNodeArray.java
 * @createTime 2021年01月20日 19:38:00
 */
public class TreeNodeArray<E> {
    private static final int DEFAULT_SIZE = 20;
    private int size;
    private Node<E>[] nodes;
    private int nodeNum;

    public TreeNodeArray(E data){
        size = DEFAULT_SIZE;
        nodes = new Node[size];
        nodes[0] = new Node<E>(data, -1);
        nodeNum++;
    }

    public TreeNodeArray(E data, int capacity){
        size = capacity;
        nodes = new Node[size];
        nodes[0] = new Node<E>(data, -1);
        nodeNum++;
    }

    /**
     * 传入升序的ArrayList
     * @param dataArray
     */
    public TreeNodeArray(ArrayList<E> dataArray){
        size = dataArray.size();
        nodes = new Node[size];
        int waterMark = -1;
        waterMark =  (size%2 == 0) ? (size/2 -1) : ((size-1)/2);
        nodes[waterMark] = new Node<E>(dataArray.get(waterMark), -1);
        Node<E> parentNode = nodes[waterMark];
        for(int i = waterMark-1; i>=0; i--){
            E data = dataArray.get(i);
            this.addNode(data, i,parentNode);
            parentNode = this.getNode(i);
        }
        for(int i=size-1; i>=waterMark+1; i--){
            E data = dataArray.get(i);
            this.addNode(data, dataArray.indexOf(data),parentNode);
            parentNode = this.getNode(dataArray.indexOf(data));
        }
    }

    /**
     * 添加节点
     * @param data
     * @param parent
     * @return
     */
    public Node<E> addNode(E data, Node parent){
        for(int i = 0; i < size; i++){
            if(null == nodes[i]){
                nodes[i] = new Node<E>(data, pos(parent));
                nodeNum++;
                return nodes[i];
            }
        }
        throw new RuntimeException("该树已满，无法添加新节点;");
    }

    public Node<E> addNode(E data, int index, Node parent){
            if(null == nodes[index]){
                nodes[index] = new Node<E>(data, pos(parent));
                nodeNum++;
                return nodes[index];
            }
        throw new RuntimeException("该树已满，无法添加新节点;");
    }
    /**
     * 根据索引获取节点
      * @param index
     * @return
     */
    public Node<E> getNode(int index){
        Node<E> node = this.nodes[index];
        return node;
    }
    /**
     * 查找该节点的索引值
     * @param node
     * @return
     */
    public int pos(Node node){
        for(int i=0; i < size; i++){
            if(nodes[i] == node ) return i;
        }
        return -1;
    }

    public int getNodeNum() {
        return nodeNum;
    }

    @Override
    public String toString() {
        String nodes = "[";
        for(int i =0; i< this.nodes.length; i++){
            nodes += this.nodes[i].toString();
        }
        nodes+="]";
        return "TreeNodeArray{" +
                "size=" + size +
                ", nodes=" + nodes +
                ", nodeNum=" + nodeNum +
                '}';
    }


}
