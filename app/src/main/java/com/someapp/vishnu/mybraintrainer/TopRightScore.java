package com.someapp.vishnu.mybraintrainer;

import android.view.View;
import android.widget.TextView;

public class TopRightScore {

    TextView scoreView;
    String scoreString;
    int answersCorrect;
    int totalQuestions;
    TextView encourager;

    public TopRightScore(View view, View encourage) {

        scoreView = (TextView) view;
        scoreString = scoreView.toString();
        answersCorrect = 0;
        totalQuestions = 0;

        encourager = (TextView) encourage;

    }

    public void update(boolean correct) {

        if(correct) {

            answersCorrect ++;
            encourager.setText("Right :)");

        } else {

            encourager.setText("Wrong :(");

        }
        totalQuestions++;
        scoreString = answersCorrect + "/" + totalQuestions;
        scoreView.setText(scoreString);

    }

    public int getScorePercent() {

        int percent = answersCorrect * 100 / totalQuestions;
        return percent;

    }

    public String toString() {

        return scoreString;

    }

    public void reset() {

        answersCorrect = 0;
        totalQuestions = 0;
        scoreString = answersCorrect + "/" + totalQuestions;
        scoreView.setText(scoreString);

    }

    public void setVisibility(boolean visible) {

        if(visible) {
            scoreView.setVisibility(View.VISIBLE);
        } else {
            scoreView.setVisibility(View.INVISIBLE);
        }

    }

}
