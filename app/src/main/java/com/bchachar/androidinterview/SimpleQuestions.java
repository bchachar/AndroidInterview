package com.bchachar.androidinterview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SimpleQuestions extends Activity implements OnClickListener {

    TextView tvquestion, tvanswer, tvtotalquestin, tvindex;
    Button bleft, bshow, bright;
    String[] simple_questions, simple_answers;

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);


        //action bar
/*
        @SuppressLint("WrongViewCast")
		LinearLayout question_linearlayout = (LinearLayout) findViewById(R.id.questionpage_titlebar);

		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.question_titlebar);


		Button speak = (Button) findViewById(R.id.bspeak);
		speak.setOnClickListener(this);
		Button stop = (Button) findViewById(R.id.bstop);
		stop.setOnClickListener(this);
*/


        // Initializing the TextView
        tvquestion = (TextView) findViewById(R.id.tvquestion);
        tvanswer = (TextView) findViewById(R.id.tvanswer);
        tvtotalquestin = (TextView) findViewById(R.id.tvyy);
        tvindex = (TextView) findViewById(R.id.tvxx);

        // Initializing the Buttons
        bleft = (Button) findViewById(R.id.bleft);
        bright = (Button) findViewById(R.id.bright);
        bshow = (Button) findViewById(R.id.bshowanswer);

        // setOnClickListener to buttons
        bleft.setOnClickListener(this);
        bright.setOnClickListener(this);
        bshow.setOnClickListener(this);

        // Importing the string array from Value Folder
        simple_questions = getResources().getStringArray(R.array.simple_questions);
        simple_answers = getResources().getStringArray(R.array.simple_answers);

        // setting values to variable and TextViews
        index = 0;
        tvquestion.setText(simple_questions[index]);
        tvanswer.setText("Press \"A\" Button for the Answer");
        tvindex.setText(String.valueOf(index + 1));
        tvtotalquestin.setText("/" + String.valueOf(simple_questions.length));
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.bleft:
                tvanswer.setText("Press \"A\" Button for the Answer");
                index--;
                if (index == -1)
                    index = simple_questions.length - 1;
                tvindex.setText(String.valueOf(index + 1));
                tvquestion.setText(simple_questions[index]);
                break;

            case R.id.bright:
                tvanswer.setText("Press \"A\" Button for the Answer");
                index++;
                if (index == simple_questions.length)
                    index = 0;
                tvindex.setText(String.valueOf(index + 1));
                tvquestion.setText(simple_questions[index]);
                break;

            case R.id.bshowanswer:
                tvanswer.setText(simple_answers[index]);
                break;

            case R.id.bspeak:

                break;

            case R.id.bstop:

                break;
        }
    }

}
