package lesson1.HW.Sportsmans;

public class Human implements Moveable {
    private int maxRunLength;
    private int maxJumpHeight;

    public Human(int maxRunLength, int maxJumpHeight) {
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public void run(int length) {

    }

    @Override
    public void toJump(int height) {

    }

    @Override
    public boolean onDistance() {



        return false;
    }

    @Override
    public void showInfo() {

    }
}
