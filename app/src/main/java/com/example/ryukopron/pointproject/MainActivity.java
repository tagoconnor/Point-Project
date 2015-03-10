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


    public String[] Questions = {"Which describes you most","Student 18-21","Student 21+","Faculty","Non-Student","How was your visit","Excellent","Good","Fair","Poor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonOnClick(View v) {
        Button button=(Button) v;
        button.setText("I've Been Clicked!");
        TextView checkBox1 = (CheckBox)
                findViewById(R.id.checkBox1);
        checkBox1.setText(Questions[1]);
        TextView checkBox2 = (CheckBox)
                findViewById(R.id.checkBox2);
        checkBox2.setText("HASHTAG");
        TextView checkBox3 = (CheckBox)
                findViewById(R.id.checkBox3);
        checkBox3.setText("YOLO");
        TextView checkBox4 = (CheckBox)
                findViewById(R.id.checkBox4);
        checkBox4.setText("SWAG");
        TextView Quest = (TextView)
                findViewById(R.id.Question1);
        Quest.setText(Questions[0]);
    }

    public void nextQ(){
        //increment question
    }

    public void prevQ(){
        //increment question
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
