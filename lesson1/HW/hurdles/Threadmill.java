package lesson1.HW.hurdles;

public class Threadmill {
    private int length;
    private int count;
    public Threadmill(int length, int count) {
        this.count = count;
        this.length = length;
        System.out.println("Количество дорожек: " + count);
        System.out.println("Длина дорожки: " + length);
    }

    Threadmill[] threadmills = new Threadmill[count];



    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Length of threadmill: " + length;
    }
}
