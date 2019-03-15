package ua.home_studying.homework14;

public class Counter {

    int countLeft;
    int countRight;

    public void countLeft() {
        countLeft++;
    }

    public void contRight() {
        countRight++;
    }

    public int getCountLeft() {
        return countLeft;
    }

    public void setCountLeft(int countLeft) {
        this.countLeft = countLeft;
    }

    public void setCountRight(int countRight) {
        this.countRight = countRight;
    }

    public int getCountRight() {
        return countRight;
    }
}
