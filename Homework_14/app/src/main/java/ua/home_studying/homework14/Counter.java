package ua.home_studying.homework14;

public class Counter {

    int countLeft = 0;
    int countRight = 0;

    public void countLeft() {
        countLeft++;
    }

    public void contRight() {
        countRight++;
    }

    public String getCountLeft() {
        return String.valueOf(countLeft);
    }

    public String getCountRight() {
        return String.valueOf(countRight);
    }
}
