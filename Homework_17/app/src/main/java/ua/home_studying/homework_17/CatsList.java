package ua.home_studying.homework_17;

import java.util.ArrayList;

import ua.home_studying.homework_17.fighters.FighterCat;

public class CatsList {
    private static ArrayList<FighterCat> list;

    static {
        list = new ArrayList<>();
    }

    private CatsList() {

    }

    public static void addToList(FighterCat fighterCat){
        list.add(fighterCat);
    }

    public static ArrayList getList(){
        return list;
    }
}
