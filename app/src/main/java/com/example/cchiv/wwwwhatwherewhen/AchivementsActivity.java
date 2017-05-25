package com.example.cchiv.wwwwhatwherewhen;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.cchiv.wwwwhatwherewhen.MainActivity.array_achievements_obtained;

/**
 * Created by Cchiv on 08/04/2017.
 */

public class AchivementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        Resources res = getResources();
        int sum = 0;
        for(int g = 1; g <= 2; g++) {
            int id = res.getIdentifier("achievement_"+g, "id", this.getPackageName());
            ImageView imageView = (ImageView) findViewById(id);
            if(array_achievements_obtained[g-1]) {
                imageView.setAlpha(255);
                sum += 50;
            } else {
                imageView.setAlpha(127);
            }
        }

        TextView textView = (TextView) findViewById(R.id.achievements_points);
        textView.setText("Total points: " + sum);

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

}