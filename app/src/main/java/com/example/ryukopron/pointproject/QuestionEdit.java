package com.example.ryukopron.pointproject;

import android.content.Context;
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

import java.io.FileOutputStream;
import java.lang.String;
import java.util.Arrays;


public class QuestionEdit extends ActionBarActivity {

    Question questionSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_edit);
        questionSet = (Question) getApplication();
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
                answerText3.setText(questionSet.answerList[(answerIndex+2)]);}
            if (questionSet.answerCount[questionSet.QuestionID]>=4){
                answerText4.setText(questionSet.answerList[(answerIndex+3)]);}
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
        int aCount = 2;
        int answerIndex;
        int nullarray[] = new int[100];
        Arrays.fill(nullarray, -1);
        String questionArray[] = new String[5];
        Arrays.fill(questionArray, null);
        Button button = (Button) v;
        EditText questionEntry= (EditText) findViewById(R.id.questionTextbox);
        EditText answer1= (EditText) findViewById(R.id.answerTextbox1);
        EditText answer2= (EditText) findViewById(R.id.answerTextbox2);
        EditText answer3= (EditText) findViewById(R.id.answerTextbox3);
        EditText answer4= (EditText) findViewById(R.id.answerTextbox4);

        if (button.getId() == R.id.saveButton) {
            if (questionEntry.getText().toString().length() != 0 && answer1.getText().toString().length() != 0 && answer2.getText().toString().length() != 0){
                if (questionSet.QuestionID == -1) {
                     if (answer3.getText().toString().length() != 0) {
                         aCount = 3;
                         if (answer4.getText().toString().length() != 0){
                             aCount = 4;
                         }
                     }
                     answerIndex = getAnswerIndex(questionSet.QuestionCount);

                     questionSet.Questions[questionSet.QuestionCount] = questionEntry.getText().toString();
                     questionSet.status[questionSet.QuestionCount] = true;
                     questionSet.answerCount[questionSet.QuestionCount] = aCount;

                     questionSet.answerList[answerIndex] = answer1.getText().toString();
                     questionSet.results[answerIndex] = 0;
                     questionSet.answerList[(answerIndex+1)] = answer2.getText().toString();
                     questionSet.results[(answerIndex+1)] = 0;

                     if (answer3.getText().toString().length() != 0) {
                         questionSet.answerList[(answerIndex+2)] = answer3.getText().toString();
                         questionSet.results[(answerIndex+2)] = 0;
                         if (answer4.getText().toString().length() != 0){
                             questionSet.answerList[(answerIndex+3)] = answer4.getText().toString();
                             questionSet.results[(answerIndex+3)] = 0;
                         }
                     }

                     questionSet.QuestionCount = (questionSet.QuestionCount + 1);
                     questionSet.saveSurveyData(nullarray);
                     /*fos.write("\ntrue\n".getBytes());
                     fos.write(Integer.toString(qCount).getBytes());
                     fos.write("\n0\n".getBytes());
                     fos.write(answer1.getText().toString().getBytes());
                     fos.write("\n0\n".getBytes());
                     fos.write(answer2.getText().toString().getBytes());
                     fos.write("\n0\n".getBytes());

                     if (answer3.getText().toString().length() != 0) {
                         fos.write(answer3.getText().toString().getBytes());
                         fos.write("\n0\n".getBytes());
                         if (answer4.getText().toString().length() != 0){
                             fos.write(answer4.getText().toString().getBytes());
                             fos.write("\n0\n".getBytes());
                         }
                     }
                     fos.close();
                     button.setText("Completed Append");
                     questionSet.readData(1);
                     button.setText("Completed Read");
                     TextView errorText = (TextView) findViewById(R.id.errorText2);
                     errorText.setVisibility(View.VISIBLE);
                     errorText.setText(questionSet.Questions[4]);
                     questionSet.saveSurveyData(nullarray);
                     button.setText("Question Added");
                     */
                }
                else {
                    button.setText("Editing");
                    questionArray[0] = questionEntry.getText().toString();
                    questionArray[1] = answer1.getText().toString();
                    questionArray[2] = answer2.getText().toString();

                    if (answer3.getText().toString().length() != 0) {
                        aCount = 3;
                        questionArray[3] = answer3.getText().toString();
                        if (answer4.getText().toString().length() != 0){
                            aCount = 4;
                            questionArray[4] = answer4.getText().toString();
                        }
                    }
                    questionSet.saveQuestionData(aCount, questionArray);

                    /*try {
                        FileOutputStream fos = openFileOutput("OutputFile", Context.MODE_APPEND);
                        fos.write("".getBytes());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/

                }
            }
            else {
                TextView errorText = (TextView) findViewById(R.id.errorText2);
                errorText.setVisibility(View.VISIBLE);
            }

        }

           //save data to text file or database here.
           //If you do overwrite the existing textfile:
                // Iterate through the array outputting in the same way it was read in
                // When you get to the QuestionId (that's the question being edited)
                // output from the form instead of from the current array.
                // for new questions you could just outpu all and the output what is in the form too!
                // remember to increase the question count when you add questions and not when you edit.


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
