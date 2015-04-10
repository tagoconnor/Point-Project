package com.example.ryukopron.pointproject;

import android.app.Application;

/**
 * Created by Home on 3/20/2015.
 */


public class Question extends Application {
    public Integer QuestionID = 0;
    public Integer QuestionCount = 1;
    public String[] Questions = new String[100];
    public Integer[] answerCount = new Integer[100];
    public Boolean[] status =  new Boolean[100];
    public String[] answerList = new String[400];
    public Integer[] results = new Integer[400];
}

