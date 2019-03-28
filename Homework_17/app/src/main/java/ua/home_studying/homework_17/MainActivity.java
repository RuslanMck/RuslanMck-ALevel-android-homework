package ua.home_studying.homework_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButton();
        initFighters();
        initRecyclerView();

    }

    private void initRecyclerView() {
        ArrayList fighters = FightersList.getList();
        RecyclerView recyclerView = findViewById(R.id.recycler_vew);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        CustomAdapter customAdapter = new CustomAdapter(fighters,getApplicationContext());
        recyclerView.setAdapter(customAdapter);
    }

    private void initButton() {
        Button addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateFighterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initFighters() {
        FightersInitializer fightersInitializer = new FightersInitializer();
        fightersInitializer.initialize(10);
    }
}
