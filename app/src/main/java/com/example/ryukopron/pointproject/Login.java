package com.example.ryukopron.pointproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.lang.String;


public class Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        setContentView(R.layout.activity_login);
        return true;
    }

    public void ManagebuttonOnClick(View v) {
        ImageButton button = (ImageButton) v;
        if (button.getId() == R.id.imageButton3){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }

    public void submitButtonOnClick(View v) {
        Button button = (Button) v;
        if (button.getId() == R.id.submitButton){
            EditText username = (EditText) findViewById(R.id.usernameTextbox);
            EditText password = (EditText) findViewById(R.id.passwordTextbox);
            String usern = username.getText().toString();
            String passn = password.getText().toString();

            // Here is the password! admin admin
            // At some point we will have to add this to the database/textfile so it can be edited

            if (usern.equals("admin")){
                if (passn.equals("admin")){
                     startActivity(new Intent(getApplicationContext(), ManageMenu.class));
                }
            }
            else {
                TextView errorText = (TextView) findViewById(R.id.textView4);
                errorText.setVisibility(View.VISIBLE);
                username.setText("");
                password.setText("");
            }
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
