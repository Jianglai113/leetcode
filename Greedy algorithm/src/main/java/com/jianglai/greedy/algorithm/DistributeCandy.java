package com.jianglai.greedy.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author leon
 * @ClassName DistributeCandy.java
 * @createTime 2021年01月16日 12:07:00
 * @Discription:
 * 题目描述
 * 一群孩子站成一排,每一个孩子有自己的评分。现在需要给这些孩子发糖果,规则是如果一
 * 个孩子的评分比自己身旁的一个孩子要高,那么这个孩子就必须得到比身旁孩子更多的糖果;所
 * 有孩子至少要有一个糖果。求解最少需要多少个糖果。
 * 输入输出样例
 * 输入是一个数组,表示孩子的评分。输出是最少糖果的数量。
 */
public class DistributeCandy {
    public static void main(String[] args) {
        System.out.println("请输入孩子们的分数：\n");
        Scanner scanner = new Scanner(System.in);
        // 转换为数组
        ArrayList<Integer> childArray = getChildArray(scanner);
        System.out.println("孩子分数转换为数组："+ childArray.toString());
        // 创建糖果分配数组，并初始化为1
        ArrayList<Integer> candyArray = new ArrayList<Integer>();
        for(int i = 0; i < childArray.size(); i++){
            candyArray.add(1);
        }
        System.out.println("糖果分发数组："+candyArray.toString());
        // 左循环
        for(int i =0; i < childArray.size()-1; i++){
            for(int j = i+1; j <= childArray.size()-1; ){
                if(childArray.get(j) > childArray.get(i)){
                    candyArray.set(j, candyArray.get(i)+1);
                }
                break;
            }
        }
        System.out.println("完成左循环的candyArray："+candyArray.toString());
        // 右循环
        for(int i = childArray.size()-1; i > 0; i--){
            for(int j = i -1; j >=0;){
                if(childArray.get(j) > childArray.get(i) && candyArray.get(j) <= candyArray.get(i)){
                    candyArray.set(j, candyArray.get(i)+1);
                }
                break;
            }
        }

        System.out.println("最小糖果数量:"+candyArray.toString());
    }

    private static ArrayList getChildArray(Scanner scanner) {
        ArrayList<Integer> child = new ArrayList<Integer>();
        if(scanner.hasNext()){
            String[] childStr = scanner.nextLine().split(" ");
            for(int n = 0; n < childStr.length; n++){
                child.add(Integer.valueOf(childStr[n]));
            }
        }
        return child;
    }
}
