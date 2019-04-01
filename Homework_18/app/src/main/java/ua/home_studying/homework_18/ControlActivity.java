package ua.home_studying.homework_18;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static ua.home_studying.homework_18.services.CountDownService.COUNT_DOWN_ACTION;

public class ControlActivity extends AppCompatActivity {

    private TextView textViewCount;
    private Button buttonAdd;
    private Button buttonForeground;
    private CountDownBroadcast countDownBroadcast = new CountDownBroadcast();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        initViews();
    }

    private void initViews() {
        textViewCount = findViewById(R.id.text_view_counter);
        textViewCount.setText(getString(R.string.counter_textview, 0));
        buttonAdd = findViewById(R.id.button_start_count);
        buttonAdd.setText(getString(R.string.plus_twenty));
        buttonForeground = findViewById(R.id.button_control);
        buttonForeground.setText(getString(R.string.start_foregfound));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(countDownBroadcast);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(COUNT_DOWN_ACTION);
        registerReceiver(countDownBroadcast,intentFilter);
    }

    private class CountDownBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            int value = intent.getIntExtra("KEY",0);
            textViewCount.setText(getString(R.string.counter_textview, value));
        }
    }
}
