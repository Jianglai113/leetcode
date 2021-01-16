package com.jianglai.algorithm.common;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author leon
 * @ClassName quickSort.java
 * @createTime 2021年01月16日 14:57:00
 * @Description:
 * 快速排序：
 *      通过一趟排序将待排序记录分隔成独立的两个部分，
 *      其中一部分记录的关键字均比另一部分关键字小，
 *      则可以分别对这两部分记录继续进行排序，以达到整个序列有序
 *
 */
public class QuickSort {
    public static void main(String[] args) {
        System.out.println("请输入需要排序的数组：\n");
        Scanner scanner = new Scanner(System.in);

        // 将输入数据转换为数组
        ArrayList<Integer> dataArray = getDataArray(scanner);
        System.out.println("输入的数组是："+dataArray.toString());

        // 快速排序
        ArrayList<Integer> quickSortResult = quickSort(dataArray, 0, dataArray.size()-1);
        System.out.println("快速排序结果："+quickSortResult.toString());
    }

    /**
     * 快速排序
     * @param dataArray
     * @return
     */
    private static ArrayList<Integer> quickSort(ArrayList<Integer> dataArray, int start, int end) {

        System.out.println("调用：");
        // code
        if(dataArray.isEmpty() || end < start){
            return null;
        }
        Integer spaceIndex = arrayPartition(dataArray, start, end);
        if(spaceIndex > start){
            quickSort(dataArray, start, spaceIndex -1);
        }
        if(spaceIndex < end){
            quickSort(dataArray, spaceIndex + 1, end);
        }

        return dataArray;
    }

    /**
     * 分区快排
     * @param dataArray
     * @param start
     * @param end
     * @return
     */
    private static Integer arrayPartition(ArrayList<Integer> dataArray, int start, int end) {
        // 随机选择一个waterMakr
        Integer waterMakr = (int) (start + Math.random() * (end - start + 1));
        System.out.println("waterMark==="+waterMakr+"start==>"+start+", end===>"+end);
        Integer spaceIndex = start;
        // 将随机waterMark置换到首位
        swap(dataArray, start, waterMakr);
        System.out.println("置换首位后："+dataArray.toString());
        for(int i = start + 1; i <= end; i++){
            if(dataArray.get(i) <= dataArray.get(start)){
                spaceIndex++;
                if(i > spaceIndex){
                    swap(dataArray, spaceIndex, i);
                }
            }
        }
        swap(dataArray, start, spaceIndex);
        System.out.println("本次排序后："+dataArray.toString()+"=== spaceIndex："+spaceIndex);
        return spaceIndex;
    }

    /**
     * 交换两个元素
     * @param dataArray
     * @param small
     * @param big
     */
    private static void swap(ArrayList<Integer> dataArray, int small, int big) {
        Integer max = dataArray.get(big);
        dataArray.set(big, dataArray.get(small));
        dataArray.set(small, max);
    }

    /**
     * 读取输入为ArrayList
     * @param scanner
     * @return
     */
    private static ArrayList<Integer> getDataArray(Scanner scanner) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        if(scanner.hasNext()){
            String[] strArray = scanner.nextLine().split(" ");
            for(int n =0 ; n < strArray.length; n++){
                integers.add(Integer.valueOf(strArray[n]));
            }
        }
        return integers;
    }


}
