package com.example.cchiv.wwwwhatwherewhen;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Cchiv on 09/04/2017.
 */

public class FeedbackActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
    }

    public void submit_feedback(View view) {
        /**
         * Get the RadioButtons input
         */
        String rate = "";

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        if(radioGroup.getCheckedRadioButtonId() != -1) {
            int selectId = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(selectId);

            rate = radioButton.getText().toString();
        }

        /**
         * Get the CheckButtons input
         */
        String checked_improvements = "";

        CheckBox checkBox;
        Resources res = getResources();
        for(int i = 0; i < 6; i++) {
            int id = res.getIdentifier("checkbox_" + i, "id", this.getPackageName());
            checkBox =  (CheckBox) findViewById(id);
            if(checkBox.isChecked())
                checked_improvements += checkBox.getText().toString() + "\n";
        }

        /**
         * Get the EditText input
         */
        String user_improvement = "";

        EditText editText = (EditText) findViewById(R.id.improvement_text);
        user_improvement = editText.getEditableText().toString();

        /**
         * Make the Message text
         */

        String message = "Rate: " + rate + "\n"+"\n" + "Checked:" + "\n" +
                "\n" + checked_improvements + "\n" + "User Feedback:" + "\n"+"\n" + user_improvement + "\n" + "\n" + "Thank you very much! :)";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:DomainFlag2@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "C.U.C Feedback");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        Toast.makeText(this, "Thank you!", Toast.LENGTH_LONG).show();
    }
}
