package ua.home_studying.homework12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView bottomTV = findViewById(R.id.bottomTV);
        bottomTV.setText("Hardcoded text");

        final TextView topTV = findViewById(R.id.topTV);

        Button button = findViewById(R.id.button);

        View.OnClickListener customListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topTV.setText(R.string.good_day);
            }
        };
        button.setOnClickListener(customListener);
    }
}
