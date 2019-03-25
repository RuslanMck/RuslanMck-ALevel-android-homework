package ua.home_studying.homework_17;

import java.util.ArrayList;

import ua.home_studying.homework_17.fighters.FighterQuake;

public class CatsList {
    private static ArrayList<FighterQuake> list;

    static {
        list = new ArrayList<>();
    }

    private CatsList() {

    }

    public static void addToList(FighterQuake fighterQuake){
        list.add(fighterQuake);
    }

    public static ArrayList getList(){
        return list;
    }
}
