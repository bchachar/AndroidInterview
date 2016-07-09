package com.bchachar.androidinterview;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SimpleQuestions extends AppCompatActivity implements OnClickListener {

    public static final String default_answer = "Press \"A\" Button for the Answer";

    TextView tvquestion, tvanswer, tvtotalquestin, tvindex;
    Button bleft, bshow, bright;
    String[] simple_questions, simple_answers;

    int index;

    //objects for text to speech
    public TextToSpeech textToSpeech;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);


        //action bar
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setCustomView(R.layout.question_titlebar);


		Button speak = (Button) findViewById(R.id.bspeak);
		speak.setOnClickListener(this);
		Button stop = (Button) findViewById(R.id.bstop);
		stop.setOnClickListener(this);



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
        tvanswer.setText(default_answer);
        tvindex.setText(String.valueOf(index + 1));
        tvtotalquestin.setText("/" + String.valueOf(simple_questions.length));

        textToSpeech = new TextToSpeech(SimpleQuestions.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS) {
                    result = textToSpeech.setLanguage(Locale.UK);
                } else {
                    Toast.makeText(SimpleQuestions.this, "Feature not Available.", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bleft:
                tvanswer.setText(default_answer);
                index--;
                if (index == -1)
                    index = simple_questions.length - 1;
                tvindex.setText(String.valueOf(index + 1));
                tvquestion.setText(simple_questions[index]);
                break;

            case R.id.bright:
                tvanswer.setText(default_answer);
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
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(SimpleQuestions.this, "Feature not Available.", Toast.LENGTH_LONG).show();
                } else {
                    if (!tvanswer.getText().toString().equals(default_answer))
                        textToSpeech.speak(simple_answers[index], TextToSpeech.QUEUE_FLUSH, null);
                }
                break;

            case R.id.bstop:
                if (textToSpeech != null) {
                    textToSpeech.stop();
                }
                break;
        }
    }

}
