package ua.home_studying.homework14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Counter counter = new Counter();
    ImagesList imagesList = new ImagesList();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagesList.collectImages();

        final TextView textViewLeft = findViewById(R.id.text_view_left);
        textViewLeft.setText(String.valueOf(counter.getCountLeft()));

        final TextView textViewRight = findViewById(R.id.text_view_right);
        textViewRight.setText(String.valueOf(counter.getCountRight()));

        ImageButton buttonL = findViewById(R.id.button_l);
        ImageButton buttonR = findViewById(R.id.button_r);

        final ImageView imageView = findViewById(R.id.image_view);
        imageView.setImageResource(R.drawable.nature_pic_001);

        View.OnClickListener customCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_l:
                        counter.countLeft();
                        textViewLeft.setText(String.valueOf(counter.getCountLeft()));
                        imageView.setImageResource(imagesList.getPrevImg());
                        break;
                    case R.id.button_r:
                        counter.contRight();
                        textViewRight.setText(String.valueOf(counter.getCountRight()));
                        imageView.setImageResource(imagesList.getNextImg());
                        break;
                }
            }
        };

        if (savedInstanceState != null){
            textViewLeft.setText(savedInstanceState.getString("SavedLeftString"));
            textViewRight.setText(savedInstanceState.getString("SavedRightString"));
            counter.setCountLeft(savedInstanceState.getInt("SavedLeftInt"));
            counter.setCountRight(savedInstanceState.getInt("SavedRightInt"));
            imageView.setImageResource(imagesList.getImg(savedInstanceState.getInt("SavedImage")));
        }
        buttonL.setOnClickListener(customCL);
        buttonR.setOnClickListener(customCL);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("SavedLeftInt", counter.getCountLeft());
        outState.putInt("SavedRightInt", counter.getCountRight());
        outState.putString("SavedLeftString", String.valueOf(counter.getCountLeft()));
        outState.putString("SavedRightString", String.valueOf(counter.getCountRight()));
        outState.putInt("SavedImage", imagesList.getIndex());
    }
}