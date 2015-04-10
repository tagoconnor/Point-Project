package com.example.ryukopron.pointproject;

import android.provider.BaseColumns;

/**
 * Created by Amanda
 */
public class QandA {

    public QandA()
    {

    }
    public static abstract class TableInfo implements BaseColumns
    {

    public static String QID = "-1";
    public static String Question = "?";
    //public static final String AnswerCount = -1;
    //public static String UseQ = "false";
    public static String Answer1 = null;
    public static String Result1 = null;
    public static String Answer2 = null;
    public static String Result2 = null;
    public static String Answer3 = null;
    public static String Result3 = null;
    public static String Answer4 = null;
    public static String Result4 = null;
    public static String DATABASE_NAME = "survey.db";
    public static String TABLE_NAME = "QandA";

    }
}
