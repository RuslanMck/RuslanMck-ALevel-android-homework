package ua.home_studying.homework15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int choice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRadioButtons();
        setSelectButton();

    }

    private void setRadioButtons() {
        View.OnClickListener radioListener = radioListener();

        RadioButton rBBengal = findViewById(R.id.radio_bengal);
        rBBengal.setOnClickListener(radioListener);

        RadioButton rBPersian = findViewById(R.id.radio_persian);
        rBPersian.setOnClickListener(radioListener);

        RadioButton rBSiamese = findViewById(R.id.radio_siamese);
        rBSiamese.setOnClickListener(radioListener);

        RadioButton rBTurkish = findViewById(R.id.radio_turkish);
        rBTurkish.setOnClickListener(radioListener);
    }

    private void setSelectButton() {
        View.OnClickListener selectListener = selectListener();
        Button selectButton = findViewById(R.id.button_select);
        selectButton.setOnClickListener(selectListener);

    }

    private View.OnClickListener radioListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton) v;
                switch (rb.getId()) {
                    case (R.id.radio_bengal):
                        choice = 1;
                        break;
                    case (R.id.radio_persian):
                        choice = 2;
                        break;
                    case (R.id.radio_siamese):
                        choice = 3;
                        break;
                    case (R.id.radio_turkish):
                        choice = 4;
                        break;
                    default:
                        break;
                }
            }
        };
    }

    private View.OnClickListener selectListener() {
        final TextView tv = findViewById(R.id.textView_header);
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (choice) {
                    case (1):
                        tv.setText("bengal");
                        break;
                    case (2):
                        tv.setText("persian");
                        break;
                    case (3):
                        tv.setText("siamese");
                        break;
                    case (4):
                        tv.setText("turkish");
                        break;
                    default:
                        break;
                }
            }
        };
    }
}