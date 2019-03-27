package ua.home_studying.homework_17.detail;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ua.home_studying.homework_17.FightActivity;
import ua.home_studying.homework_17.FightersList;
import ua.home_studying.homework_17.MainActivity;
import ua.home_studying.homework_17.R;
import ua.home_studying.homework_17.fighters.FighterQuake;

public class DetailActivity extends AppCompatActivity {
    Spinner spinner;
    EditText name;
    EditText health;
    EditText attack;
    EditText defence;
    EditText info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initFields();
//        setButtonBack();
        setButtonAdd();
        setSpinner();
        startFight();

    }

    private void setSpinner() {
        Intent intent = getIntent();
        spinner = findViewById(R.id.detail_spinner);
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < FightersList.getList().size(); i++) {
            if (!FightersList.getFighter(i).getName().equals(intent.getStringExtra("name"))) {
                names.add(FightersList.getFighter(i).getName());
            }
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, names);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }

    private void setButtonAdd() {
        Button addButton = findViewById(R.id.detail_add_avatar);
        addButton.setVisibility(View.INVISIBLE);
    }

    private void setButtonBack() {
        Button buttonBack = findViewById(R.id.detail_button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initFields() {
        ImageView avatar = findViewById(R.id.detail_image);
        name = findViewById(R.id.detail_name);
        name.setEnabled(false);
         health = findViewById(R.id.detail_health_field);
        health.setEnabled(false);
        health.setTextColor(Color.BLACK);
        attack = findViewById(R.id.detail_attack_field);
        attack.setEnabled(false);
        attack.setTextColor(Color.BLACK);
        defence = findViewById(R.id.detail_defence_field);
        defence.setEnabled(false);
        defence.setTextColor(Color.BLACK);
        info = findViewById(R.id.detail_info_field);
        info.setEnabled(false);
        info.setTextColor(Color.BLACK);


        Intent intent = getIntent();
        Picasso.get().load(intent.getStringExtra("image")).into(avatar);
        name.setText(intent.getStringExtra("name"));
        health.setText(intent.getStringExtra("health"));
        attack.setText(intent.getStringExtra("attack"));
        defence.setText(intent.getStringExtra("defence"));
        info.setText(intent.getIntExtra("info", 0));

    }

    private void startFight() {
        Button startButton = findViewById(R.id.detail_start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewFighter();
                Intent intent = new Intent(DetailActivity.this, FightActivity.class);
                intent.putExtra("opponentOne", String.valueOf(spinner.getSelectedItem()));
                intent.putExtra("opponentTwo", String.valueOf(name.getText()));

                startActivity(intent);
            }
        });

    }

    private void addNewFighter() {

        String mName = String.valueOf(name.getText());
        String mImage = String.valueOf(info.getText());
        int mHealth = Integer.parseInt(String.valueOf(health.getText()));
        int mAttack = Integer.parseInt(String.valueOf(attack.getText()));
        int mDefence = Integer.parseInt(String.valueOf(defence.getText()));

        FightersList.addToList(new FighterQuake(mName, mImage, 0, mHealth, mAttack, mDefence));
    }
}
