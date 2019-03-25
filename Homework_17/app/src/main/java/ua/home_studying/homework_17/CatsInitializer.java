package ua.home_studying.homework_17;

import ua.home_studying.homework_17.fighters.factory.CatsFactory;

public class CatsInitializer {
    private CatsFactory catsFactory = new CatsFactory();


    public void initialize(int counter){
        for (int i = 0; i < counter; i++){
            CatsList.addToList(catsFactory.createCatFighter());
        }
    }
}
