package com.example.ryukopron.pointproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


public class ManagementActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_management, menu);
        setContentView(R.layout.activity_management);
       // TextView testText = (TextView) findViewById(R.id.textView5);
        final Question questionSet = (Question) getApplication();

        //testText.setText(s);
        int counter = 0;
        String[] QuestionsList = new String[(questionSet.QuestionCount)];
        while (counter < questionSet.QuestionCount) {
            QuestionsList[counter] = questionSet.Questions[counter];
            counter = (counter + 1);
        }
        // This QuestionsList string fills the text box by loading Questions from our array.
        // Will work for any amount of questions, adding scroll bar if needed.

        ArrayAdapter<String> myAdapter = new
                ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                QuestionsList);
        ListView myList = (ListView) findViewById(R.id.listView);
        myList.setAdapter(myAdapter);


        //this gets the ID of the question you click on and takes you to the edit page.

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {

                // We know the View is a TextView so we can cast it
                TextView clickedView = (TextView) view;

                //TextView testText = (TextView) findViewById(R.id.textView5);
               //  testText.setText("The posistion is ["+position+"]");
                questionSet.QuestionID = position;
                startActivity(new Intent(getApplicationContext(), QuestionEdit.class));
            }
        });
        return true;
    }


    public void exitbuttonOnClick(View v) {
        ImageButton button = (ImageButton) v;
        if (button.getId() == R.id.imageButton2) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
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

    public void createNewButtonOnClick(View v) {
        Button button = (Button) v;
        if (button.getId() == R.id.Newbutton){
            startActivity(new Intent(getApplicationContext(), QuestionEdit.class));
        }
    }

    public void returnbuttonOnClick(View v) {
        ImageButton button = (ImageButton) v;
        if (button.getId() == R.id.imageButton2){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }
}
