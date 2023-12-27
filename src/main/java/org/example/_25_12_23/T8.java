package org.example._25_12_23;

import java.util.Arrays;

public class T8 {
    public static void main(String[] args) {
        int[][] matrixOld = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        met(matrix -> {
            int[][] matrixNew = new int[matrix[0].length][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                int[] line = matrix[i];
                for (int j = 0; j < line.length; j++) {
                    matrixNew[j][i] = line[j];
                }
            }
            System.out.println(Arrays.deepToString(matrixNew));
        }, matrixOld);

    }
//    private static void transposeMatrix(int[][] matrix) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = i + 1; j < cols; j++) {
//                // Обмен элементов по диагонали (i, j) и (j, i)
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//    }

    public static void met(MatrixProcessor matrixProcessor, int[][] matrix) {
        matrixProcessor.process(matrix);
    }
}

//    Создайте функциональный интерфейс MatrixProcessor с методом process, который принимает
//    двумерный массив (матрицу) целых чисел и выполняет над ним операцию.
//    Напишите метод, который принимает матрицу и MatrixProcessor, и выполняет операцию нахождения транспонированной матрицы.
@FunctionalInterface
interface MatrixProcessor {
    void process(int[][] matrix);
}
