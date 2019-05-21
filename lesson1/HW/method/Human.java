package lesson1.HW.method;

public class Human implements Moveable {
    private int maxRunLength;
    private int maxJumpHeight;

    @Override
    public void run() {
        System.out.println("Человек бегает");
    }

    @Override
    public void toJump() {
        System.out.println("Человек прыгает");
    }
    public int getMaxRunLength() {
        return maxRunLength;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public Human(int maxRunLength, int maxJumpHeight) {
        if (maxRunLength > 0)
            this.maxRunLength = maxRunLength;
        if (maxJumpHeight > 0)
            this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public String toString() {

        return "Human (run: " + getMaxRunLength() + " jump: " + getMaxJumpHeight() + ")\n";
    }
}
