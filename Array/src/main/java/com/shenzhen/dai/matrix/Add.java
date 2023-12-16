package com.shenzhen.dai.matrix;

public class Add {
    public static void main(String[] args) {
        int[][] matrixA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrixB = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        MatrixUtil.print(matrixA);
        MatrixUtil.print(matrixB);
        MatrixUtil.print(add(matrixA, matrixB));
    }

    public static int[][] add(int[][] matrixA, int[][] matrixB) {
        int[][] matrixC = new int[matrixA.length][matrixA[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return matrixC;
    }


}
