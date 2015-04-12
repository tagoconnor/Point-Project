package com.example.ryukopron.pointproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {
    BufferedReader inputReader;
    StringBuffer stringBuffer;
    Question questionSet;
    int index = 1;
    int answerIndex = 0;
    int checks[] = new int[100];
    public String[] questionsTest = {"4","Which describes you most?","true","4","Student 18-21","3","Student 21+","3","Faculty","3","Non-Student","3",
            "How was your visit?","true","2","Excellent","3","Good","3","How many times have you visited The Point?","true","4", "First time","3",
            "2-4","3", "5-10","3", "11+","3", "What brings you in today?","true","3", "Beer","3", "Food","3", "Entertainment","3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Arrays.fill(checks, -1);

        try{
            inputReader = new BufferedReader(new InputStreamReader(openFileInput("testOutputFile")));
            stringBuffer = new StringBuffer();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //Read file should be here.
        //You could read into questionsTest array above (need to modify params a little) and then output to Question Class
        //The code for adding it is already done just below this comment block.
        //Or you could read directly into the Question class. Whichever is easier for you.
        //FYI, Question Class is a public class that you can access from any form.
        //This makes it so we don't need to reread data for the management sections.

        //Survey functions and auto adjusts to show the proper number of answers for each question
        //It doesn't increment the results yet since there is no output to save to.
        //Could save the id of whichever checkbox is checked to an array.
        //I think that saving after the last question would be nice.
        //Just output all data to same textfile and increment the chosen values.

        //Side note:
        //We could do a lot more questions. Any thoughts?

        questionSet = (Question)getApplication();
        /*questionSet.QuestionCount = Integer.parseInt(questionsTest[0]);
        Integer count = 0;
        Integer tempCount = 0;
        Integer questionPosition = 0;
        Integer answerCount = 0;
        Integer arrayPosition = 1;
        while (count < Integer.parseInt(questionsTest[0])){
            questionSet.Questions[count]=questionsTest[arrayPosition];
            questionSet.status[count]=Boolean.parseBoolean(questionsTest[arrayPosition+1]);
            answerCount = Integer.parseInt(questionsTest[(arrayPosition+2)]);
            questionSet.answerCount[count]=answerCount;
            while (tempCount < answerCount){
                questionSet.answerList[(tempCount+questionPosition)]=questionsTest[(arrayPosition+3+(2*tempCount))];
                questionSet.results[(tempCount+questionPosition)]=Integer.parseInt(questionsTest[(arrayPosition+4+(2*tempCount))]);
                tempCount = (tempCount +1);
            }
            questionPosition = (questionPosition + answerCount);
            tempCount=0;
            arrayPosition=(arrayPosition + 3 + (2*answerCount));
            count = (count + 1);
       }*/
        questionSet.readData();
        prevQ();
    }

    public void oncheckboxClick(View v) {
            boolean checked = ((CheckBox) v).isChecked();
            if (v.getId() == R.id.checkBox1){
                checks[index]=0;
                CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
                checkBox2.setChecked(false);
                CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
                checkBox3.setChecked(false);
                CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
                checkBox4.setChecked(false);
            }
        if (v.getId() == R.id.checkBox2){
            checks[index]=1;
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            checkBox1.setChecked(false);
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
            checkBox3.setChecked(false);
            CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
            checkBox4.setChecked(false);
        }
        if (v.getId() == R.id.checkBox3){
            checks[index]=2;
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
            checkBox2.setChecked(false);
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            checkBox1.setChecked(false);
            CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
            checkBox4.setChecked(false);
        }
        if (v.getId() == R.id.checkBox4){
            checks[index]=3;
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
            checkBox2.setChecked(false);
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
            checkBox3.setChecked(false);
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            checkBox1.setChecked(false);
        }
    }

    public void buttonOnClick(View v) {
        Button button = (Button) v;
        if (button.getId() == R.id.prev)
        {
            prevQ();
        }
        else if (button.getId() == R.id.next)
        {
            nextQ();
        }
        else
        {
            button.setText("I've Been Clicked!");
        }
    }


    public void testbuttonOnClick(View v) {
        Button button = (Button) v;
        int count = 0;
        String inputString;
        if (button.getId() == R.id.testbutton1) {
           try {
                inputString = inputReader.readLine();
                if (inputString == null){
                    button.setText("FUUUUUUU---!");
                }
                else {
                    button.setText(inputString);
                }
            }
            catch (Exception e) {
                button.setText("FUUUUUU---!");
                e.printStackTrace();
            }


/*
            try {
                FileOutputStream fos = openFileOutput("datafile", Context.MODE_PRIVATE);
                fos.write("admin\nadmin".getBytes());

                while (count < questionsTest.length) {
                    fos.write("\n".getBytes());
                    fos.write(questionsTest[count].getBytes());
                    count = (count + 1);
                }
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
    }

    public void testreadOnClick(View v) {
        Button button = (Button) v;
        if (button.getId() == R.id.testbutton2)
        {
            questionSet.readData();
            button.setText(questionSet.QuestionCount.toString());
        }
    }

    //this is for the little cog button. Take you to the login screen for the management menu
    //On any other page, if this is clicked it will take the user back to the survey start page.

    public void ManagebuttonOnClick(View v) {
        ImageButton button = (ImageButton) v;
        if (button.getId() == R.id.imageButton){
            startActivity(new Intent(getApplicationContext(), Login.class));
        }
    }

    public void unCheck(){
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox1.setChecked(false);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox2.setChecked(false);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox3.setChecked(false);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox4.setChecked(false);
    }

    public void nextQ() {
        if  (index < (((Question) this.getApplication()).QuestionCount)-1) {
            index = index + 1;
            answerIndex = getAnswerIndex(index);
            TextView checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            checkBox1.setText(((Question) this.getApplication()).answerList[answerIndex]);
            TextView checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
            checkBox2.setText(((Question) this.getApplication()).answerList[(answerIndex+1)]);
            TextView checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
            if (((Question) this.getApplication()).answerCount[index]>=3){
                checkBox3.setVisibility(View.VISIBLE);
                checkBox3.setText(((Question) this.getApplication()).answerList[(answerIndex + 2)]);}
            else{checkBox3.setVisibility(View.INVISIBLE);}
            TextView checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
            if (((Question) this.getApplication()).answerCount[index]>=4){
                checkBox4.setVisibility(View.VISIBLE);
                checkBox4.setText(((Question) this.getApplication()).answerList[(answerIndex + 3)]);}
            else {checkBox4.setVisibility(View.INVISIBLE);}
            TextView Quest = (TextView) findViewById(R.id.Question1);
            Quest.setText(((Question) this.getApplication()).Questions[index]);
            unCheck();
        }
        else {
            questionSet.saveSurveyData(checks);
            Arrays.fill(checks, -1);
            startActivity(new Intent(getApplicationContext(), Thanks.class));
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

    public void prevQ(){
        if (index>0) {
            index = index - 1;
            answerIndex = getAnswerIndex(index);
            TextView checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            checkBox1.setText(((Question) this.getApplication()).answerList[answerIndex]);
            TextView checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
            checkBox2.setText(((Question) this.getApplication()).answerList[(answerIndex+1)]);
            TextView checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
            if (((Question) this.getApplication()).answerCount[index]>=3){
                checkBox3.setVisibility(View.VISIBLE);
                checkBox3.setText(((Question) this.getApplication()).answerList[(answerIndex + 2)]);}
            else{checkBox3.setVisibility(View.INVISIBLE);}
            TextView checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
            if (((Question) this.getApplication()).answerCount[index]>=4){
                checkBox4.setVisibility(View.VISIBLE);
                checkBox4.setText(((Question) this.getApplication()).answerList[(answerIndex + 3)]);}
            else {checkBox4.setVisibility(View.INVISIBLE);}
            TextView Quest = (TextView) findViewById(R.id.Question1);
            Quest.setText(((Question) this.getApplication()).Questions[index]);
            unCheck();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
