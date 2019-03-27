package ua.home_studying.homework_17;

import java.util.ArrayList;

import ua.home_studying.homework_17.fighters.BaseFighter;
import ua.home_studying.homework_17.fighters.FighterQuake;

public class FightersList {
    private static ArrayList<BaseFighter> list;

    static {
        list = new ArrayList<>();
    }

    private FightersList() {

    }

    public static void addToList(FighterQuake fighterQuake){
        list.add(fighterQuake);
    }

    public static ArrayList getList(){
        return list;
    }

    public static BaseFighter getFighter(int index){
        return list.get(index);
    }
}
