package ua.home_studying.homework_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ua.home_studying.homework_17.fighters.BaseFighter;

public class FightActivity extends AppCompatActivity {
    private final String TAG = "500";

    TextView opponentOnePunches;
    TextView opponentTowPunches;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        opponentOnePunches = findViewById(R.id.fight_1st_fighter_result);
        opponentTowPunches = findViewById(R.id.fight_2nd_fighter_result);
        result = findViewById(R.id.fight_result);


        Intent intent = getIntent();

        String opponentOneName = intent.getStringExtra("opponentOne");
        String opponentTwoName = intent.getStringExtra("opponentTwo");

        opponentOnePunches.setText(opponentOneName);
        opponentTowPunches.setText(opponentTwoName);

        BaseFighter opponentOne = getFighter(opponentOneName);
        BaseFighter opponentTwo = getFighter(opponentTwoName);

        TextView oneName = findViewById(R.id.fight_1st_fighter_name);
        TextView towName = findViewById(R.id.fight_2nd_fighter_name);
        ImageView opponentOneAvatar = findViewById(R.id.fight_1st_fighter_icon);
        ImageView opponentTwoAvatar = findViewById(R.id.fight_2nd_fighter_icon);

        oneName.setText(opponentOne.getName());
        towName.setText(opponentTwo.getName());
        Picasso.get().load(opponentOne.getImgLink()).into(opponentOneAvatar);
        Picasso.get().load(opponentTwo.getImgLink()).into(opponentTwoAvatar);

        attack(opponentOne, opponentTwo);
    }

    private BaseFighter getFighter(String name) {
        Log.e(TAG, "getFighter: " );
        for (int i = 0; i < FightersList.getList().size(); i++) {
            BaseFighter fighter = FightersList.getFighter(i);
            if (name.equals(fighter.getName())) {
                return fighter;
            }
        }
        return null;
    }

    private void attack(final BaseFighter opponentOne, final BaseFighter opponentTwo) {

        Log.e(TAG, "attack: " );


        Thread t = new Thread() {
            @Override
            public void run() {
                while (opponentOne.getHealth() > opponentTwo.getAttack() && opponentTwo.getHealth() > opponentOne.getAttack()) {
                    firstPunch();
                    secondPunch();
                    checkForResult();
                }
            }

            private void checkForResult() {
                Log.e(TAG, "checkForResult: " );
                if (opponentOne.getHealth() <= opponentTwo.getAttack()) {
                    opponentOnePunches.setVisibility(View.INVISIBLE);
                    opponentTowPunches.setVisibility(View.INVISIBLE);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            result.setText(String.format("%s %s", opponentTwo.getName(), getString(R.string.won)));
                        }
                    });
                }

                if (opponentTwo.getHealth() <= opponentOne.getAttack()) {
                    opponentOnePunches.setVisibility(View.INVISIBLE);
                    opponentTowPunches.setVisibility(View.INVISIBLE);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            result.setText(String.format("%s %s", opponentOne.getName(), getString(R.string.won)));
                        }
                    });
                }
            }

            private void secondPunch() {
                Log.e(TAG, "secondPunch: " );
                try {
                    Thread.sleep(1000);
                    opponentOne.setHealth(opponentOne.getHealth() - opponentTwo.getAttack());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            opponentOnePunches.setText(String.format("received %s dmg \n %s hp", opponentTwo.getAttack(), opponentOne.getHealth()));
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            private void firstPunch() {
                Log.e(TAG, "firstPunch: " );

                try {
                    Thread.sleep(1000);
                    opponentTwo.setHealth(opponentTwo.getHealth() - opponentOne.getAttack());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            opponentTowPunches.setText(String.format("received %s dmg \n %s hp", opponentOne.getAttack(), opponentTwo.getHealth()));
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
