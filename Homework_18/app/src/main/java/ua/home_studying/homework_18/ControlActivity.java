package ua.home_studying.homework_18;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ua.home_studying.homework_18.services.CountDownService;

import static ua.home_studying.homework_18.services.CountDownService.COUNT_DOWN_ACTION;


public class ControlActivity extends AppCompatActivity {

    private Messenger messenger = null;
    private boolean isConnected;

    private final String TAG = "101";
    private TextView textViewCount;
    private Button buttonAdd;
    private Button buttonForeground;
    private int value;
    public static final String RESULT_KEY = "result";
    private CountDownBroadcast countDownBroadcast = new CountDownBroadcast();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        initViews();
        setListeners();
    }

    private void setListeners() {
        buttonAdd.setOnClickListener(this::plusTwentyListener);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            isConnected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            messenger = null;
            isConnected = false;
        }
    };

    private void plusTwentyListener(View view) {
        Log.e(TAG, "plusTwentyListener: " + value );
        int result = value + 20;
        Intent intent = new Intent(this, CountDownService.class);
        Log.e(TAG, "result " + result);
        intent.putExtra(RESULT_KEY, result);
        startService(intent);

        Message message = Message.obtain(null, CountDownService.PLUS_TWENTY,0,0);
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
            value = intent.getIntExtra("KEY",0);
            textViewCount.setText(getString(R.string.counter_textview, value));
        }
    }
}
