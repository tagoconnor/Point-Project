package com.example.ryukopron.pointproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Amanda on 3/27/2015.
 */
public class DatabaseQuerys extends SQLiteOpenHelper{

    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + QandA.TableInfo.TABLE_NAME + "(" + QandA.TableInfo.QID + " INT,"
            + /*QandA.TableInfo.AnswerCount + " INT," + */ QandA.TableInfo.UseQ + " BOOL," + QandA.TableInfo.Answer1 + " TEXT,"
            + QandA.TableInfo.Result1 + " INT," + QandA.TableInfo.Answer2 + " TEXT," + QandA.TableInfo.Result2 + " INT,"
            + QandA.TableInfo.Answer3 + " TEXT," + QandA.TableInfo.Result3 + " INT," + QandA.TableInfo.Answer4 + " TEXT,"
            + QandA.TableInfo.Result4 + " INT);" ;

    public DatabaseQuerys(Context context){
        super(context, QandA.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations", "Database Created");

    }

    @Override
    public void onCreate(SQLiteDatabase sdb){

        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table Created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){}

    public void INSERT(DatabaseQuerys Query, Integer QID, String Question, /*Integer AnswerCount,*/ Boolean UseQ,String Answer1, Integer Result1, String Answer2, Integer Result2, String Answer3, Integer Result3, String Answer4, Integer Result4){
        SQLiteDatabase SQ = Query.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(QandA.TableInfo.QID, QID);
        cv.put(QandA.TableInfo.Question, Question);
        //cv.put(QandA.TableInfo.AnswerCount, AnswerCount);
        cv.put(QandA.TableInfo.UseQ, UseQ);
        cv.put(QandA.TableInfo.Answer1, Answer1);
        cv.put(QandA.TableInfo.Answer2, Answer2);
        cv.put(QandA.TableInfo.Answer3, Answer3);
        cv.put(QandA.TableInfo.Answer4, Answer4);
        cv.put(QandA.TableInfo.Result1, Result1);
        cv.put(QandA.TableInfo.Result2, Result2);
        cv.put(QandA.TableInfo.Result3, Result3);
        cv.put(QandA.TableInfo.Result4, Result4);
        SQ.insert(QandA.TableInfo.TABLE_NAME, null, cv);
        Log.d("Database operations", "Row Inserted");


    }

    public Cursor getInformation(DatabaseQuerys dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] columns = {QandA.TableInfo.QID,QandA.TableInfo.Question, QandA.TableInfo.UseQ, QandA.TableInfo.Answer1,
                QandA.TableInfo.Result1, QandA.TableInfo.Answer2, QandA.TableInfo.Result2, QandA.TableInfo.Answer3,
                QandA.TableInfo.Answer4, QandA.TableInfo.Result4};
        Cursor CR = SQ.query(QandA.TableInfo.TABLE_NAME,columns, null, null, null, null, null);
        return CR;


    }


}
