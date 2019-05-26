package lesson1.HW.hurdles;

public class Wall {
    private int height;
    private int count;

    public Wall(int height, int count) {
        this.count = count;
        this.height = height;
        System.out.println("Количество барьеров: " + count);
        System.out.println("Высота барьера: " + height);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Height Wall: " + height;
    }
}
