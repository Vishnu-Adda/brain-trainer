package com.someapp.vishnu.mybraintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AnswerManager answerManager;
    Equation equation;
    TopLeftTimer topLeftTimer;
    TopRightScore topRightScore;

    TextView encourageText;
    Button playButton;

    public void playGame(View view) {

        Log.i("Info", "Go clicked");

        view.setVisibility(View.GONE);

        equation.setVisibility(true);
        answerManager.setVisibility(true);
        topLeftTimer.setVisibility(true);
        topRightScore.setVisibility(true);
        encourageText.setVisibility(View.VISIBLE);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisecondsUntilDone) {

                Log.i("Seconds Left!", String.valueOf(millisecondsUntilDone/1000));
                topLeftTimer.update(millisecondsUntilDone);

            }

            public void onFinish() {

                Log.i("We're done", "No more countdown");

                String encourageString = "You scored " +
                        Integer.toString(topRightScore.getScorePercent()) + "%";

                encourageText.setText(encourageString);

                playButton.setVisibility(View.VISIBLE);

                answerManager.freeze();

            }

        }.start();

    }

    public void answerClick(View view) {

        int tag = Integer.parseInt(view.getTag().toString());

        answerManager.answerClickManage(tag);

        equation.update();
        answerManager.setAnswers();

    }

    public void reset(View view) {

        playButton.setVisibility(View.INVISIBLE);

        equation.update();
        answerManager.setAnswers();

        encourageText.setText("");

        topRightScore.reset();
        answerManager.unFreeze();

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisecondsUntilDone) {

                Log.i("Seconds Left!", String.valueOf(millisecondsUntilDone/1000));
                topLeftTimer.update(millisecondsUntilDone);

            }

            public void onFinish() {

                Log.i("We're done", "No more countdown");

                String encourageString = "You scored " +
                        Integer.toString(topRightScore.getScorePercent()) + "%";

                encourageText.setText(encourageString);

                playButton.setVisibility(View.VISIBLE);

                answerManager.freeze();

            }

        }.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equation = new Equation(findViewById(R.id.equationTextView));

        encourageText = findViewById(R.id.descriptionTextView);
        playButton = findViewById(R.id.buttonDone);

        topLeftTimer = new TopLeftTimer(findViewById(R.id.timerTextView));
        topRightScore = new TopRightScore(findViewById(R.id.scoreTextView), encourageText);

        answerManager = new AnswerManager(findViewById(R.id.buttonAnswer1),
                findViewById(R.id.buttonAnswer2),
                findViewById(R.id.buttonAnswer3),
                findViewById(R.id.buttonAnswer4),
                equation, topRightScore);

        equation.setVisibility(false);
        answerManager.setVisibility(false);
        topLeftTimer.setVisibility(false);
        topRightScore.setVisibility(false);
        encourageText.setVisibility(View.INVISIBLE);
        playButton.setVisibility(View.INVISIBLE);

        answerManager.setAnswers();

    }
}
