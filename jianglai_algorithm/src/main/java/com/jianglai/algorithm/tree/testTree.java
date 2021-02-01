package com.jianglai.algorithm.tree;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author leon
 * @ClassName testTree.java
 * @createTime 2021年01月20日 19:19:00
 */
public class testTree {
    public static void main(String[] args) {

        System.out.println("请输入数据，不相同的整数：");
        Scanner scanner = new Scanner(System.in);
        // 转化为数组
        ArrayList<Integer> dataArray = getDataArray(scanner);
        // 排序
        ArrayList<Integer> integers = sortDataByBubbleSort(dataArray);
        System.out.println("输入的数据是："+ integers.toString());

        TreeNodeArray treeNodeArray = new TreeNodeArray(integers);
        for(int i=0; i<treeNodeArray.getNodeNum(); i++){
            System.out.println("==>"+treeNodeArray.getNode(i));
        }

        //System.out.println("树===>"+treeNodeArray.toString());
    }

    public static ArrayList<Integer> getDataArray(Scanner scanner){
        ArrayList<Integer> integers = new ArrayList<Integer>();
        if(scanner.hasNext()){
            String[] numStr = scanner.nextLine().split(" ");
            for(String str : numStr){
                integers.add(Integer.valueOf(str));
            }
        }
        return integers;
    }

    public static ArrayList<Integer> sortDataByBubbleSort(ArrayList<Integer> dataArray){
        for(int i =0; i< dataArray.size()-1; i++){
            for(int j =0; j<dataArray.size()-i-1; j++){
                if(dataArray.get(j) > dataArray.get(j+1)){
                    int max = dataArray.get(j);
                    dataArray.set(j, dataArray.get(j+1));
                    dataArray.set(j+1, max);
                }
            }
        }
        return  dataArray;
    }
}
