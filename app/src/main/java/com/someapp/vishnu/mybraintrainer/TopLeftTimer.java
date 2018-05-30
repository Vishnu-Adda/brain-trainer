package com.someapp.vishnu.mybraintrainer;

import android.view.View;
import android.widget.TextView;

public class TopLeftTimer {

    TextView timerView;
    String timerString;

    public TopLeftTimer(View view) {

        timerView = (TextView) view;
        timerString = timerView.toString();

    }

    public void update(long millisecondsUntilDone) {

        timerString = String.valueOf(millisecondsUntilDone/1000) + "s";
        timerView.setText(timerString);

    }

    public String toString() {

        return timerString;

    }

    public void setVisibility(boolean visible) {

        if(visible) {
            timerView.setVisibility(View.VISIBLE);
        } else {
            timerView.setVisibility(View.INVISIBLE);
        }

    }

}
