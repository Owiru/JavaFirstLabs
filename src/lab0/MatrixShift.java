package lab0;

import java.util.Scanner;

/*
Lab0. Циклический сдвиг по строкам матрицы
 */

public class MatrixShift {
    public static void main(String[] args)  {
        double[][] myMatrix = enterMatrix();
        printMatrix(myMatrix);
        switchPrint(myMatrix);
    }

    // Печать матрицы
    private static void printMatrix(double[][] array){
        int column = array[0].length;

        System.out.println("\nYour myMatrix:");
        for (double[] doubles : array) {
            for (int j = 0; j < column; j++) {
                System.out.print(doubles[j] + "\t\t");
            }
            System.out.println();
        }
    }

    // Ввод матрицы
    private static double[][] enterMatrix() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter myMatrix size:");
        int line = enterLineSize();
        int column = enterColumnSize();
        double[][] array = new double[line][column];

        System.out.println("\nEnter myMatrix elements:");
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = scan.nextDouble();
            }
        }
        return array;
    }

    // Циклический сдвиг вправо | Тестовый вариант
    private static void shiftRight(double[][] array) {
        int line = array.length;
        int column = array[0].length;

        int steps = enterShiftNumber();
        int realSteps = steps % line;

        for (int k = 0; k < realSteps; k++){
            for (int i = 0; i < line; i++){
                double temp = array[i][column-1];
                int j;
                for (j = column-1; j > 0; j--){
                    array[i][j] = array[i][j - 1];
                }
                array[i][j] = temp;
            }
        }
    }

    // Ввод колва строк
    private static int enterLineSize() {
        Scanner scan = new Scanner(System.in);
        int lineSize = scan.nextInt();
        while (lineSize < 1) {
            System.out.println("Wrong line size! Enter again!");
            lineSize = scan.nextInt();
        }
        return lineSize;
    }

    // Ввод колва столбцов
    private static int enterColumnSize() {
        Scanner scan = new Scanner(System.in);
        int columnSize = scan.nextInt();
        while (columnSize < 1) {
            System.out.println("Wrong column size! Enter again!");
            columnSize = scan.nextInt();
        }
        return columnSize;
    }

    // Ввод колва сдвига
    private static int enterShiftNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter number of shift steps - ");
        int shiftNumber = scan.nextInt();
        while (shiftNumber < 0) {
            System.out.println("Wrong shift number! Enter again!");
            shiftNumber = scan.nextInt();
        }
        return shiftNumber;
    }

    // Циклический сдвиг вверх
    private static void shiftUp(double[][] array) {
        int line = array.length;
        int steps = enterShiftNumber();
        int realSteps = steps % line;

        for (int k = 0; k < realSteps; k++) {
            for (int i = 0; i < array.length; i++) {
                double temp = array[0][i];
                int j;
                for (j = 0; j < array.length - 1; j++) {
                    array[j][i] = array[j + 1][i];
                }
                array[j][i] = temp;
            }
        }
    }

    // Циклический сдвиг вниз
    private static void shiftDown(double[][] array) {
        int line = array.length;

        int steps = enterShiftNumber();
        int realSteps = steps % line;

        double[] temp;
        for (int i = 0; i < realSteps; i++) {
            temp = array[line - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = temp;
        }
    }

    private static void switchPrint(double[][] array) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nChoose option:" +
                "\n1 - shift Up" +
                "\n2 - shift Down" +
                "\nAny char - close" +
                "\n-> ");
        int switchNum = scan.nextInt();
        switch (switchNum) {
            case 1:
                shiftUp(array);
                printMatrix(array);
                break;
            case 2:
                shiftDown(array);
                printMatrix(array);
                break;
            default:
                System.out.println("\nBye!");
        }
        scan.close();
    }
}
