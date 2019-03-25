package ua.home_studying.homework_17.detail;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ua.home_studying.homework_17.R;

public class DetailActivity extends AppCompatActivity {
    private String TAG = "010";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initFields();

    }

    private void initFields() {
        ImageView avatar = findViewById(R.id.detail_image);
        EditText name = findViewById(R.id.detail_name);
        name.setEnabled(false);
        EditText health = findViewById(R.id.detail_health_field);
        health.setEnabled(false);
        health.setTextColor(Color.BLACK);
        EditText attack = findViewById(R.id.detail_attack_field);
        attack.setEnabled(false);
        attack.setTextColor(Color.BLACK);
        EditText defence = findViewById(R.id.detail_defence_field);
        defence.setEnabled(false);
        defence.setTextColor(Color.BLACK);
        EditText info = findViewById(R.id.detail_info_field);
        info.setEnabled(false);
        info.setTextColor(Color.BLACK);

        Intent intent = getIntent();

        Log.e(TAG, "initFields: " +  intent.getStringExtra("image"));
        Picasso.get().load(intent.getStringExtra("image")).into(avatar);
        name.setText(intent.getStringExtra("name"));
        health.setText(intent.getStringExtra("health"));
        attack.setText(intent.getStringExtra("attack"));
        defence.setText(intent.getStringExtra("defence"));
        info.setText(intent.getIntExtra("info",0));

    }
}
