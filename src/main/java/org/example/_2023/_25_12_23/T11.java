package org.example._2023._25_12_23;

public class T11 {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 3}, {2, 4, 6, 8}, {4, 5, 8, 9}};
        System.out.println(isContin(matrix, 9));

    }

    static boolean isContin(int[][] matrix, int num) {
        int columnsLength = 0;
        int rowsLength = matrix[0].length - 1;

        while (columnsLength < matrix.length && rowsLength >= 0) {
            if (matrix[columnsLength][rowsLength] == num) {
                return true;
            } else if (matrix[columnsLength][rowsLength] < num) {
                columnsLength++;
            } else {
                rowsLength--;
            }
        }

//        while (columnsLength!=matrix.length || rowsLength!=0) {
//            if (matrix[columnsLength][rowsLength] ==num){
//                return true;
//            }
//            if(matrix[columnsLength][rowsLength]<num){
//                columnsLength++;
//            } else {
//                rowsLength--;
//            }
//        }
        return false;

    }
}
