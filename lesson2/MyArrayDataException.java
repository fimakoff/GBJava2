package lesson2;

import java.util.Scanner;

class MyArrayDataException extends Exception{
    private Scanner sc = new Scanner(System.in);
    MyArrayDataException(String message, int i, int j, String[][]arr) {
        super(message);
        System.out.println(message + i + ", " + j);
        System.out.print("Введите корретное значение: ");
        arr[i][j] = sc.next();
    }
}
