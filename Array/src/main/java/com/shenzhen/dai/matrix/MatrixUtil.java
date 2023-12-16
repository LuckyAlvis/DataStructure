package com.shenzhen.dai.matrix;

public class MatrixUtil {
    public static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.print("\n");
        }
        System.out.println();
    }
}
