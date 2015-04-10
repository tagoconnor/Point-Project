package com.example.ryukopron.pointproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
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

    DatabaseQuerys DB;
    long NumRows = DB.COUNT(DB);
    TextView questionText = (TextView) findViewById(R.id.questionTextbox);
    TextView answerText1 = (TextView) findViewById(R.id.answerTextbox1);
    TextView answerText2 = (TextView) findViewById(R.id.answerTextbox2);
    TextView answerText3 = (TextView) findViewById(R.id.answerTextbox3);
    TextView answerText4 = (TextView) findViewById(R.id.answerTextbox4);
    final Question questionSet = (Question) getApplication();
    //int answerIndex = 0;
    int id = questionSet.QuestionID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_edit);

        if (questionSet.QuestionID >= 1){
         //   answerIndex = getAnswerIndex(questionSet.QuestionID);
            Cursor CR = DB.getInformation(DB, id);
            questionText.setText(CR.getString(1));
            CR.moveToNext(); //Answer1
            answerText1.setText(CR.getString(2));
            CR.moveToNext(); // Result1
            CR.moveToNext(); // Answer2
            answerText2.setText(CR.getString(4));
             if (CR.getString(6)!= "null"){
                answerText3.setText(CR.getString(6));}
            if (CR.getString(8)!= "null"){
                answerText4.setText(CR.getString(8));}
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

        if (button.getId() == R.id.saveButton) {
            final EditText input = new EditText(this);
            if (NumRows == 0) {
                DB.INSERT(DB, 1, questionText.toString(), answerText1.toString(), 0,
                        answerText2.toString(), 0, answerText3.toString(), 0, answerText4.toString(), 0);
            }
            else if (id <= NumRows) {
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

                DB.updateInfo(DB, id, questionText.toString(), answerText1.toString(), 0,
                        answerText2.toString(), 0, answerText3.toString(), 0, answerText4.toString(), 0);
                }
            else DB.INSERT(DB, (int) (NumRows+1), questionText.toString(), answerText1.toString(),
                        0, answerText2.toString(), 0, answerText3.toString(), 0, answerText4.toString(), 0);
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
