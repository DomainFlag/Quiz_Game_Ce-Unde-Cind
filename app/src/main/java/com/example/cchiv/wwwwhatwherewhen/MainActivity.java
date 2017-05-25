package com.example.cchiv.wwwwhatwherewhen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.GONE;
import static com.example.cchiv.wwwwhatwherewhen.R.string.app_question_1_solution_text;

public class MainActivity extends AppCompatActivity {

    int index = 0;
    public static boolean[] array_achievements_obtained = {false, false};
    public static boolean[] array_sets_completed = {false};
    String[] question_day_hint_strings = {"The first love", "The second breath", "Statue of Zeus at Olympia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        array_achievements_obtained[0] = true;

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.achievement_popup,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        ImageView imageView = (ImageView) layout.findViewById(R.id.image_popup);
        imageView.setImageResource(R.drawable.ic_baby_owl);

        TextView textView = (TextView) layout.findViewById(R.id.text_popup);
        textView.setText("Welcome baby owl to Ce? Unde? Cind? Your adventure begins right now.");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.TOP, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        /**
         * Quiz Activity
         */
        Button next = (Button) findViewById(R.id.quiz_activity);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuizActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        /**
         * Show Solution Activity
         */
        final Button show_solution = (Button) findViewById(R.id.show_solution);
        show_solution.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(R.id.question_day);
                textView.setText(getResources().getString(app_question_1_solution_text));

                show_solution.setVisibility(GONE);
                Button show_hint = (Button) findViewById(R.id.show_hint);
                show_hint.setVisibility(GONE);
            }
        });

        LinearLayout nextActivity;

        /**
         * Achievements Activity
         */
        nextActivity = (LinearLayout) findViewById(R.id.activity_achievements);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AchivementsActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        /**
         * Feedback Activity
         */
        nextActivity = (LinearLayout) findViewById(R.id.activity_feedback);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), FeedbackActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        /**
         * Help Activity
         */
        nextActivity = (LinearLayout) findViewById(R.id.activity_help);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), HelpActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

    /**
     * Interface UI/UX
     */

    /****************************************************/
    public void reveal_quest_1(View view) {
        Toast.makeText(this, "Install the app", Toast.LENGTH_SHORT).show();
    }

    public void reveal_quest_2(View view) {
        Toast.makeText(this, "Complete the first set", Toast.LENGTH_SHORT).show();
    }

    public void show_hint(View view) {
        Toast.makeText(this, question_day_hint_strings[index], Toast.LENGTH_SHORT).show();
        index = (index+1)%3;
    }
}
