package ua.home_studying.homework_17.fighters.factory;

import ua.home_studying.homework_17.randomizers.BoundedRandomInt;
import ua.home_studying.homework_17.randomizers.RandomName;
import ua.home_studying.homework_17.fighters.FighterCat;

public class CatsFactory {

    private BoundedRandomInt randomInt = new BoundedRandomInt();
    private RandomName randomName = new RandomName();


    public FighterCat createCatFighter(){
        return new FighterCat(randomName.setRandomName(),randomInt.generate(100,120),
                randomInt.generate(8,15),randomInt.generate(0,3));
    }
}
