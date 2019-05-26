package lesson2;

class MyArrayDataException extends Exception{
    MyArrayDataException(String message, int i, int j) {
        super(message);

        System.out.println(message + i + ", " + j);
    }
}
