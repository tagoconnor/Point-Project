package com.example.ryukopron.pointproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.lang.String;
import android.app.AlertDialog;


public class QuestionEdit extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_edit);
        final Question questionSet = (Question) getApplication();
        int answerIndex = 0;
        if (questionSet.QuestionID >= 0){
            answerIndex = getAnswerIndex(questionSet.QuestionID);
            TextView questionText = (TextView) findViewById(R.id.questionTextbox);
            TextView answerText1 = (TextView) findViewById(R.id.answerTextbox1);
            TextView answerText2 = (TextView) findViewById(R.id.answerTextbox2);
            TextView answerText3 = (TextView) findViewById(R.id.answerTextbox3);
            TextView answerText4 = (TextView) findViewById(R.id.answerTextbox4);
            questionText.setText(questionSet.Questions[questionSet.QuestionID]);
            answerText1.setText(questionSet.answerList[answerIndex]);
            answerText2.setText(questionSet.answerList[(answerIndex + 1)]);
            if (questionSet.answerCount[questionSet.QuestionID]>=3){
                answerText1.setText(questionSet.answerList[(answerIndex+2)]);}
            if (questionSet.answerCount[questionSet.QuestionID]>=4){
                answerText1.setText(questionSet.answerList[(answerIndex+3)]);}
        }
    }

    public int getAnswerIndex(int index){
        Integer a = 0;
        Integer p = 0;
        while (p<index){
            a = (a + ((Question) this.getApplication()).answerCount[p]);
            p = p + 1;
        }
        return a;
    }

    public void savebuttonOnClick(View v) {
        Button button = (Button) v;
        if (button.getId() == R.id.saveButton){
            final EditText input = new EditText(this);
             new AlertDialog.Builder(this)
                    .setTitle("Update Status")
                    .setMessage("Sure")
                    .setView(input)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            //editable = input.getText();
                            // deal with the editable

                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            // Do nothing.
                        }
                    }).show();

           //save data to text file or database here.
           //If you do overwrite the existing textfile:
                // Iterate through the array outputting in the same way it was read in
                // When you get to the QuestionId (that's the question being edited)
                // output from the form instead of from the current array.
                // for new questions you could just outpu all and the output what is in the form too!
                // remember to increase the question count when you add questions and not when you edit.

        }
    }

    public void exitbuttonOnClick(View v) {
        ImageButton button = (ImageButton) v;
        if (button.getId() == R.id.imageButton5) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
