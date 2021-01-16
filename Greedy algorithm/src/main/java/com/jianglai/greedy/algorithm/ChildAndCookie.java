package com.jianglai.greedy.algorithm;

import java.util.*;

/**
 * @author leon
 * @ClassName ChildAndCookie.java
 * @createTime 2021年01月16日 11:23:00
 * @Discription
 * 题目描述
 * 有一群孩子和一堆饼干,每个孩子有一个饥饿度,每个饼干都有一个大小。每个孩子只能吃
 * 最多一个饼干,且只有饼干的大小大于孩子的饥饿度时,这个孩子才能吃饱。求解最多有多少孩
 * 子可以吃饱。
 * 输入输出样例
 * 输入两个数组,分别代表孩子的饥饿度和饼干的大小。输出最多有多少孩子可以吃饱的数
 * 量。
 */
public class ChildAndCookie {

    public static void main(String[] args) {

        System.out.println("请输入每个孩子的饥俄程度：\n");
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("请输入每个饼干的大小: \n");
        Scanner scanner2 = new Scanner(System.in);
        ArrayList<Integer> childArray = new ArrayList();
        ArrayList<Integer> cookieArray = new ArrayList();
        if(scanner1.hasNext()){
            // 将输入转换为数组
            childArray = getChildArray(scanner1);
            Collections.sort(childArray);

        }
        if(scanner2.hasNext()){
            cookieArray = getCookieArray(scanner2);
            Collections.sort(cookieArray);
        }

        System.out.println("经排序后的child:"+ childArray.toString());
        System.out.println("经排序后的cookie:"+ cookieArray.toString());

        // 喂孩子
        int childNum = 0; int cookieNum = 0;
        while (childNum < childArray.size() && cookieNum < cookieArray.size()){
            if(childArray.get(childNum) < cookieArray.get(cookieNum)){
                ++childNum;
            }else{
                ++cookieNum;
            }
        }
        System.out.println("孩子可以喂饱："+ childNum + "个。");

    }

    private static ArrayList getCookieArray(Scanner scanner2) {
        String[] childStr = scanner2.nextLine().split(" ");
        ArrayList<Integer> child = new ArrayList<Integer>();
        for(int n = 0; n < childStr.length; n++){
            child.add(Integer.valueOf(childStr[n]));
        }
        return child;
    }

    private static ArrayList getChildArray(Scanner scanner1) {
        String[] cookieStr = scanner1.nextLine().split(" ");
        ArrayList<Integer> cookie = new ArrayList<Integer>();
        for(int n = 0; n < cookieStr.length; n++){
            cookie.add(Integer.valueOf(cookieStr[n]));
        }
        return cookie;
    }


}
