package com.example.cchiv.wwwwhatwherewhen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Cchiv on 09/04/2017.
 */

public class HelpActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

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
