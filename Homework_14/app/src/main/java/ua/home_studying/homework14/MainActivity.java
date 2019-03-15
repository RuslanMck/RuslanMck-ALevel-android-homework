package ua.home_studying.homework14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Counter counter = new Counter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textViewLeft = findViewById(R.id.text_view_left);
        textViewLeft.setText(counter.getCountLeft());

        final TextView textViewRight = findViewById(R.id.text_view_right);
        textViewRight.setText(counter.getCountRight());

        ImageButton buttonL = findViewById(R.id.button_l);
        ImageButton buttonR = findViewById(R.id.button_r);

        View.OnClickListener customCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_l:
                        counter.countLeft();
                        textViewLeft.setText(counter.getCountLeft());
                        break;
                    case R.id.button_r:
                        counter.contRight();
                        textViewRight.setText(counter.getCountRight());
                        break;
                }
            }
        };
        buttonL.setOnClickListener(customCL);
        buttonR.setOnClickListener(customCL);
    }


}
