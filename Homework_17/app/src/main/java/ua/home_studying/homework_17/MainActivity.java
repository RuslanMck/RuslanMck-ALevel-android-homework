package ua.home_studying.homework_17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import ua.home_studying.homework_17.fighters.factory.CatsFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButton();
        initFighters();


    }

    private void initButton() {
        Button button = findViewById(R.id.button_add_cat);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initFighters() {
        CatsInitializer catsInitializer = new CatsInitializer();
        catsInitializer.initialize(3);
    }


}
