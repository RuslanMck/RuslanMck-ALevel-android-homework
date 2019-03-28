package ua.home_studying.homework_17.fighters.factory;

import ua.home_studying.homework_17.fighters.FighterType;
import ua.home_studying.homework_17.fighters.BaseFighter;
import ua.home_studying.homework_17.fighters.FighterQuake;

public class FightersCreator implements FightersFactory {

    QuakeFactory quakeFactory = new QuakeFactory();

    @Override
    public BaseFighter createFighter(FighterType fighterType) {
        switch (fighterType){
            case CAT: FighterQuake fighterQuake = quakeFactory.createCatFighter();
            return fighterQuake;
        }
        return null;
    }
}
