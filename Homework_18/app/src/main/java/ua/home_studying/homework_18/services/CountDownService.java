package ua.home_studying.homework_18.services;

import android.app.IntentService;
import android.content.Intent;

public class CountDownService extends IntentService {

    public final static String COUNT_DOWN_ACTION = "ua.home_studying.homework_18.services.CountDownService.Action";
    public final static String COUNTER_KEY = "KEY";

    public CountDownService() {
        super("CountDownService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            startCountDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startCountDown() throws InterruptedException {
        for (int j = 1000; j > 0 ; j--) {
            Thread.sleep(500);
            Intent intent = new Intent();
            intent.setAction(COUNT_DOWN_ACTION);
            intent.putExtra(COUNTER_KEY, j);
            sendBroadcast(intent);
        }
    }
}
