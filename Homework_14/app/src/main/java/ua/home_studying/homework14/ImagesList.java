package ua.home_studying.homework14;

import java.util.LinkedList;

public class ImagesList {

    LinkedList<Integer> images = new LinkedList<>();
    int index = 0;

    public void collectImages(){
        images.add(R.drawable.nature_pic_001);
        images.add(R.drawable.nature_pic_002);
        images.add(R.drawable.nature_pic_003);
        images.add(R.drawable.nature_pic_004);
        images.add(R.drawable.nature_pic_005);
    }

    public int getNextImg(){
        index++;
        if (index >= images.size()) index = 0;
        int result = images.get(index);
        return result;
    }

    public int getPrevImg(){
        index--;
        if (index < 0) index = images.size() -1;
        int result = images.get(index);
        return result;
    }

    public int getIndex() {
        return index;
    }

    public int getImg(int i){
        return images.get(i);
    }
}