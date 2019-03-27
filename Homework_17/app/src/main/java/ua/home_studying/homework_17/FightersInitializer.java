package ua.home_studying.homework_17;

import ua.home_studying.homework_17.fighters.factory.QuakeFactory;

public class FightersInitializer {
    private QuakeFactory quakeFactory = new QuakeFactory();


    public void initialize(int counter){
        for (int i = 0; i < counter; i++){
            FightersList.addToList(quakeFactory.createCatFighter());
        }
    }
}
