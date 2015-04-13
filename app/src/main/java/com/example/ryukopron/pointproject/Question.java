package com.example.ryukopron.pointproject;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Home on 3/20/2015.
 */


public class Question extends Application {
    public String userName = "";
    public String password = "";
    public Integer QuestionID = -1;
    public Integer QuestionCount = 1;
    public String[] Questions = new String[100];
    public Integer[] answerCount = new Integer[100];
    public Boolean[] status =  new Boolean[100];
    public String[] answerList = new String[400];
    public Integer[] results = new Integer[400];

    public void readData(){
        Integer lineCount = 0;
        Integer count = 0;
        Integer tempCount = 0;
        Integer questionPosition = 0;
        Integer arrayPosition = 1;
        try {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(openFileInput("testOutputFile")));
            String inputString;
            StringBuffer stringBuffer = new StringBuffer();
            userName = inputReader.readLine();
            password = inputReader.readLine();
            inputString = inputReader.readLine();
            QuestionCount = Integer.parseInt(inputString);
            while (count < QuestionCount) {

                Questions[count] = inputReader.readLine();
                status[count] = Boolean.parseBoolean(inputReader.readLine());
                answerCount[count] = Integer.parseInt(inputReader.readLine());

                while (tempCount < answerCount[count]) {

                    answerList[(tempCount + questionPosition)] = inputReader.readLine();
                    results[(tempCount + questionPosition)] = Integer.parseInt(inputReader.readLine());
                    tempCount = (tempCount + 1);
                }
                questionPosition = (questionPosition + answerCount[count]);
                tempCount = 0;
                count = (count + 1);
            }
            inputReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveQuestionData(int answers, String[] data){
        int count = 0;
        int tempCount = 0;
        int questionPosition = 0;
        try {
            FileOutputStream fos = openFileOutput("testOutputFile", Context.MODE_PRIVATE);
            fos.write(userName.getBytes());
            fos.write("\n".getBytes());
            fos.write(password.getBytes());
            fos.write("\n".getBytes());
            fos.write(QuestionCount.toString().getBytes());
            fos.write("\n".getBytes());
            while (count < QuestionCount) {
                if (count == QuestionID){
                    fos.write(data[0].getBytes());
                    fos.write("\ntrue\n".getBytes());
                    fos.write(Integer.toString(answers).getBytes());
                    fos.write("\n".getBytes());
                    while (tempCount < answers) {
                        fos.write(data[(tempCount+1)].getBytes());
                        fos.write("\n0\n".getBytes());
                        tempCount = (tempCount + 1);

                    }
                    questionPosition = (questionPosition + answerCount[count]);
                    tempCount = 0;
                    count = (count + 1);
                }
                else {
                    fos.write(Questions[count].getBytes());
                    fos.write("\n".getBytes());
                    fos.write(status[count].toString().getBytes());
                    fos.write("\n".getBytes());
                    fos.write(answerCount[count].toString().getBytes());
                    fos.write("\n".getBytes());
                    while (tempCount < answerCount[count]) {
                        fos.write(answerList[(tempCount + questionPosition)].getBytes());
                        fos.write("\n".getBytes());
                        fos.write(results[(tempCount + questionPosition)].toString().getBytes());
                        fos.write("\n".getBytes());
                        tempCount = (tempCount + 1);
                    }
                    questionPosition = (questionPosition + answerCount[count]);
                    tempCount = 0;
                    count = (count + 1);
                }
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int resultCount(){
        int result = (2*QuestionCount);
        int tempCount;
        for (tempCount = 0; tempCount < QuestionCount; tempCount ++){
            result = (result + ((answerCount[tempCount])));
        }
        return result;
    }

    public void saveSurveyData(int[] votes){
        int count = 0;
        int tempCount = 0;
        int questionPosition = 0;
        try {
            FileOutputStream fos = openFileOutput("testOutputFile", Context.MODE_PRIVATE);
            fos.write(userName.getBytes());
            fos.write("\n".getBytes());
            fos.write(password.getBytes());
            fos.write("\n".getBytes());
            fos.write(QuestionCount.toString().getBytes());
            fos.write("\n".getBytes());
            while (count < QuestionCount) {
                fos.write(Questions[count].getBytes());
                fos.write("\n".getBytes());
                fos.write(status[count].toString().getBytes());
                fos.write("\n".getBytes());
                fos.write(answerCount[count].toString().getBytes());
                fos.write("\n".getBytes());
                while (tempCount < answerCount[count]) {
                    fos.write(answerList[(tempCount + questionPosition)].getBytes());
                    fos.write("\n".getBytes());
                    if (votes[count]==tempCount) {
                        results[(tempCount + questionPosition)] = (results[(tempCount + questionPosition)]+1);
                    }
                    fos.write(results[(tempCount + questionPosition)].toString().getBytes());
                    fos.write("\n".getBytes());
                    tempCount = (tempCount + 1);

                }
                questionPosition = (questionPosition + answerCount[count]);
                tempCount = 0;
                count = (count + 1);
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

