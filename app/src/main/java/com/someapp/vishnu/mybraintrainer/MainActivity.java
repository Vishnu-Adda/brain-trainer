package com.someapp.vishnu.mybraintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AnswerManager answerManager;
    Equation equation;
    TopLeftTimer topLeftTimer;
    TopRightScore topRightScore;

    public void playGame(View view) {

        Log.i("Info", "Go clicked");

//        equation = new Equation(findViewById(R.id.equationTextView));
//
//        answerManager = new AnswerManager(findViewById(R.id.buttonAnswer1),
//                                            findViewById(R.id.buttonAnswer1),
//                                            findViewById(R.id.buttonAnswer1),
//                                            findViewById(R.id.buttonAnswer1),
//                                            equation);

        view.setVisibility(View.GONE);

        equation.setVisiblity(true);
        answerManager.setVisibility(true);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisecondsUntilDone) {

                Log.i("Seconds Left!", String.valueOf(millisecondsUntilDone/1000));

            }

            public void onFinish() {

                Log.i("We're done", "No more countdown");

            }

        }.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equation = new Equation(findViewById(R.id.equationTextView));

//        findViewById(R.id.equationTextView).setVisibility(View.INVISIBLE);

        answerManager = new AnswerManager(findViewById(R.id.buttonAnswer1),
                findViewById(R.id.buttonAnswer2),
                findViewById(R.id.buttonAnswer3),
                findViewById(R.id.buttonAnswer4),
                equation);

        equation.setVisiblity(false);
        answerManager.setVisibility(false);


    }
}
