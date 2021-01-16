package com.jianglai.algorithm.tensents;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author leon
 * @ClassName FightingMonsters.java
 * @createTime 2021年01月16日 10:41:00
 */
public class FightingMonsters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：\n");
        if (scanner.hasNext()){
            String[] s = scanner.nextLine().split(" ");
            int num = Integer.valueOf(s[0]);
            int q = Integer.valueOf(s[1]);
            int maxEarning = -1;
            for(int n = 0; n < num; n++){
                String[] s1 = scanner.nextLine().split(" ");
                // 判断本局是否收益大于消耗
                if(Integer.valueOf(s1[1]) > (Integer.valueOf(s1[0]) / q)){
                    maxEarning += Integer.valueOf(s1[1])- (Integer.valueOf(s1[0]) / q);
                }
            }
            System.out.println("最大收益是："+ maxEarning);
        }
    }
}
