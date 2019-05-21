package lesson1.HW.method;

public class Cat implements Moveable {
    private int maxRunLength;
    private int maxJumpHeight;

    @Override
    public void run() {
        System.out.println("Кот бегает");
    }

    @Override
    public void toJump() {
        System.out.println("Кот прыгает");
    }

    public int getMaxRunLength() {
        return maxRunLength;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public Cat(int maxRunLength, int maxJumpHeight) {
        if (maxRunLength > 0)
            this.maxRunLength = maxRunLength;
        if (maxJumpHeight > 0)
            this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public String toString() {

        return "Cat (run: " + getMaxRunLength() + " jump: " + getMaxJumpHeight() + ")";
    }


}
