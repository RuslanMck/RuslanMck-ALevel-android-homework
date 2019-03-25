package ua.home_studying.homework_17.randomizers;

import java.util.ArrayList;

import ua.home_studying.homework_17.R;

public class RandomDrawable {
    private ArrayList<String> drawable = new ArrayList<>();
    private BoundedRandomInt randomInt = new BoundedRandomInt();

    public RandomDrawable() {
        drawable.add("http://avatars.mitosa.net/quake/087.jpg");
        drawable.add("http://avatars.mitosa.net/quake/083.jpg");
        drawable.add("http://avatars.mitosa.net/quake/077.jpg");
        drawable.add("http://avatars.mitosa.net/quake/082.jpg");
        drawable.add("http://avatars.mitosa.net/quake/069.jpg");
        drawable.add("http://avatars.mitosa.net/quake/063.jpg");
        drawable.add("http://avatars.mitosa.net/quake/068.jpg");
        drawable.add("http://avatars.mitosa.net/quake/055.jpg");
        drawable.add("http://avatars.mitosa.net/quake/051.jpg");
        drawable.add("http://avatars.mitosa.net/quake/042.jpg");
        drawable.add("http://avatars.mitosa.net/quake/044.jpg");
        drawable.add("http://avatars.mitosa.net/quake/037.jpg");
        drawable.add("http://avatars.mitosa.net/quake/031.jpg");
        drawable.add("http://avatars.mitosa.net/quake/026.jpg");
        drawable.add("http://avatars.mitosa.net/quake/014.jpg");
        drawable.add("http://avatars.mitosa.net/quake/004.jpg");
        drawable.add("http://avatars.mitosa.net/quake/001.jpg");
        drawable.add("http://avatars.mitosa.net/quake/0.jpg");
        drawable.add("http://avatars.mitosa.net/quake/003.jpg");
        drawable.add("http://avatars.mitosa.net/quake/061.jpg");
        drawable.add("http://avatars.mitosa.net/quake/049.jpg");
        drawable.add("http://avatars.mitosa.net/quake/066.jpg");
        drawable.add("http://avatars.mitosa.net/quake/071.jpg");
        drawable.add("http://avatars.mitosa.net/quake/064.jpg");
    }

    public ArrayList<String> getDrawable() {
        return drawable;
    }

    public String getRandomDrawable(){
        return drawable.get(randomInt.generate(0,drawable.size()));
    }
}
