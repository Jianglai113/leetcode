package com.jianglai.greedy.algorithm;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author leon
 * @ClassName NoOverlappingInterval.java
 * @createTime 2021年01月16日 13:27:00
 * @Description
 * 题目描述
 * 给定多个区间,计算让这些区间互不重叠所需要移除区间的最少个数。起止相连不算重叠。
 * 输入输出样例
 * 输入是一个数组,数组由多个长度固定为 2 的数组组成,表示区间的开始和结尾。输出一个
 * 整数,表示需要移除的区间数量。
 * Input: [[1,2], [2,4], [1,3]]
 * Output: 1
 */
public class NoOverlappingInterval {

    public static void main(String[] args) {

        System.out.println("请输入计算区间的数组(区间用\"，\"号间隔 数组元素用\" \"间隔 ):\n");
        Scanner scanner = new Scanner(System.in);
        // 获取区间数组
        ArrayList<ArrayList<Integer>> intervalsArray = getIntervalsArray(scanner);
        System.out.println(intervalsArray.toString());

        // 对其排序-按照区间大小
        TreeMap<Integer, ArrayList<Integer>>  sortTreeMap = sortIntervalsArray(intervalsArray);
        System.out.println("排序后的区间数组："+sortTreeMap.toString());


    }

    private static TreeMap<Integer, ArrayList<Integer>>  sortIntervalsArray(ArrayList<ArrayList<Integer>> intervalsArray) {
        ArrayList<ArrayList<Integer>> newintervalsArray = new ArrayList<ArrayList<Integer>>();
        BubbleSort bubbleSort = new BubbleSort();
        TreeMap<Integer, ArrayList<Integer>> dataTreemap = new TreeMap<Integer, ArrayList<Integer>>();
        // 利用TreeMap根据区间尾的大小排序
        for(int i=0; i<intervalsArray.size()-1; i++){
            dataTreemap.put(intervalsArray.get(i).get(1), intervalsArray.get(i));
        }

        return dataTreemap;
    }

    private static ArrayList<ArrayList<Integer>> getIntervalsArray(Scanner scanner) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        if(scanner.hasNext()){
            String[] intervalsArray = scanner.nextLine().split(" ");
            for(int n =0; n < intervalsArray.length; n++){
                ArrayList<Integer> integers = new ArrayList<Integer>();
                String[] splits = intervalsArray[n].split(",");
                integers.add(Integer.valueOf(splits[0]));
                integers.add(Integer.valueOf(splits[1]));
                arrayLists.add(integers);
            }
        }
        return arrayLists;
    }
}

