package com.example.ryukopron.pointproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Thanks extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_thanks, menu);
        return true;
    }

    public void finishButtonOnClick(View v) {
        Button button = (Button) v;
        if (button.getId() == R.id.finishButton) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }

    public void ManagebuttonOnClick(View v) {
        ImageButton button = (ImageButton) v;
        if (button.getId() == R.id.imageButton6){
            startActivity(new Intent(getApplicationContext(), Login.class));
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
