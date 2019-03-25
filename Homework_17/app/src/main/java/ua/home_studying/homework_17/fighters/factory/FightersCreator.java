package ua.home_studying.homework_17.fighters.factory;

import ua.home_studying.homework_17.fighters.FighterType;
import ua.home_studying.homework_17.fighters.BaseFighter;
import ua.home_studying.homework_17.fighters.FighterCat;

public class FightersCreator implements FightersFactory {

    CatsFactory catsFactory = new CatsFactory();

    @Override
    public BaseFighter createFighter(FighterType fighterType) {
        switch (fighterType){
            case CAT: FighterCat fighterCat = catsFactory.createCatFighter();
            return fighterCat;
        }
        return null;
    }
}
