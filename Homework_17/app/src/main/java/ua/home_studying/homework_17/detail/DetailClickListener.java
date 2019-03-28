package ua.home_studying.homework_17.detail;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import ua.home_studying.homework_17.fighters.BaseFighter;

public class DetailClickListener implements View.OnClickListener {

    private String TAG = "010";
    private Context context;
    private int index;
    private ArrayList<BaseFighter> fighters;

    public DetailClickListener(Context context, int index, ArrayList<BaseFighter> fighters) {
        this.context = context;
        this.index = index;
        this.fighters = fighters;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("name", fighters.get(index).getName());
        intent.putExtra("health", String.valueOf(fighters.get(index).getHealth()));
        intent.putExtra("attack", String.valueOf(fighters.get(index).getAttack()));
        intent.putExtra("defence", String.valueOf(fighters.get(index).getDefence()));
        intent.putExtra("info", fighters.get(index).getInfo());
        Log.e(TAG, "onClick: " + fighters.get(index).getInfo());
        intent.putExtra("image", String.valueOf(fighters.get(index).getImgLink()));
        context.startActivity(intent);
    }
}
