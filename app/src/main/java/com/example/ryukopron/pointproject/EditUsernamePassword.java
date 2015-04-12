package com.example.ryukopron.pointproject;

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

import java.util.Arrays;


public class EditUsernamePassword extends ActionBarActivity {
    Question questionSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_username_password);
        questionSet = (Question) getApplication();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_username_password, menu);
        return true;
    }

    public void saveOnClick(View v) {
        Button button = (Button) v;
        int nullarray[] = new int[100];
        Arrays.fill(nullarray, -1);
        EditText currentUsername= (EditText) findViewById(R.id.currentUsername);
        EditText currentPassword= (EditText) findViewById(R.id.currentPassword);
        EditText newUsername= (EditText) findViewById(R.id.newUsername);
        EditText newPassword= (EditText) findViewById(R.id.newPassword);
        EditText confirmedPassword= (EditText) findViewById(R.id.confirmedPassword);
        TextView warningText = (TextView) findViewById(R.id.warningtext);

        if (button.getId() == R.id.savebutton) {
            if (currentUsername.getText().toString().length() > 4 && currentPassword.getText().toString().length() > 4 && newUsername.getText().toString().length() > 4 && newPassword.getText().toString().length() > 4 && confirmedPassword.getText().toString().length() > 4) {
                if(currentUsername.getText().toString().equals(questionSet.userName) && currentPassword.getText().toString().equals(questionSet.password)){
                    if(newPassword.getText().toString().equals(confirmedPassword.getText().toString())){
                        questionSet.userName = newUsername.getText().toString();
                        questionSet.password = newPassword.getText().toString();
                        //warningText.setText("Login Information Saved");
                        questionSet.saveSurveyData(nullarray);
                        warningText.setText("Login Information Saved");
                        warningText.setVisibility(View.VISIBLE);
                    }
                    else{
                        warningText.setText("New password does not match confirmation password");
                        warningText.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    warningText.setText("Invalid current username and password");
                    warningText.setVisibility(View.VISIBLE);
                }
            }
            else {
                warningText.setText("Usernames and Passwords must be at least 5 characters");
                warningText.setVisibility(View.VISIBLE);
            }
        }
    }

    public void exitbuttonOnClick(View v) {
        ImageButton button = (ImageButton) v;
        if (button.getId() == R.id.imageButton8) {
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
