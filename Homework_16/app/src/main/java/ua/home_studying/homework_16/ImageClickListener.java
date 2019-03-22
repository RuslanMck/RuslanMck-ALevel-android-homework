package ua.home_studying.homework_16;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

public class ImageClickListener implements View.OnClickListener {

    private Context context;
    private ArrayList<ImageItem> imagesList;
    private int i;

    public ImageClickListener(Context context, ArrayList<ImageItem> imagesList, int i) {
        this.context = context;
        this.imagesList = imagesList;
        this.i = i;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, SingleImageActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("image",imagesList.get(i).getImageLink());
        context.startActivity(intent);
    }
}
