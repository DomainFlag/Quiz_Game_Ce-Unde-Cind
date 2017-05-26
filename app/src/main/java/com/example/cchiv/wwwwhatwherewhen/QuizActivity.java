package com.example.cchiv.wwwwhatwherewhen;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.cchiv.wwwwhatwherewhen.MainActivity.array_achievements_obtained;
import static com.example.cchiv.wwwwhatwherewhen.MainActivity.array_sets_completed;

/**
 * Created by Cchiv on 07/04/2017.
 */

public class QuizActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question_1);
    }

    int score = 0;
    MediaPlayer MP1;
    MediaPlayer MP2;

    /**
     * Media Player Setting
     */
    public void setMedia1(View view) {
        if(MP1 == null) {
            if(MP2 != null) {
                MP2.stop();
                MP2 = null;
            }
            MP1 = MediaPlayer.create(this, R.raw.mc_music_1);
            MP1.start();
        } else {
            MP1.stop();
            MP1 = null;
        }
    }

    public void setMedia2(View view) {
        if(MP2 == null) {
            if(MP1 != null) {
                MP1.stop();
                MP1 = null;
            }
            MP2 = MediaPlayer.create(this, R.raw.mc_music_1);
            MP2.start();
        } else {
            MP2.stop();
            MP2 = null;
        }
    }
    /**
     * Matcher for quiz questions
     * */

    public String setToastText(String pattern, String answer, String correctAnswer) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(answer);
        String toastText;
        if(m.find()) {
            toastText = "Correct Answer :)";
            score++;
        } else toastText = correctAnswer;
        return toastText;
    }

    public String setBlitzToastText(String pattern1, String pattern2, String answer1, String answer2, String correctAnswer) {
        Pattern p1 = Pattern.compile(pattern1);
        Matcher m1 = p1.matcher(answer1);

        Pattern p2 = Pattern.compile(pattern2);
        Matcher m2 = p2.matcher(answer2);

        String toastText;

        if(m1.find() && m2.find()) {
            toastText = "Correct Answer :)";
            score++;
        } else toastText = correctAnswer;
        return toastText;
    }


    public void activityQuizSetQuestion2(View view) {
        EditText editText = (EditText) findViewById(R.id.answer);
        String answer = editText.getEditableText().toString().toLowerCase();

        String toastText = setToastText("(game).*(throne)", answer, "Games of Thrones");

        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_quiz_question_2);
    }

    public void activityQuizSetQuestion3(View view) {
        EditText editText = (EditText) findViewById(R.id.answer);
        String answer = editText.getEditableText().toString();

        String toastText = setToastText("(cut|slice).*(map|part|counties).*(area|surface)", answer, "He cut out and weighed separately each of the counties. Then he could easily evaluate the area of each county based on the area/weight relationship calculated from the weight and area of Kent known to him.");

        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_quiz_question_3);
    }

    public void activityQuizSetQuestion4(View view) {
        EditText editText1 = (EditText) findViewById(R.id.answer_1);
        String answer1 = editText1.getEditableText().toString();

        EditText editText2 = (EditText) findViewById(R.id.answer_2);
        String answer2 = editText2.getEditableText().toString();

        String toastText = setBlitzToastText("(blitz)", "(bed|couch)", answer1, answer2, "No need for explanation, basic knowledge");

        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_quiz_question_4);
    }

    public void activityQuizSetQuestion5(View view) {
        EditText editText = (EditText) findViewById(R.id.answer);
        String answer = editText.getEditableText().toString();

        String toastText = setToastText("(telephone|phone|yellow|white)", answer, "A telephone book, or the white/yellow pages, is a listing of telephone subscribers in a geographical area or subscribers to services provided by the organization that publishes the directory. Its purpose is to allow the telephone number of a subscriber identified by name and address to be found.");

        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_quiz_question_5);
    }

    public void activityQuizSetQuestion6(View view) {
        EditText editText = (EditText) findViewById(R.id.answer);
        String answer = editText.getEditableText().toString();

        String toastText = setToastText(".*", answer, "Any answer, this question needs revising.");

        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_quiz_question_6);
    }

    public void activityQuizSetQuestion7(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        String toastText = "Incorrect solution, correct one: #";
        if(radioGroup.getCheckedRadioButtonId() != -1) {
            int selectId = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(selectId);
            if(radioButton.getText().toString().equals("#")) {
                score++;
                toastText = "Correct Solution";
            }
        }
        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_quiz_question_7);
    }

    public void activityQuizSetScoreScreen(View view) {
        String toastText = "Incorrect solution, correct one: 1st, 2nd, 3rd";
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.check_1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.check_2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.check_3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.check_4);
        if(checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !checkBox4.isChecked()) {
            score++;
            toastText = "Correct Answer";
        }
        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
        activityScoreScreen();
    }

    public void activityScoreScreen() {
        setContentView(R.layout.activity_score_screen);

        array_achievements_obtained[1] = true;
        array_sets_completed[0] = true;

        TextView textView;
        textView = (TextView) findViewById(R.id.opening_message_text);
        textView.setText("Congrats");

        textView = (TextView) findViewById(R.id.score_text);
        textView.setText(score + " points");

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.achievement_popup,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        ImageView imageView = (ImageView) layout.findViewById(R.id.image_popup);
        imageView.setImageResource(R.drawable.ic_first_set_completed);

        TextView textViewPopup = (TextView) layout.findViewById(R.id.text_popup);
        textViewPopup.setText("Complete the first set");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.TOP, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        Button next = (Button) findViewById(R.id.finish_activity);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
    }
}
