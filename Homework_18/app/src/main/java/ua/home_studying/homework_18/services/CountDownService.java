package ua.home_studying.homework_18.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;


public class CountDownService extends Service {

    public final static String COUNT_DOWN_ACTION = "ua.home_studying.homework_18.services.CountDownIntentService.Action";
    public final static String COUNTER_KEY = "KEY";
    public static final int PLUS_TWENTY = 20;
    public static final int EMPTY_COUNTER = 0;
    int value;

    private Looper serviceLooper;
    private ServiceHandler serviceHandler;
    Messenger messenger;
    int j;

    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case PLUS_TWENTY:
                    try {
                        startCountDown(j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    stopSelf(msg.arg1);
                    break;
                case EMPTY_COUNTER:
                    try {
                        startCountDown(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    stopSelf(msg.arg1);
                    break;
                default:
                    super.handleMessage(msg);

            }
        }
    }


    @Override
    public void onCreate() {
        HandlerThread handlerThread = new HandlerThread("handlerThread", Process.THREAD_PRIORITY_BACKGROUND);
        handlerThread.start();

        serviceLooper = handlerThread.getLooper();
        serviceHandler = new ServiceHandler(serviceLooper);
        messenger = new Messenger(new ServiceHandler(serviceLooper));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Message message = serviceHandler.obtainMessage();
        value = intent.getIntExtra("result", 0);
        if (value == 0) {
            message.arg1 = EMPTY_COUNTER;
        } else {
            message.arg1 = PLUS_TWENTY;
        }
        serviceHandler.sendMessage(message);
        return START_STICKY;
    }

    private void startCountDown(int j) throws InterruptedException {
        for (; j > 0; j--) {
            Thread.sleep(500);
            Intent intent = new Intent();
            intent.setAction(COUNT_DOWN_ACTION);
            intent.putExtra(COUNTER_KEY, j);
            sendBroadcast(intent);
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }
}
