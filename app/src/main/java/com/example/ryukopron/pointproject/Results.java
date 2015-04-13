package com.example.ryukopron.pointproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.String;


public class Results extends ActionBarActivity {

    Question questionSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_management, menu);
        setContentView(R.layout.activity_results);
        questionSet = (Question) getApplication();
        int counter = 0;
        int answercount = 0;
        int listposition = 0;
        int tempcounter = 0;
        int questionPosition = 0;
        final String[] QuestionsList = new String[(questionSet.resultCount())];
        final String[] ResultsList = new String[(questionSet.resultCount())];
        while (counter < questionSet.QuestionCount) {
            QuestionsList[listposition] = questionSet.Questions[counter];
            listposition++;
            answercount = questionSet.answerCount[counter];
            while (tempcounter < answercount) {
                QuestionsList[listposition] = questionSet.answerList[(tempcounter + questionPosition)];
                listposition++;
                //QuestionsList[listposition] = questionSet.results[(tempcounter + questionPosition)].toString();
                //listposition++;
                tempcounter = (tempcounter + 1);
            }
            QuestionsList[listposition] = " ";
            listposition++;
            questionPosition = (questionPosition + answercount);
            tempcounter = 0;
            counter = (counter + 1);
        }
        counter = 0;
        listposition = 0;
        questionPosition = 0;
        while (counter < questionSet.QuestionCount) {
            ResultsList[listposition] = " ";
            listposition++;
            answercount = questionSet.answerCount[counter];
            while (tempcounter < answercount) {
                //QuestionsList[listposition] = questionSet.answerList[(tempcounter + questionPosition)];
                //listposition++;
                ResultsList[listposition] = questionSet.results[(tempcounter + questionPosition)].toString();
                listposition++;
                tempcounter = (tempcounter + 1);
            }
            ResultsList[listposition] = " ";
            listposition++;
            questionPosition = (questionPosition + answercount);
            tempcounter = 0;
            counter = (counter + 1);
        }

        ArrayAdapter<String> myAdapter = new
                ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_2, android.R.id.text1, QuestionsList) {
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                        TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                        text1.setText(QuestionsList[position]);
                        text2.setText(ResultsList[position]);
                        return view;
                    }
                };
        ListView myList = (ListView) findViewById(R.id.resultsList);
        myList.setAdapter(myAdapter);
        return true;
    }

    public void exitbuttonOnClick(View v) {
        ImageButton button = (ImageButton) v;
        if (button.getId() == R.id.exitsButton) {
            int counter = questionSet.resultCount();
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
}
