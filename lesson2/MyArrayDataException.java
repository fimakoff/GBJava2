package lesson2;

import java.util.Scanner;

class MyArrayDataException extends Exception{
    private int i;
    private int j;
    MyArrayDataException(String message, int i, int j) {
        super(message);
        this.i = i;
        this.j = j;
        System.out.println(message + i + ", " + j);
    }

    public String setElement(String [][]arr, int i, int j){
        this.i = i;
        this.j = j;
        Scanner sc = new Scanner(System.in);
        arr[i][j] = sc.next();
        return arr[i][j];
    }
}
