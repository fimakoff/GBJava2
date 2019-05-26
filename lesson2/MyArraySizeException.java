package lesson2;

class MyArraySizeException extends Exception{
    MyArraySizeException(String message) {
        super(message);
        System.out.println("Размер массива не соответствует необходимому");
    }
}
