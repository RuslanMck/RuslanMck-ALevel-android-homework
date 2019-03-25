package ua.home_studying.homework_17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        ArrayList fighters = CatsList.getList();
        RecyclerView recyclerView = findViewById(R.id.recycler_vew);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        CustomAdapter customAdapter = new CustomAdapter(fighters,getApplicationContext());
        recyclerView.setAdapter(customAdapter);
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
        catsInitializer.initialize(5);
    }
}
