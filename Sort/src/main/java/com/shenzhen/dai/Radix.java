package com.shenzhen.dai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 基数排序
 */
public class Radix {
    int size;
    int[] data = new int[10000];

    public static void main(String[] args) {

        Radix radix = new Radix();
        int number = 1000;
        System.out.println("请输入数组大小(" + number + "以下)");
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            radix.size = Integer.parseInt(br.readLine());
            System.out.println("size = " + radix.size);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        radix.inputArr(number);
        System.out.println("您输入的原始数据是：\n");
//        radix.showData();
        long start = System.currentTimeMillis();
        radix.radix(number);
        long end = System.currentTimeMillis();
        System.out.println("执行时间 = " + (end - start));


    }

    void inputArr(int number) {
        Random rand = new Random();
        int i;
        for (i = 0; i < size; i++) {
            data[i] = (Math.abs(rand.nextInt(number - 1))) + 1;
        }
    }

    void showData() {
        int i;
        for (i = 0; i < size; i++) {
            System.out.println(data[i] + " ");
        }
        System.out.println("\n");
    }

    void radix(int number) {
        int i, j, k, n, m;
        for (n = 1; n <= number; n = n * 10) {
            // 设定暂存数组，[0~9位][数据个数]，所有内容均为0
            int[][] tmp = new int[10][number];
            for (i = 0; i < size; i++) {
                m = (data[i] / n) % 10;
                tmp[m][i] = data[i];
            }
            k = 0;
            for (i = 0; i < 10; i++) {
                for (j = 0; j < size; j++) {
                    if (tmp[i][j] != 0) {
                        data[k] = tmp[i][j];
                        k++;
                    }
                }
            }
            System.out.println("经过" + n + "位排序后：");
            showData();
        }
    }

}
