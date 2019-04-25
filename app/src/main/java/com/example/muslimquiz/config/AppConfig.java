package com.example.muslimquiz.config;

public class AppConfig {

    public static final String DATABASE_NAME = "DEMOGAMEDBB";
    public static final String DATABASE_NAME_HADIST = "DEMOGAMEDBB_HADIST";
    //If any modifications in the table or db just increment this no
    public static int DATABASE_VERSION = 1035;
    //Table one
    public static final String TABLE_NAME = "TRIVIAQUIZ";
    public static final String TABLE_NAME_HADIST = "TRIVIAQUIZ_HADIST";
    public static final String UID = "_UID";
    public static final String UID_HADIST = "_UID_HADIST";
    public static final String QUESTION = "QUESTION";
    public static final String QUESTION_HADIST = "QUESTION_HADIST";
    public static final String ANSWER = "ANSWER";
    public static final String ANSWER_HADIST = "ANSWER_HADIST";
    public static final String ANSWER2 = "ANSWER2";
    public static final String ANSWER2_HADIST = "ANSWER2_HADIST";
    public static final String RANDOMANS1 = "RANDOMANS1";
    public static final String RANDOMANS1_HADIST = "RANDOMANS1_HADIST";
    public static final String RANDOMANS2 = "RANDOMANS2";
    public static final String RANDOMANS2_HADIST = "RANDOMANS2_HADIST";
    public static final String USELESSSTRING = "USELESSSTRING";
    //first - que , sec -correct ans part1 , third - correct ans part2 , fourth - the letters below boxes row 1 , fifth - the letters below boxes row 2  ,sixth - the useless char in below boxes which is not the part of ans
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + ANSWER + " VARCHAR(255), " + ANSWER2 + " VARCHAR(255), " + RANDOMANS1 + " VARCHAR(255), " + RANDOMANS2 + " VARCHAR(255), " + USELESSSTRING + " VARCHAR(255));";
    public static final String CREATE_TABLE_HADIST = "CREATE TABLE " + TABLE_NAME_HADIST + " ( " + UID_HADIST + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION_HADIST + " VARCHAR(255), " + ANSWER_HADIST + " VARCHAR(255), " + ANSWER2_HADIST + " VARCHAR(255), " + RANDOMANS1_HADIST + " VARCHAR(255), " + RANDOMANS2_HADIST + " VARCHAR(255), " + USELESSSTRING+ " VARCHAR(255));";
    //Table two
    public static String TABLE_NAME2 = "TRIVIAQUIZ2";
    public static final String CORRECTNO = "CORRECTNO";
    public static final String CREATE_TABLE2 = "CREATE TABLE " + TABLE_NAME2 + " ( " + CORRECTNO + " INTEGER );";
    //HADIST
    public static String TABLE_NAME2_HADIST = "TRIVIAQUIZ2_HADIST";
    public static final String CORRECTNO_HADIST = "CORRECTNO_HADIST";
    public static final String CREATE_TABLE2_HADIST = "CREATE TABLE " + TABLE_NAME2_HADIST + " ( " + CORRECTNO_HADIST + " INTEGER );";
    //Table three
    public static String TABLE_NAME3 = "TRIVIAQUIZ3";
    public static final String HINTID = "HINTID";
    public static final String CREATE_TABLE3 = "CREATE TABLE " + TABLE_NAME3 + " ( " + HINTID + " INTEGER );";
    public static final String DROP_TABLE3 = "DROP TABLE IF EXISTS " + TABLE_NAME3;
    //HADIST
    public static String TABLE_NAME3_HADIST = "TRIVIAQUIZ3_HADIST";
    public static final String HINTID_HADIST = "HINTID_HADIST";
    public static final String CREATE_TABLE3_HADIST = "CREATE TABLE " + TABLE_NAME3_HADIST + " ( " + HINTID_HADIST + " INTEGER );";
    public static final String DROP_TABLE3_HADIST = "DROP TABLE IF EXISTS " + TABLE_NAME3_HADIST;
    //Table four
    public static String TABLE_NAME4 = "TRIVIAQUIZ4";
    public static final String ID= "ID";
    public static final String ONE= "ONE";
    public static final String TWO = "TWO";
    public static final String THREE = "THREE";
    public static final String FOUR = "FOUR";
    public static final String FIVE = "FIVE";
    public static final String CREATE_TABLE4 = "CREATE TABLE " + TABLE_NAME4 + " ( " + ID + " INTEGER , " + ONE + " INTEGER , " + TWO + " INTEGER , " + THREE + " INTEGER , " + FOUR + " INTEGER , " + FIVE + " INTEGER);";
    public static final String DROP_TABLE4 = "DROP TABLE IF EXISTS " + TABLE_NAME4;
    //HADIST
    public static String TABLE_NAME4_HADIST = "TRIVIAQUIZ4_HADIST";
    public static final String ID_HADIST= "ID_HADIST";
    public static final String ONE_HADIST= "ONE_HADIST";
    public static final String TWO_HADIST = "TWO_HADIST";
    public static final String THREE_HADIST = "THREE_HADIST";
    public static final String FOUR_HADIST = "FOUR_HADIST";
    public static final String FIVE_HADIST = "FIVE_HADIST";
    public static final String CREATE_TABLE4_HADIST = "CREATE TABLE " + TABLE_NAME4_HADIST + " ( " + ID_HADIST + " INTEGER , " + ONE_HADIST + " INTEGER , " + TWO_HADIST + " INTEGER , " + THREE_HADIST + " INTEGER , " + FOUR_HADIST + " INTEGER , " + FIVE_HADIST + " INTEGER);";
    public static final String DROP_TABLE4_HADIST = "DROP TABLE IF EXISTS " + TABLE_NAME4_HADIST;
    //Table five
    public static String TABLE_NAME8 = "TRIVIAQUIZ8";
    public static final String GEMS = "GEMS";
    public static final String CREATE_TABLE8 = "CREATE TABLE " + TABLE_NAME8 + " ( " + GEMS + " INTEGER );";
    //HADIST
    public static String TABLE_NAME8_HADIST = "TRIVIAQUIZ8_HADIST";
    public static final String GEMS_HADIST = "GEMS_HADIST";
    public static final String CREATE_TABLE8_HADIST = "CREATE TABLE " + TABLE_NAME8_HADIST + " ( " + GEMS_HADIST + " INTEGER );";
    //Table six
    public static String TABLE_NAME11 = "TRIVIAQUIZ11";
    public static final String storePauseValue = "storePauseValue";
    public static final String CREATE_TABLE11 = "CREATE TABLE " + TABLE_NAME11 + " ( " + storePauseValue + " INTEGER );";
    //HADIST
    public static String TABLE_NAME11_HADIST = "TRIVIAQUIZ11_HADIST";
    public static final String storePauseValue_HADIST = "storePauseValue_HADIST";
    public static final String CREATE_TABLE11_HADIST = "CREATE TABLE " + TABLE_NAME11_HADIST + " ( " + storePauseValue_HADIST + " INTEGER );";
    //Table seven
    public static String TABLE_NAME12 = "TRIVIAQUIZ12";
    public static final String BOOM = "BOOM";
    public static final String CREATE_TABLE12 = "CREATE TABLE " + TABLE_NAME12 + " ( " + BOOM + " INTEGER );";
    //HADIST
    public static String TABLE_NAME12_HADIST = "TRIVIAQUIZ12_HADIST";
    public static final String BOOM_HADIST = "BOOM_HADIST";
    public static final String CREATE_TABLE12_HADIST = "CREATE TABLE " + TABLE_NAME12_HADIST + " ( " + BOOM_HADIST + " INTEGER );";
    //Table eight
    public static String TABLE_NAME13 = "TRIVIAQUIZ13";
    public static final String SOUND = "SOUND";
    public static final String CREATE_TABLE13 = "CREATE TABLE " + TABLE_NAME13 + " ( " + SOUND + " INTEGER );";
    //HADIST
    public static String TABLE_NAME13_HADIST = "TRIVIAQUIZ13_HADIST";
    public static final String SOUND_HADIST = "SOUND_HADIST";
    public static final String CREATE_TABLE13_HADIST = "CREATE TABLE " + TABLE_NAME13_HADIST + " ( " + SOUND_HADIST + " INTEGER );";
    //Table nine
    public static String TABLE_NAME14 = "TRIVIAQUIZ14";
    public static final String CHEKQADDED = "CHEKQADDED";
    public static final String CREATE_TABLE14 = "CREATE TABLE " + TABLE_NAME14 + " ( " + CHEKQADDED + " INTEGER );";
    //HADIST
    public static String TABLE_NAME14_HADIST = "TRIVIAQUIZ14_HADIST";
    public static final String CHEKQADDED_HADIST = "CHEKQADDED_HADIST";
    public static final String CREATE_TABLE14_HADIST = "CREATE TABLE " + TABLE_NAME14_HADIST + " ( " + CHEKQADDED_HADIST + " INTEGER );";

}
