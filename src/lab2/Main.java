package lab2;

/*
1.     Лабораторная работа №2. Создание и обработка собственных исключений.

В программе требуется:
·        Создать собственное исключение (class).
·        Создать метод (throw), который может возбуждать это исключение(throws).
·        Написать метод, перехватывающий и обрабатывающий исключение (try-catch), возбуждаемое другим методом.
Исключение: создать класс MyString, который не допускает строк длиннее семи символов. Сформировать массив объектов типа MyString.
 */

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MyString[] myArrayString = new MyString[setSize()];
        createArrayMyString(myArrayString);
        printArrayMyString(myArrayString);
        scanner.close();
    }

    private static void createArrayMyString(MyString[] stringArray) {
        int index = 0;
        scanner.nextLine();     // Очистка буфера от \n
        tryCatchMyString(stringArray, index);
    }

    private static void tryCatchMyString(MyString[] stringArray, int index) {
        while (index < stringArray.length) {
            try {
                System.out.print(index + " element -> ");
                MyString temp = new MyString(scanner.nextLine());
                throwMyString(temp);
                stringArray[index] = temp;
                index++;
            } catch (StringLengthException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void throwMyString(MyString myString) throws StringLengthException {
        if (myString.getMyString().length() > 7)
            throw new StringLengthException("Your String is longer than 7 symbols");
    }

    private static void printArrayMyString(MyString[] stringArray) {
        System.out.println("\nYour String Array:");
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(i + " - " + stringArray[i].getMyString());
        }
    }

    private static int setSize() {
        System.out.print("Enter size of the array -> ");
        int arraySize = inputSize();
        while (arraySize <= 0) {
            System.out.print("Size can't be " + arraySize + "\n");
            System.out.print("\nEnter size of the array -> ");
            arraySize = inputSize();
        }
        return arraySize;
    }

    private static int inputSize() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                scanner.next();
                System.err.println("That's not an integer, try again!");
                System.out.print("\nEnter size of the array -> ");
            }
        }
    }
}
