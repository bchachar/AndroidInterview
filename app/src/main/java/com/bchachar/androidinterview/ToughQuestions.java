package com.bchachar.androidinterview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ToughQuestions extends Activity implements OnClickListener {
    String[] tough_questions, tough_answers;
    TextView tvquestion, tvanswer, tvtotalquestin, tvindex;
    Button bleft, bshow, bright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        tvquestion = (TextView) findViewById(R.id.tvquestion);
        tvanswer = (TextView) findViewById(R.id.tvanswer);

        tvtotalquestin = (TextView) findViewById(R.id.tvyy);
        tvindex = (TextView) findViewById(R.id.tvxx);

        bleft = (Button) findViewById(R.id.bleft);
        bright = (Button) findViewById(R.id.bright);
        bshow = (Button) findViewById(R.id.bshowanswer);

        bleft.setOnClickListener(this);
        bright.setOnClickListener(this);
        bshow.setOnClickListener(this);

        tough_questions = getResources().getStringArray(R.array.simple_questions);
        tough_answers = getResources().getStringArray(R.array.simple_answers);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.bleft:

                break;

            case R.id.bright:

                break;

            case R.id.bshowanswer:

                break;
        }
    }
}
