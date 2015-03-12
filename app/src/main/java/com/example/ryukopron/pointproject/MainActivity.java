package com.example.ryukopron.pointproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.lang.String;


public class MainActivity extends ActionBarActivity {

    int index = 0;
    public String[] Questions = {"Which describes you most?","Student 18-21","Student 21+","Faculty","Non-Student","How was your visit?","Excellent","Good","Fair","Poor","How many times have you visited The Point?", "First time", "0-4", "5-10", "11+", "What brings you in today?", "Beer", "Food", "Entertainment", "Meeting someone"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            if ((index + 5) <= 19) {
                index = index + 5;
                TextView checkBox1 = (CheckBox)
                        findViewById(R.id.checkBox1);
                checkBox1.setText(Questions[(index + 1)]);
                TextView checkBox2 = (CheckBox)
                        findViewById(R.id.checkBox2);
                checkBox2.setText(Questions[(index + 2)]);
                TextView checkBox3 = (CheckBox)
                        findViewById(R.id.checkBox3);
                checkBox3.setText(Questions[(index + 3)]);
                TextView checkBox4 = (CheckBox)
                        findViewById(R.id.checkBox4);
                checkBox4.setText(Questions[(index + 4)]);
                TextView Quest = (TextView)
                        findViewById(R.id.Question1);
                Quest.setText(Questions[index]);
                unCheck();
            }
        }
        else
        {
            button.setText("I've Been Clicked!");
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
        if ((index + 5) <= 19) {
            index = index + 5;
            TextView checkBox1 = (CheckBox)
                    findViewById(R.id.checkBox1);
            checkBox1.setText(Questions[(index + 1)]);
            TextView checkBox2 = (CheckBox)
                    findViewById(R.id.checkBox2);
            checkBox2.setText(Questions[(index + 2)]);
            TextView checkBox3 = (CheckBox)
                    findViewById(R.id.checkBox3);
            checkBox3.setText(Questions[(index + 3)]);
            TextView checkBox4 = (CheckBox)
                    findViewById(R.id.checkBox4);
            checkBox4.setText(Questions[(index + 4)]);
            TextView Quest = (TextView)
                    findViewById(R.id.Question1);
            Quest.setText(Questions[index]);
            unCheck();
        }
    }

    public void prevQ(){
        if (index>=5) {
            index = index - 5;
            TextView checkBox1 = (CheckBox)
                    findViewById(R.id.checkBox1);
            checkBox1.setText(Questions[(index + 1)]);
            TextView checkBox2 = (CheckBox)
                    findViewById(R.id.checkBox2);
            checkBox2.setText(Questions[(index + 2)]);
            TextView checkBox3 = (CheckBox)
                    findViewById(R.id.checkBox3);
            checkBox3.setText(Questions[(index + 3)]);
            TextView checkBox4 = (CheckBox)
                    findViewById(R.id.checkBox4);
            checkBox4.setText(Questions[(index + 4)]);
            TextView Quest = (TextView)
                    findViewById(R.id.Question1);
            Quest.setText(Questions[index]);
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
