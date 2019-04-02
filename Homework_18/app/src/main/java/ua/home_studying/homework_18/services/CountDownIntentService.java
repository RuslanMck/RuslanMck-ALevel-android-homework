//package ua.home_studying.homework_18.services;
//
//import android.app.IntentService;
//import android.content.Intent;
//
//import android.util.Log;
//
//import static ua.home_studying.homework_18.ControlActivity.RESULT_KEY;
//
//
//public class CountDownIntentService extends IntentService {
//
//    private final String TAG = "101";
//
//    public final static String COUNT_DOWN_ACTION = "ua.home_studying.homework_18.services.CountDownIntentService.Action";
//    public final static String COUNTER_KEY = "KEY";
//
//    public CountDownIntentService() {
//        super("CountDownIntentService");
//    }
//
//    @Override
//    protected void onHandleIntent(Intent intent) {
//        Log.e(TAG, "onHandleIntent: " );
//        try {
//            startCountDown();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void startCountDown() throws InterruptedException {
////        Log.e(TAG, "startCountDown: " );
////        Intent incomeIntent = new Intent();
////
////        int j = 0;
////        int income = incomeIntent.getIntExtra(RESULT_KEY,0);
////        Log.e(TAG, "income" + income );
////        if (income == 0) {
////            j = 1000;
////        } else if (income != 0) {
////            j = income;
////        }
//
//        Log.e(TAG, "startCountDown: " );
//        for (int j = 1000; j > 0 ; j--) {
//            Thread.sleep(500);
//            Intent intent = new Intent();
//            intent.setAction(COUNT_DOWN_ACTION);
//            intent.putExtra(COUNTER_KEY, j);
//            sendBroadcast(intent);
//        }
//    }
//}
