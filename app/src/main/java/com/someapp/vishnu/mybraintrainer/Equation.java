package com.someapp.vishnu.mybraintrainer;

import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class Equation {

    TextView equationView;
    int first;
    int second;
    int answer;
    String equationString;

    public Equation(View view) {

        equationView = (TextView) view;
        first = new Random().nextInt(19);
        first++;
        second = new Random().nextInt(19);
        second++;

        answer = first + second;

        equationString = first + " + " + second;
        equationView.setText(equationString);

    }

    public void update() {

        first = new Random().nextInt(19);
        first++;
        second = new Random().nextInt(19);
        second++;

        answer = first + second;

        equationString = first + " + " + second;
        equationView.setText(equationString);

    }

    public String toString() {

        update();
        return equationString;

    }

    public int getNumberAnswer() {

        return answer;

    }

    public void setVisiblity(boolean visible) {

        if(visible) {
            equationView.setVisibility(View.VISIBLE);
        } else {
            equationView.setVisibility(View.INVISIBLE);
        }

    }

}
