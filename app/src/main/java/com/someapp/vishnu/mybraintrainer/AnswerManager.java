package com.someapp.vishnu.mybraintrainer;

import android.view.View;
import android.widget.Button;

import java.util.Random;

public class AnswerManager {

    Answer[] answers = new Answer[4];

    Answer actualAnswer;

    Equation equation;

    public AnswerManager(View answer1, View answer2, View answer3, View answer4, Equation equ) {

        answers[0] = new Answer(answer1);
        answers[1] = new Answer(answer2);
        answers[2] = new Answer(answer3);
        answers[3] = new Answer(answer4);

        equation = equ;

    }

    public void setAnswers() {

        int answerNumber = new Random().nextInt(answers.length);

        for (int i = 0; i < answers.length; i++) {

            if( i == answerNumber ) {

                answers[i].setAnswerTruth(true);
                answers[i].setAnswer(equation.getNumberAnswer());


            } else {

                answers[i].setAnswerTruth(false);

                int putAnswer = new Random().nextInt(39);
                putAnswer++;

                answers[i].setAnswer(putAnswer);

            }

        }

    }

    public void setVisibility(boolean visible) {

        for (int i = 0; i < answers.length; i++) {

            answers[i].setVisibility(visible);

        }

    }

}
