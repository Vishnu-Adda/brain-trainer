package com.someapp.vishnu.mybraintrainer;

import android.view.View;
import android.widget.Button;

public class Answer {

    Button answerButton;

    boolean isAnswer;

    int answer;

    public Answer(View view) {

        answerButton = (Button) view;

    }

    public void setAnswerTruth(boolean answerBool) {

        isAnswer = answerBool;

    }

    public void setAnswer(int theAnswer) {

        answer = theAnswer;
        setText();

    }

    public void setText() {

        answerButton.setText(Integer.toString(answer));

    }

    public void setVisibility(boolean visible) {

        if (visible) {
            answerButton.setVisibility(View.VISIBLE);
        } else {
            answerButton.setVisibility(View.INVISIBLE);
        }

    }

    public void setClickable(boolean clickable) {

        if(clickable) {
            answerButton.setEnabled(true);
        } else {
            answerButton.setEnabled(false);
        }

    }

}
