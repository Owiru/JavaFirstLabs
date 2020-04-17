package lab_matrix_min_max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Lab. Найти минимум, максимум в двумерном массиве
 */

public class Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[][] matrix = new double[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Double.parseDouble(reader.readLine());
            }
        }

        printMatrix(matrix);
        System.out.println("\nMinimum - " + findMinimum(matrix));
        System.out.println("Maximum - " + findMaximum(matrix));
    }

    private static void printMatrix(double[][] array){
        System.out.println("Your matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j]+"\t\t");
            }
            System.out.print("\n");
        }
    }

    private static double findMinimum(double[][] array) {
        double minimum;
        minimum = array[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (minimum >= array[i][j]){
                    minimum = array[i][j];
                }
            }
        }

        return minimum;
    }

    private static double findMaximum(double[][] array) {
        double maximum;
        maximum = array[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (maximum <= array[i][j]){
                    maximum = array[i][j];
                }
            }
        }

        return maximum;
    }
}
