package com.jianglai.algorithm.common;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author leon
 * @ClassName BubbleSoert.java
 * @createTime 2021年01月16日 13:49:00
 * @Description:
 * 冒泡排序是一种交换排序，基本思想是：两两比较相邻记录的关键字，如果反序，则交换，直到没有反序记录为止
 * 时间复杂度：O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("请输入需要排序的数组，用\' \'间隔：\n");
        Scanner scanner = new Scanner(System.in);
        // 获取输入的数据为数组
        ArrayList<Integer> dataArray = getDataArray(scanner);
        System.out.println("输入的数组是："+dataArray.toString());
        // 排序
        ArrayList<Integer> sortedArray = sortDataByBubbleSort(dataArray);

        System.out.println("排序后的数组："+ sortedArray.toString());
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
