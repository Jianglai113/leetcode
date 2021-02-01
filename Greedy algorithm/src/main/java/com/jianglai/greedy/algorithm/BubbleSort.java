package com.jianglai.greedy.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author leon
 * @ClassName BubbleSort.java
 * @createTime 2021年01月19日 20:12:00
 * @Decription: 冒泡排序
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        System.out.println("请输入数据：");
        Scanner scanner = new Scanner(System.in);
        // 转换为数组列表
        ArrayList<Integer> dataArrayList = getDataArrayList(scanner);
        System.out.println("你输入的数据是："+dataArrayList.toString());
        // 冒泡排序
        sortByBubbleSort(dataArrayList);
        System.out.println("排序后："+dataArrayList.toString());
    }

    /**
     * 冒泡排序
     * @param dataArrayList
     */
    private static void sortByBubbleSort(ArrayList<Integer> dataArrayList) {
        for(int i=dataArrayList.size()-2; i>=0; i--){
            for(int j=0; j<i+1; j++){
                if(dataArrayList.get(j) > dataArrayList.get(j+1)){
                    swap(dataArrayList, j, j+1);
                }
            }
        }
    }

    /**
     * 置换位置
     * @param dataArrayList
     * @param left
     * @param right
     */
    private static void swap(ArrayList<Integer> dataArrayList, int left, int right) {
        int tmp = dataArrayList.get(right);
        dataArrayList.set(right, dataArrayList.get(left));
        dataArrayList.set(left, tmp);
    }

    /**
     * 获取数据的ArrayList
     * @param scanner
     * @return
     */
    private static ArrayList<Integer> getDataArrayList(Scanner scanner) {
        ArrayList<Integer> dataArrayList = new ArrayList<Integer>();
        if(scanner.hasNext()){
            String[] str = scanner.nextLine().split(" ");
            for(int i = 0; i < str.length; i++){
                dataArrayList.add(Integer.valueOf(str[i]));
            }
        }
        return dataArrayList;
    }
}
