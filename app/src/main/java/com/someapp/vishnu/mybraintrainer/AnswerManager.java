package com.someapp.vishnu.mybraintrainer;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AnswerManager {

    Answer[] answers = new Answer[4];

    Answer actualAnswer;

    int answerNumber;

    Equation equation;

    TopRightScore topScore;

    public AnswerManager(View answer1, View answer2, View answer3, View answer4,
                         Equation equ, TopRightScore topScoreThere) {

        answers[0] = new Answer(answer1);
        answers[1] = new Answer(answer2);
        answers[2] = new Answer(answer3);
        answers[3] = new Answer(answer4);

        equation = equ;
        topScore = topScoreThere;

    }

    public void setAnswers() {

        answerNumber = new Random().nextInt(answers.length);

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<41; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);

        for (int i = 0; i < answers.length; i++) {

            if( i == answerNumber ) {

                answers[i].setAnswerTruth(true);
                answers[i].setAnswer(equation.getNumberAnswer());


            } else {

                answers[i].setAnswerTruth(false);

                if(list.get(i)==equation.getNumberAnswer()) {
                    answers[i].setAnswer(list.get(i) + 1);
                } else {
                    answers[i].setAnswer(list.get(i));
                }

            }

        }

    }

    public void setVisibility(boolean visible) {

        for (int i = 0; i < answers.length; i++) {

            answers[i].setVisibility(visible);

        }

    }

    public void answerClickManage(int tag) {

        if(answerNumber==tag) {

            topScore.update(true);

        } else {

            topScore.update(false);

        }

    }

    public void freeze() {

        for (int i = 0; i < answers.length; i++) {

            answers[i].setClickable(false);

        }

    }

    public void unFreeze() {

        for (int i = 0; i < answers.length; i++) {

            answers[i].setClickable(true);

        }

    }

}
