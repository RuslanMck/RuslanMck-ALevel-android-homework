package ua.home_studying.homework_17.fighters.factory;

import ua.home_studying.homework_17.randomizers.BoundedRandomInt;
import ua.home_studying.homework_17.randomizers.RandomDrawable;
import ua.home_studying.homework_17.randomizers.RandomInfo;
import ua.home_studying.homework_17.randomizers.RandomName;
import ua.home_studying.homework_17.fighters.FighterQuake;

public class QuakeFactory {

    private BoundedRandomInt randomInt = new BoundedRandomInt();
    private RandomName randomName = new RandomName();
    private RandomDrawable randomDrawable = new RandomDrawable();
    private RandomInfo randomInfo = new RandomInfo();


    public FighterQuake createCatFighter() {
        return new FighterQuake(randomName.setRandomName(), randomDrawable.getRandomDrawable(), randomInfo.getRandomInfo(), randomInt.generate(100, 120),
                randomInt.generate(8, 15), randomInt.generate(0, 3));
    }
}
