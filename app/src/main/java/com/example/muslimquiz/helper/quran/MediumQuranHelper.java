package com.example.muslimquiz.helper.quran;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.muslimquiz.model.EasyQuranModel;

import java.util.ArrayList;
import java.util.List;

public class MediumQuranHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "TQuizMedium.db";

    //If you want to add more questions or wanna update table values
    //or any kind of modification in db just increment version no.
    private static final int DB_VERSION = 3;
    //Table name
    private static final String TABLE_NAME = "TM";
    //Id of question
    private static final String UID = "_UID";
    //Question
    private static final String QUESTION = "QUESTION";
    //Option A
    private static final String OPTA = "OPTA";
    //Option B
    private static final String OPTB = "OPTB";
    //Option C
    private static final String OPTC = "OPTC";
    //Option D
    private static final String OPTD = "OPTD";
    //Answer
    private static final String ANSWER = "ANSWER";
    //So basically we are now creating table with first column-id , sec column-question , third column -option A, fourth column -option B , Fifth column -option C , sixth column -option D , seventh column - answer(i.e ans of  question)
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";
    //Drop table query
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public MediumQuranHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void allQuestion(){
        ArrayList<EasyQuranModel> arrayList = new ArrayList<>();
        arrayList.add(new EasyQuranModel("Terdiri dari 110 ayat, pelindung dari fitnah dajjal", "Al-Kahfi", "Al-Imran", "Al-Baqarah", "Al-Maun", "Al-Kahfi"));
        arrayList.add(new EasyQuranModel("Menjelaskan betapa pentingnya menggunakan waktu untuk mengerjakan amalan shaleh, terdiri dari 3 ayat", "Al-Kautsar", "Al-Nashr", "Al-Asr", "Al-Ikhlas", "Al-Asr"));
        arrayList.add(new EasyQuranModel("Terdiri dari 4 ayat, Menjelaskana keesaan Allah", "Al-Quraisy", "Al-Ikhlas", "Al-Falaq", "An-Nas", "Al-Ikhlas"));
        arrayList.add(new EasyQuranModel("Memiliki arti Sapi Betina", "Al-Fill", "An-Naml", "An-Nahl", "Al-Baqarah", "Al-Baqarah"));
        arrayList.add(new EasyQuranModel("Memiliki arti semut", "Al-Dzariyat", "An-Naml", "Al-Fill", "Al-Nahl", "An-Naml"));
        this.addAllQuestions(arrayList);
    }

    private void addAllQuestions(ArrayList<EasyQuranModel> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (EasyQuranModel question : allQuestions) {
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOptA());
                values.put(OPTB, question.getOptB());
                values.put(OPTC, question.getOptC());
                values.put(OPTD, question.getOptD());
                values.put(ANSWER, question.getAnswer());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    public List<EasyQuranModel> getAllOfTheQuestions() {

        List<EasyQuranModel> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            EasyQuranModel question = new EasyQuranModel();
            question.setId(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setOptA(cursor.getString(2));
            question.setOptB(cursor.getString(3));
            question.setOptC(cursor.getString(4));
            question.setOptD(cursor.getString(5));
            question.setAnswer(cursor.getString(6));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }

}
