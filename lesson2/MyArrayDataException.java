package lesson2;

class MyArrayDataException extends Exception {
    private int i;
    private int j;

    MyArrayDataException(String message, int i, int j) {
        super(message);
        this.i = i;
        this.j = j;
        System.out.println(message + i + ", " + j);
    }

    int getI() {
        return i;
    }

    int getJ() {
        return j;
    }
}
