package ua.home_studying.homework_16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SingleImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_image_activity);

        Intent intent = getIntent();
        String res = intent.getStringExtra("image");

        ImageView imageView = findViewById(R.id.single_image_view);
        Picasso.get().load(res).into(imageView);
    }
}
