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

    }

    public void setText(int theAnswer) {

        answer = theAnswer;

    }

    public void setVisibility(boolean visible) {

        if (visible) {
            answerButton.setVisibility(View.VISIBLE);
        } else {
            answerButton.setVisibility(View.INVISIBLE);
        }

    }

}
