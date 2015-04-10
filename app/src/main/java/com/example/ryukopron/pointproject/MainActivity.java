package com.example.ryukopron.pointproject;

import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.database.Cursor;
import android.util.Log;

import java.lang.String;

public class MainActivity extends ActionBarActivity {


    int index = 0;
    int answerIndex = 0;
//    public String[] questionsTest = {"4","Which describes you most?","true","4","Student 18-21","3","Student 21+","3","Faculty","3","Non-Student","3",
  //          "How was your visit?","true","2","Excellent","3","Good","3",
//            "How many times have you visited The Point?","true","4", "First time","3", "2-4","3", "5-10","3", "11+","3",
//            "What brings you in today?","true","3", "Beer","3", "Food","3", "Entertainment","3",};










    int i=1;
    DatabaseQuerys DB = new DatabaseQuerys(this);
    long NumRows = DB.COUNT(DB);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Reached");
        NumRows = DB.COUNT(DB);
        setContentView(R.layout.activity_main);

        if (NumRows > 0){
            Cursor CR = DB.getInformation(DB, i);
            CR.moveToFirst();
            TextView Quest = (TextView) findViewById(R.id.Question1);
            Quest.setText(CR.getString(1));
            TextView checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            checkBox1.setText(CR.getString(2));
            TextView checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
            checkBox2.setText(CR.getString(4));
            if(CR.getString(6)!= "null"){
                TextView checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
                checkBox3.setVisibility(View.VISIBLE);
                checkBox3.setText(CR.getString(6));
            }
            if(CR.getString(8)!= "null"){
                TextView checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
                checkBox4.setVisibility(View.VISIBLE);
                checkBox4.setText(CR.getString(9));
            }



         }


//        Question questionSet = (Question)getApplication();
//        questionSet.QuestionCount = Integer.parseInt(questionsTest[0]);
//        Integer count = 0;
//        Integer tempCount = 0;
//        Integer questionPosition = 0;
//        Integer answerCount = 0;
//        Integer arrayPosition = 1;
//        while (count < Integer.parseInt(questionsTest[0])){
//            questionSet.Questions[count]=questionsTest[arrayPosition];
//            questionSet.status[count]=Boolean.parseBoolean(questionsTest[arrayPosition+1]);
//            answerCount = Integer.parseInt(questionsTest[(arrayPosition+2)]);
//            questionSet.answerCount[count]=answerCount;
//            while (tempCount < answerCount){
//                questionSet.answerList[(tempCount+questionPosition)]=questionsTest[(arrayPosition+3+(2*tempCount))];
//                questionSet.results[(tempCount+questionPosition)]=Integer.parseInt(questionsTest[(arrayPosition+4+(2*tempCount))]);
//                tempCount = (tempCount +1);
//            }
//            questionPosition = (questionPosition + answerCount);
//            tempCount=0;
//            arrayPosition=(arrayPosition + 3 + (2*answerCount));
//            count = (count + 1);
//       }
  }

    public void oncheckboxClick(View v) {
            boolean checked = ((CheckBox) v).isChecked();
            if (v.getId() == R.id.checkBox1){
                CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
                checkBox2.setChecked(false);
                CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
                checkBox3.setChecked(false);
                CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
                checkBox4.setChecked(false);
            }
        if (v.getId() == R.id.checkBox2){
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            checkBox1.setChecked(false);
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
            checkBox3.setChecked(false);
            CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
            checkBox4.setChecked(false);
        }
        if (v.getId() == R.id.checkBox3){
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
            checkBox2.setChecked(false);
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            checkBox1.setChecked(false);
            CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
            checkBox4.setChecked(false);
        }
        if (v.getId() == R.id.checkBox4){
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
        if  (i<NumRows/*index < (((Question) this.getApplication()).QuestionCount)-1*/) {
        //    index = index + 1;
        //    answerIndex = getAnswerIndex(index);
            i+=1;
            Cursor CR = DB.getInformation(DB, i);
            CR.moveToFirst(); //QUID
            CR.moveToNext(); // Question2
            TextView Quest = (TextView) findViewById(R.id.Question1);
            Quest.setText(CR.getString(0));
            CR.moveToNext(); //Answer1
            TextView checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            checkBox1.setText(CR.getString(0));
            CR.moveToNext(); //Result1
            CR.moveToNext(); //Answer2
            TextView checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
            checkBox2.setText(CR.getString(0));
            CR.moveToNext(); //Result2
            CR.moveToNext(); //Answer3
            if(CR.getString(0)!= "null"){
                TextView checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
                checkBox3.setVisibility(View.VISIBLE);
                checkBox3.setText(CR.getString(0));
            }
            CR.moveToNext(); //Result3
            CR.moveToNext(); //Answer4
            if(CR.getString(0)!= "null"){
                TextView checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
                checkBox4.setVisibility(View.VISIBLE);
                checkBox4.setText(CR.getString(0));
            }
     //       TextView checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
    //        checkBox1.setText(((Question) this.getApplication()).answerList[answerIndex]);
     //       TextView checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
      //      checkBox2.setText(((Question) this.getApplication()).answerList[(answerIndex+1)]);
      //      TextView checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
     //       if (((Question) this.getApplication()).answerCount[index]>=3){
     //           checkBox3.setVisibility(View.VISIBLE);
     //           checkBox3.setText(((Question) this.getApplication()).answerList[(answerIndex + 2)]);}
           //else{checkBox3.setVisibility(View.INVISIBLE);}
          //  TextView checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        //    if (((Question) this.getApplication()).answerCount[index]>=4){
        //        checkBox4.setVisibility(View.VISIBLE);
        //       checkBox4.setText(((Question) this.getApplication()).answerList[(answerIndex + 3)]);}
            //else {checkBox4.setVisibility(View.INVISIBLE);}
           // TextView Quest = (TextView) findViewById(R.id.Question1);
           // Quest.setText(((Question) this.getApplication()).Questions[index]);
            unCheck();
        }
        else {
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
        if  (i>1/*index < (((Question) this.getApplication()).QuestionCount)-1*/) {
        //    index = index - 1;
        //    answerIndex = getAnswerIndex(index);
            i-=1;
            Cursor CR = DB.getInformation(DB, i);
            CR.moveToFirst(); //QUID
            CR.moveToNext(); // Question2
            TextView Quest = (TextView) findViewById(R.id.Question1);
            Quest.setText(CR.getString(0));
            CR.moveToNext(); //Answer1
            TextView checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
            checkBox1.setText(CR.getString(0));
            CR.moveToNext(); //Result1
            CR.moveToNext(); //Answer2
            TextView checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
            checkBox2.setText(CR.getString(0));
            CR.moveToNext(); //Result2
            CR.moveToNext(); //Answer3
            if(CR.getString(0)!= "null"){
                TextView checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
                checkBox3.setVisibility(View.VISIBLE);
                checkBox3.setText(CR.getString(0));
            }
            CR.moveToNext(); //Result3
            CR.moveToNext(); //Answer4
            if(CR.getString(0)!= "null"){
                TextView checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
                checkBox4.setVisibility(View.VISIBLE);
                checkBox4.setText(CR.getString(0));
            }
    //    if (index>0) {
    //        index = index - 1;
    //        answerIndex = getAnswerIndex(index);
    //        TextView checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
    //        checkBox1.setText(((Question) this.getApplication()).answerList[answerIndex]);
    //        TextView checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
    //        checkBox2.setText(((Question) this.getApplication()).answerList[(answerIndex+1)]);
    //        TextView checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
    //        if (((Question) this.getApplication()).answerCount[index]>=3){
    //            checkBox3.setVisibility(View.VISIBLE);
    //            checkBox3.setText(((Question) this.getApplication()).answerList[(answerIndex + 2)]);}
    //        else{checkBox3.setVisibility(View.INVISIBLE);}
    //        TextView checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
    //        if (((Question) this.getApplication()).answerCount[index]>=4){
    //            checkBox4.setVisibility(View.VISIBLE);
    //            checkBox4.setText(((Question) this.getApplication()).answerList[(answerIndex + 3)]);}
    //        else {checkBox4.setVisibility(View.INVISIBLE);}
    //        TextView Quest = (TextView) findViewById(R.id.Question1);
    //        Quest.setText(((Question) this.getApplication()).Questions[index]);
     //       unCheck();
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
