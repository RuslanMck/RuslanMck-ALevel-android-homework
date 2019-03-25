package ua.home_studying.homework_17.randomizers;

import java.util.ArrayList;

import ua.home_studying.homework_17.R;

public class RandomInfo {
    private ArrayList<Integer> info = new ArrayList<Integer>();
    private BoundedRandomInt randomInt = new BoundedRandomInt();

    public RandomInfo() {
        info.add(R.string.info01);
        info.add(R.string.info02);
        info.add(R.string.info03);
        info.add(R.string.info04);
        info.add(R.string.info05);
        info.add(R.string.info06);
        info.add(R.string.info07);
    }

    public Integer getRandomInfo() {
        return info.get(randomInt.generate(0, info.size()));
    }
}
