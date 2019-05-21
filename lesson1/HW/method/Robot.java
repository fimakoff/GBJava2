package lesson1.HW.method;

public class Robot implements Moveable {
    private int maxRunLength;
    private int maxJumpHeight;

    @Override
    public void run() {
        System.out.println("Робот бегает");
    }

    @Override
    public void toJump() {
        System.out.println("Робот прыгает");
    }
    public int getMaxRunLength() {
        return maxRunLength;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public Robot(int maxRunLength, int maxJumpHeight) {
        if (maxRunLength > 0)
            this.maxRunLength = maxRunLength;
        if (maxJumpHeight > 0)
            this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public String toString() {

        return "Robot (run: " + getMaxRunLength() + " jump: " + getMaxJumpHeight() + ")\n";
    }
}
