package com.example.cchiv.wwwwhatwherewhen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static com.example.cchiv.wwwwhatwherewhen.MainActivity.array_sets_completed;

/**
 * Created by Cchiv on 07/04/2017.
 */

public class MenuActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        LinearLayout next = (LinearLayout) findViewById(R.id.quiz_activity);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuizActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.set_1_ic);
        if(array_sets_completed[0])
            imageView.setImageResource(R.drawable.ic_set_completed);
        else
            imageView.setImageResource(R.drawable.ic_goal_not_achieved);

    }

}
