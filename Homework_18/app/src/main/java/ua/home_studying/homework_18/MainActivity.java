package ua.home_studying.homework_18;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ua.home_studying.homework_18.services.CountDownService;

import static ua.home_studying.homework_18.services.CountDownService.COUNT_DOWN_ACTION;


public class MainActivity extends AppCompatActivity {

    private CountDownBroadcast countDownBroadcast = new CountDownBroadcast();
    private TextView textViewCounter;
    private Button buttonStart;
    private Button buttonControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setListeners();
    }

    private void setListeners() {
        buttonStart.setOnClickListener(this::startCount);
        buttonControl.setOnClickListener(this::startControl);
    }

    private void startControl(View view) {
        Intent intent = new Intent(this, ControlActivity.class);
        startActivity(intent);
    }

    private void startCount(View view) {
        Intent intent = new Intent(this, CountDownService.class);
        startService(intent);
        buttonControl.setVisibility(View.VISIBLE);
    }

    private void initViews() {
        textViewCounter = findViewById(R.id.text_view_counter);
        buttonStart = findViewById(R.id.button_start_count);
        buttonControl = findViewById(R.id.button_control);
        buttonControl.setVisibility(View.GONE);
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
        registerReceiver(countDownBroadcast, intentFilter);
    }

    private class CountDownBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int value = intent.getIntExtra("KEY",0);
            textViewCounter.setText(getString(R.string.counter_textview, value));
        }
    }
}
