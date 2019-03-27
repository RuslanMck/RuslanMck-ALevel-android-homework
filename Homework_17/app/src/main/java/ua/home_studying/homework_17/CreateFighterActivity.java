package ua.home_studying.homework_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ua.home_studying.homework_17.fighters.FighterQuake;

public class CreateFighterActivity extends AppCompatActivity {

    private final String TAG = "101";
    Spinner spinner;
    EditText name;
    EditText heath;
    EditText attack;
    EditText defence;
    EditText info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_fighter);

        setSpinner();
        setButtonBack();
        initFields();
        startFight();

    }


    private void initFields() {
        name = findViewById(R.id.detail_name);
        heath = findViewById(R.id.detail_health_field);
        attack = findViewById(R.id.detail_attack_field);
        defence = findViewById(R.id.detail_defence_field);
        info = findViewById(R.id.detail_info_field);
        final ImageView avatar = findViewById(R.id.detail_image);
        final Button add = findViewById(R.id.detail_add_avatar);


        Log.e(TAG, "initFields: " + FightersList.getList().size());
        add.setEnabled(false);
        info.setHint(R.string.info_hint);

        info.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                add.setEnabled(true);
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addNewFighter();
                        Picasso.get().load(info.getText().toString()).into(avatar);

                        Log.e(TAG, "initFields: " + FightersList.getList().size());
                    }
                });
            }
        });
    }

    private void addNewFighter() {
        String mName = String.valueOf(name.getText());
        String mImage = String.valueOf(info.getText());
        int mHealth = Integer.parseInt(String.valueOf(heath.getText()));
        int mAttack = Integer.parseInt(String.valueOf(attack.getText()));
        int mDefence = Integer.parseInt(String.valueOf(defence.getText()));

        FightersList.addToList(new FighterQuake(mName, mImage, 0, mHealth, mAttack, mDefence));
    }

    private void setSpinner() {
        spinner = findViewById(R.id.detail_spinner);
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < FightersList.getList().size(); i++) {
            names.add(FightersList.getFighter(i).getName());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, names);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);


    }

    private void setButtonBack() {
        Button buttonBack = findViewById(R.id.detail_button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateFighterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void startFight() {
        Button startButton = findViewById(R.id.detail_start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewFighter();
                Intent intent = new Intent(CreateFighterActivity.this, FightActivity.class);
                intent.putExtra("opponentOne", String.valueOf(spinner.getSelectedItem()));
                Log.e(TAG, "startFight()" + String.valueOf(spinner.getSelectedItem()));
                intent.putExtra("opponentTwo", String.valueOf(name.getText()));
                Log.e(TAG, "startFight() " + String.valueOf(name.getText()));
                startActivity(intent);
            }
        });

    }
}

