package ua.home_studying.homework_17.fighters.factory;

import ua.home_studying.homework_17.fighters.FighterType;
import ua.home_studying.homework_17.fighters.BaseFighter;

public interface FightersFactory {
    BaseFighter createFighter(FighterType fighterType);
}
