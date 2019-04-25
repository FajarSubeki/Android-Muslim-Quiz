package com.example.muslimquiz.helper.quran;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.muslimquiz.model.EasyQuranModel;

import java.util.ArrayList;
import java.util.List;

public class EasyQuranHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "TQuiz.db";

    //If you want to add more questions or wanna update table values
    //or any kind of modification in db just increment version no.
    private static final int DB_VERSION = 3;
    //Table name
    private static final String TABLE_NAME = "TQ";
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

    public EasyQuranHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void allQuestion(){
        ArrayList<EasyQuranModel> arrayList = new ArrayList<>();
        arrayList.add(new EasyQuranModel("Al-Quran menurut bahasa", "Bacaan", "Tulisan", "Berbicara", "Perkataan", "Bacaan"));
        arrayList.add(new EasyQuranModel("Al-Quran diturunkan kepada nabi", "Nabi Musa", "Nabi Ibrahim", "Nabi Muhammad", "Nabi Daud", "Nabi Muhammad"));
        arrayList.add(new EasyQuranModel("Surat pertama dalam Al-Quran", "Al-Baqarah", "Al-Imran", "An-Nas", "Al-Fatihah", "Al-Fatihah"));
        arrayList.add(new EasyQuranModel("Surat terakhir dalam Al-Quran", "Al-Alaq", "An-Nas", "An-Naba", "Al-Ala", "An-Nas"));
        arrayList.add(new EasyQuranModel("Berapakah jumlah surat dalam Al-Quran", "114", "110", "111", "121", "114"));
//        arrayList.add(new EasyQuranModel("Berapakah jumlah juz dalam Al-Quran", "29", "30", "31", "32", "30"));
//        arrayList.add(new EasyQuranModel("Malaikat yang bertugas menyampaikan ayat Al-Quran kepada Rasulullah", "Malaikat Mikail", "Malaikat Israfil", "Malaikat Raqib", "Malaikat Jibril", "Malaikat Jibril"));
//        arrayList.add(new EasyQuranModel("Ayat pertama kali turun kepada Nabi Muhammad adalah", "Al-Alaq 1-5", "Al-Fatihah 1-7", "Al-Ala 1-5", "An-Nas 1-6", "Al-Alaq 1-5"));
//        arrayList.add(new EasyQuranModel("Surat yang diturunkan di Kota Mekkah disebut juga dengan surat", "Makkiyah", "Madaniyah", "Mekkah", "Madinah", "Makkiyah"));
//        arrayList.add(new EasyQuranModel("Surat yang diturunkan di Kota Madinah disebut juga denga surat", "Makkiyah", "Mekah", "Madinah", "Madaniyah", "Madaniyah"));
//        arrayList.add(new EasyQuranModel("Surat Al-Baqarah memiliki arti", "Sapi Betina", "Lebah", "Semut", "Besi", "Sapi Betina"));
//        arrayList.add(new EasyQuranModel("Berikut ini nama surat yang memiliki arti hewan, kecuali", "Al-Ankabut", "Al-Fill", "An-Naml", "Al-Hadid", "Al-Hadid"));
//        arrayList.add(new EasyQuranModel("Surat yang menjelaskan pasukan gajah abrahah menyerang Kabah", "Al-Fill", "Al-Imran", "Al-Maun", "An-Nahl", "Al-Fill"));
//        arrayList.add(new EasyQuranModel("Berikut nama surat Al-Quran yang merupakan nama nabi", "Harun", "Ibrahim", "Ilyas", "Isya", "Ibrahim"));
//        arrayList.add(new EasyQuranModel("Surat pendek yang menjelaskan tentang keesaan Allah", "Al-Fatihah", "Al-Fill", "Al-Ikhlas", "Al-Asr", "Al-Ikhlas"));
//        arrayList.add(new EasyQuranModel("Arti Adz-Zikr", "Peringatan", "Cahaya", "Pemberi", "Petunjuk", "Peringatan"));
//        arrayList.add(new EasyQuranModel("Arti Al-Huda", "Pemberi", "Pemaaf", "Pelindung", "Petunjuk", "Petunjuk"));
//        arrayList.add(new EasyQuranModel("Surat pendek yang menjelaskan betapa pentingnya memanfaat waktu sebagai bekal kehidupan di akhirat", "Al-Maun", "Al-Asr", "Al-Qurais", "Al-Kautsar", "Al-Asr"));
//        arrayList.add(new EasyQuranModel("Al-Quran turun pada bulan", "Ramadhan", "Syawal", "Miraj", "Jumadil Awal", "Ramadhan"));
//        arrayList.add(new EasyQuranModel("Al-Quran pertama kali diturunkan di gua", "Kahfi", "Hira", "Uhud", "Tsur", "Hira"));

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
