package com.example.muslimquiz.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.muslimquiz.config.AppConfig;
import com.example.muslimquiz.model.Questions;

import java.util.ArrayList;
import java.util.List;

import static com.example.muslimquiz.config.AppConfig.ANSWER;
import static com.example.muslimquiz.config.AppConfig.ANSWER2;
import static com.example.muslimquiz.config.AppConfig.BOOM;
import static com.example.muslimquiz.config.AppConfig.CHEKQADDED;
import static com.example.muslimquiz.config.AppConfig.CORRECTNO;
import static com.example.muslimquiz.config.AppConfig.FIVE;
import static com.example.muslimquiz.config.AppConfig.FOUR;
import static com.example.muslimquiz.config.AppConfig.GEMS;
import static com.example.muslimquiz.config.AppConfig.HINTID;
import static com.example.muslimquiz.config.AppConfig.ID;
import static com.example.muslimquiz.config.AppConfig.ONE;
import static com.example.muslimquiz.config.AppConfig.QUESTION;
import static com.example.muslimquiz.config.AppConfig.RANDOMANS1;
import static com.example.muslimquiz.config.AppConfig.RANDOMANS2;
import static com.example.muslimquiz.config.AppConfig.SOUND;
import static com.example.muslimquiz.config.AppConfig.TABLE_NAME;
import static com.example.muslimquiz.config.AppConfig.TABLE_NAME11;
import static com.example.muslimquiz.config.AppConfig.TABLE_NAME12;
import static com.example.muslimquiz.config.AppConfig.TABLE_NAME13;
import static com.example.muslimquiz.config.AppConfig.TABLE_NAME14;
import static com.example.muslimquiz.config.AppConfig.TABLE_NAME2;
import static com.example.muslimquiz.config.AppConfig.TABLE_NAME3;
import static com.example.muslimquiz.config.AppConfig.TABLE_NAME4;
import static com.example.muslimquiz.config.AppConfig.TABLE_NAME8;
import static com.example.muslimquiz.config.AppConfig.THREE;
import static com.example.muslimquiz.config.AppConfig.TWO;
import static com.example.muslimquiz.config.AppConfig.UID;
import static com.example.muslimquiz.config.AppConfig.USELESSSTRING;

public class Helper extends SQLiteOpenHelper {

    Context context;

    public Helper(Context context) {
        super(context, AppConfig.DATABASE_NAME, null, AppConfig.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE2);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE3);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE4);
        //sqLiteDatabase.execSQL(CREATE_TABLE5);
        //sqLiteDatabase.execSQL(CREATE_TABLE6);

        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE8);
        //sqLiteDatabase.execSQL(CREATE_TABLE9);
        //sqLiteDatabase.execSQL(CREATE_TABLE10);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE11);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE12);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE13);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE14);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE2);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE3);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE4);
        //sqLiteDatabase.execSQL(CREATE_TABLE5);
        //sqLiteDatabase.execSQL(CREATE_TABLE6);

        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE8);
        //sqLiteDatabase.execSQL(CREATE_TABLE9);
        //sqLiteDatabase.execSQL(CREATE_TABLE10);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE11);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE12);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE13);
        sqLiteDatabase.execSQL(AppConfig.CREATE_TABLE14);
        onCreate(sqLiteDatabase);
    }

    //It will return the list of qid of which question is solved
    public List<Integer> GetQid() {
        String coloumns[] = {CORRECTNO};
        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME2, coloumns, null, null, null, null, null);
        List<Integer> list = new ArrayList<>();

        while (cursor.moveToNext()) {
            int questionId = cursor.getInt(0);
            list.add(questionId);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list;
    }

    //It will delete all the records i.e reset the game
    public void deleteAllRecord() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_NAME);
        db.execSQL("delete from " + TABLE_NAME2);
        db.execSQL("delete from " + TABLE_NAME3);
        db.execSQL("delete from " + TABLE_NAME4);
        //db.execSQL("delete from " + TABLE_NAME5);
        //db.execSQL("delete from " + TABLE_NAME6);
        /* db.execSQL("delete from " + TABLE_NAME7);*/
        db.execSQL("delete from " + TABLE_NAME8);
        //db.execSQL("delete from " + TABLE_NAME9);
        //db.execSQL("delete from " + TABLE_NAME10);
        db.execSQL("delete from " + TABLE_NAME11);
        db.execSQL("delete from " + TABLE_NAME12);
        db.execSQL("delete from " + TABLE_NAME13);
        db.execSQL("delete from " + TABLE_NAME14);
        db.close();
    }


    //It will return list of qid of which boom is used
    public List getBoomId() {
        String coloumns[] = {BOOM};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME12, coloumns, null, null, null, null, null);
        List<Integer> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            int boomValue = cursor.getInt(0);
            list.add(boomValue);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list;
    }

    //The no at the end of list is the latest value of gem
    public List getGems() {
        String coloumns[] = {GEMS};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME8, coloumns, null, null, null, null, null);
        List<Integer> list2 = new ArrayList<>();
        list2.add(42);

        while (cursor.moveToNext()) {
            int questionId = cursor.getInt(0);
            list2.add(questionId);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list2;
    }

    //Insert the qid of which boom is used
    public void insertBoom(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BOOM, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME12, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public void InsertGems(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(GEMS, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME8, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    //It will return the list which has value "1" if the question are added in the table
    //so will check the size of list if it is greater than zero means que are added
    public  List getCheckQadded() {
        String coloumns[] = {CHEKQADDED};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME14, coloumns, null, null, null, null, null);
        List<Integer> list2 = new ArrayList<>();

        while (cursor.moveToNext()) {
            int questionId = cursor.getInt(0);
            list2.add(questionId);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list2;
    }

    public void addquestions() {
        ArrayList<Questions> allQuestions = new ArrayList<>();

        allQuestions.add(new Questions("Who was the first African American to have served as president of United States of America ?", "BarACk", "ObaMA", "BARIACKTE", "OBMAMAPSF", "ITEMPSF"));

        allQuestions.add(new Questions("Who co-founded Apple company with Steve Wozniak & Ronald Wayne ?", "STEVE", "JOBS", "OAEESVSC", "AWOBFOTJ", "COAOFWA"));

        allQuestions.add(new Questions("Who was the first elected President of South Africa ?", "NELSON", "MANDELA", "PNDAYLELS", "ONNEWMCCA", "CCYPW"));

        allQuestions.add(new Questions("Which German born physicist developed the Special theory of relativity which has the famous equation E = mc^2 ?", "ALBERT", "EINSTEIN", "ISTENIRTN", "LERKELCBA", "LRKC"));

        allQuestions.add(new Questions("Disneyland theme park located in US is the brainchild of which creative genius ?", "WALT", "DISNEY", "ERISWYLA", "DYTNLLVG", "RVLGLY"));

        allQuestions.add(new Questions("Who is know as the 'King of Pop' ?", "MICHAEL", "JACKSON", "MHJSCANCI", "NDEDALKKO", "KNDD"));

        allQuestions.add(new Questions("The war drama film ‘Born on the Fourth of July’ (1989) is one of best known movie of which actor ?", "TOM", "CRUISE", "KCIUYMJR", "SWGCETUO", "KGWJYUC"));

        allQuestions.add(new Questions("Which cricketer is also know as 'God of Cricket'?", "SACHIN", "TENDULKAR", "KDCINLRTE", "HGATUHSAN", "GTH"));

        allQuestions.add(new Questions("Who was the first man ever to walk on the surface of the Moon ?", "NEIL", "ARMSTRONG", "MTOLCRGNX", "CNREAPSIL", "PCLXC"));

        allQuestions.add(new Questions("In 2015, who has been estimated to have a net worth of 1 billion dollars, setting the record of being the first billionaire athlete(Basketball player) ever ?", "MICHAEL", "JORDAN", "RNLIHAEMV", "JDWJCOBCA", "VWJBC"));

        allQuestions.add(new Questions("Who co-founded Microsoft company with Paul Allen, which became the world's largest PC software company ?", "BILL", "GATES", "SLELIILS", "TWSAOBPG", "PWSILOS"));

        allQuestions.add(new Questions("At the 2008 Beijing olympics, which athlete won gold medals in 100m, 200m and 4x100m relay ?", "USAIN", "BOLT", "NQODOLIV", "AWPSTTBU", "VTODQWP"));

        allQuestions.add(new Questions("In 2011 ‘The Karate Kid’ was remade starring  ______ & Jaden Smith in it. The movie was a big success at the box office, earning over 358 million US dollars.", "JACKIE", "CHAN", "RRHREIAA", "KCNZJAGC", "ZGRRAR"));

        allQuestions.add(new Questions("\"_____ Schwarzenegger\"(surname) is an American actor popularly known as \"Terminator\" and was also the former Governor of California ?", "ARNOLD", "", "UDTOLRW", "DNARVSO", "SWOUDTVR"));

        allQuestions.add(new Questions("Who co-founded the social-networking website Facebook out of his college dorm room ?", "MARK", "ZUCKERBERG", "KDBERRUCK", "EKGARZAOM", "OKAD"));

        allQuestions.add(new Questions("Who founded the Missionaries of Charity in Calcutta(INDIA) with the objective of serving the poorest of the poor ?", "MOTHER", "TERESA", "IEWPWRTHR", "ESOTHEAMT", "ITWWHP"));

        allQuestions.add(new Questions("She was posthumously honoured with the Congressional Space Medal of Honor, NASA Space Flight Medal and NASA Distinguished Service Medal. She was Indian American astronaut who died in the Space Shuttle Columbia disaster(2003),Guess her name.", "KALPANA", "CHAWLA", "DWHTACALN", "PALOKAAPC", "CODTP"));

        allQuestions.add(new Questions("Which famous chef revealed one of the secrets to his success thus, “If you want to become a great chef, you have to work with great chefs. And that's exactly what I did”.", "GORDON", "RAMSAY", "RXMNRAOQN", "SABODMGFY", "BXQNMF"));

        allQuestions.add(new Questions("Who became the first youtuber to hit 56 million subscribers ?", "PEWDIEPIE", "", "PFWEIECD", "IIDEETPC", "CTDFICE"));

        allQuestions.add(new Questions("Who was a French biologist, microbiologist and chemist renowned for his discoveries of the principles of vaccination, microbial fermentation and pasteurization ?", "LOUIS", "PASTEUR", "FQSIOBNVS", "PTUURESLA", "QFBSVN"));

        allQuestions.add(new Questions("The \"_____ brothers\", Orville and Wilbur, were two American brothers, inventors, and aviation pioneers who are generally credited with inventing, building, and flying the world's first successful airplane.", "WRIGHT", "", "THXTWFI", "RGLUVSX", "VSTFLUXX"));

        allQuestions.add(new Questions("Who is the current President of the Russian Federation ?\nHe was Prime Minister from 1999 to 2000, President from 2000 to 2008, and again Prime Minister from 2008 to 2012.", "VLADIMIR", "PUTIN", "TIXSKILPT", "LNDAIMURV", "LKSXT"));

        allQuestions.add(new Questions("Who was famous for his character \"The Tramp\" ?\n The sweet little man with a bowler hat, mustache and cane, he was an iconic figure of the silent-film era and one of film's first superstars.", "CHARLIE", "CHAPLIN", "HHLACIBNJ", "RPILVCAGE", "VBJG"));

        allQuestions.add(new Questions("Who is a Polish-American technology executive and also the current CEO of YouTube ?", "SUSAN", "WOJCICKI", "AIKSZNASC", "WCUJBUAIO", "BAAZU"));

        allQuestions.add(new Questions("Who is a famous American actor and singer, who is known for his performances in movies like ‘I am Legend’ and ‘Hancock’ ?", "WILL", "SMITH", "LGFTTHEI", "JUILMWSV", "TGEUFJV"));

        allQuestions.add(new Questions("Who is a famous Jamaican reggae singer, known for his album ‘Rastaman Vibration’ ?", "BOB", "MARLEY", "LOMWYSAE", "RQBPBEEO", "SEQWOPE"));

        allQuestions.add(new Questions("Who was the inventor of dynamite and a manufacturer of arms who left his vast fortunes to institute the Nobel Prizes ?", "ALFRED", "NOBEL", "BYNFALEHQ", "EZDDLNERO", "QZDENYH"));

        allQuestions.add(new Questions("Who is the 45th & current President of the United States ?\nHint: Before entering politics he was a businessman and television a_maingame.", "DONALD", "TRUMP", "QOMRADLAD", "UFTWCEYNP", "EQWYFCA"));

        allQuestions.add(new Questions("Who was the infamous dictator of Germany who carried out the genocide of Jews and was majorly responsible for the World War II ?", "ADOLF", "HITLER", "PLCRELANH", "FDIHFOKTE", "PCFHKNE"));

        allQuestions.add(new Questions("An computer programmer and businessman who is best known as the co-founder and president of the video game development & digital distribution company Valve Corporation ?", "GABE", "NEWELL", "TGNLLALN", "WIKGBEEE", "TIKNGL"));

        allQuestions.add(new Questions("In \"Harry Potter\" series which actor played the character of Harry Potter ?", "DANIEL", "RADCLIFFE", "AXRLCDFDI", "LEFNEADIU", "XUD"));

        allQuestions.add(new Questions("In the Disney Channel television series \"Hannah Montana\" (2006) who became a teen idol starring as the character Miley Stewart ?", "MILEY", "CYRUS", "SIZMYMPR", "CUIYBELS", "MPBIZS"));

        allQuestions.add(new Questions("Who was an American professional boxer and activist who became the first and only three-time lineal World Heavyweight Champion ?", "MUHAMMAD", "ALI", "AAMILANMN", "MZDOVSHUS", "SNVZNSO"));

        allQuestions.add(new Questions("Which inventor gave world the first practical electric light bulb ?\n He suffered from hearing impairment since young and became deaf as an adult.", "THOMAS", "EDISON", "IESTESPND", "DFMADMHOO", "MDPFED"));

        allQuestions.add(new Questions("Who was the sixteenth President of the United States & the first US President to be assassinated ?", "ABRAHAM", "LINCOLN", "BLMLCANRV", "AJRNTAOHI", "TRJV"));

        allQuestions.add(new Questions("Who was one of the most iconic martial arts instructors who also played lead role in the film \"Enter the Dragon\" (1973) ?", "BRUCE", "LEE", "CUBEHRK", "ELERMSW", "SWHKMR"));

        allQuestions.add(new Questions("Who is Known as the \"Oracle of Omaha ?\nHe is one of the most successful investors of all time.\n His Berkshire Hathaway owns more than 60 companies, including Geico, Duracell and Dairy Queen.", "WARREN", "BUFFETT", "IWEARRTEB", "FNTFEVDUD", "VDIED"));

        allQuestions.add(new Questions("\"Toxic\" is a song recorded by which American singer for her fourth studio album \"In the Zone\" (2003) ?", "BRITNEY", "SPEARS", "UIWYSEBPE", "NSAADRBRT", "DBUAW"));

        allQuestions.add(new Questions("Who was a Serbian-American inventor, electrical engineer, mechanical engineer, physicist, and futurist who is best known for his contributions to the design of the modern alternating current electricity supply system?", "NIKOLA", "TESLA", "LDELFGTSN", "KTSIBHAOA", "TFBDHSG"));

        allQuestions.add(new Questions("A.P.J. _____ _____, the 11th President of India, is also popularly known as the Missile Man", "ABDUL", "KALAM", "KALANLBJ", "CULDMLNA", "JLCNLN"));

        allQuestions.add(new Questions("Who is well-known for being a brutally honest judge on the reality television shows, ‘Pop Idol’, ‘American Idol’ and ‘The X factor’ ?", "SIMON", "COWELL", "OSNLWOCLT", "FELIPNMIN", "FILPTNN"));

        allQuestions.add(new Questions("\"_____ _____ Moretz\"(full name) is an American actress most famous for her role of Mia in the movie ‘If I Stay’.", "Chloe", "Grace", "RLCECHAO", "BEOEGYCS", "YBSOCE"));

        allQuestions.add(new Questions("\"Like a Virgin\" & \"MDNA\" are the albums of which American artist ?", "MADONNA", "", "MNCJAJA", "NVEOGND", "NVJEJGC"));

        allQuestions.add(new Questions("Who is a famous Canadian-American actor, comedian known for his exceptional performance in ‘The Truman Show’ ?", "JIM", "CARREY", "NROMYYCU", "EPMMRIJA", "MPUOMNY"));

        allQuestions.add(new Questions("It is said that the falling of an apple from a tree inspired a great scientist to discover the force behind the action which eventually led to the discovery of gravitational force, Name him.", "ISAAC", "NEWTON", "TTENNIIOY", "SCARMLWOA", "MTLIRYO"));

        allQuestions.add(new Questions("Who is one of the most important American political leaders of modern times and served as the 42nd President of the USA ?", "BILL", "CLINTON", "ROCWIANNL", "TXVLMBCIL", "VXRACWM"));

        allQuestions.add(new Questions("What is the name of the actress who played Hermione Granger in the Harry Potter series of films ?", "EMMA", "WATSON", "AAOOEAFS", "WHAMMATN", "OAFAHA"));

        allQuestions.add(new Questions("His novel, ‘The Adventures of Huckleberry Finn’, a direct sequel to ‘The Adventures of Tom Sawyer’, is commonly named among the Great American Novels, Name him.", "MARK", "TWAIN", "CNAKMIAC", "KWTFLHTR", "FTLHCKC"));

        allQuestions.add(new Questions("Who is often referred to as ‘People’s Princess’ & also known by nicknames, ‘Princess Di’, and ‘Lady of Hearts’ ?", "PRINCESS", "DIANA", "AIIPNRSJO", "HVESDCNJA", "VJOJH"));

        allQuestions.add(new Questions("\"_______ SHAKESPEARE\"(full name) is often referred to as England’s national poet and ‘Bard of Avon’.", "William", "", "EWNKLBA", "ILLPMIV", "BPVENKL"));

        allQuestions.add(new Questions("An American Founding Father who was the principal author of the Declaration of Independence, Name him.", "THOMAS", "JEFFERSON", "FTSZLRNHA", "EZOEJMFSO", "ZZL"));

        allQuestions.add(new Questions("Who co-founded search engine Google with Sergey Brin while doing Ph.D. studies at Stanford University, in California ?", "LARRY", "PAGE", "LAGDRBAI", "RIKPFTEY", "BIKTFDI"));

        allQuestions.add(new Questions("Who is known for his pro-environment inventions like the electricity powered sports car ‘Tesla Roadster’ ?", "ELON", "MUSK", "LZMLVEN", "UOHSKIH", "HVLIHZ"));

        allQuestions.add(new Questions("Who is a Business tycoon belonging to China known for his e-commerce business venture ‘Alibaba’.", "JACK", "MA", "ADBAJAC", "CKFOHME", "OEABCHDF"));

        allQuestions.add(new Questions("A mastermind was a renowned Greek mathematician, known as the ‘Father of Geometry’, Name him", "EUCLID", "", "BLZCEQC", "DUNCAII", "CNBQCZIA"));

        allQuestions.add(new Questions("As She is left handed, guns had to be custom made for this actress so that she could load them easily in the movie, ‘Lara Croft: Tomb Raider’, Name her.", "ANGELINA", "JOLIE", "JRLBKAENL", "ANEOAVGII", "RBKVA"));

        allQuestions.add(new Questions("\"_____ _____ Jr\" is famous for his role of iron man.", "ROBERT", "DOWNEY", "EORNEBYVM", "OTDBGRRWR", "RBRGVM"));

        allQuestions.add(new Questions("Greatest painters of the 20th century was twice conferred with the International Lenin Peace Prize, first in 1950 and next in 1961, Name him.", "PABLO", "PICASSO", "PXUOEIQPO", "CZBLAASOS", "UXEOQZ"));

        allQuestions.add(new Questions("Who played an important role in India’s struggle for freedom & also known as father of nation (India) ?", "MAHATMA", "GANDHI", "FGQIHGTAA", "AABMIHNMD", "IBFQG"));

        allQuestions.add(new Questions("\"Bailando\" (English: \"Dancing\") is a song by which Spanish singer ?", "Enrique", "Iglesias", "SMERILQEI", "SGAEGNUIO", "OGM"));

        this.addAllQuestions(allQuestions);
    }

    public void addAllQuestions(ArrayList<Questions> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (Questions question : allQuestions) {
                values.put(QUESTION, question.getQUESTION());
                values.put(ANSWER, question.getANSWER());
                values.put(ANSWER2, question.getANSWER2());
                values.put(RANDOMANS1, question.getRANDOMANS1());
                values.put(RANDOMANS2, question.getRANDOMANS2());
                values.put(USELESSSTRING, question.getUSELESSSTRING());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    //It will insert value "1" so we will come to know that questions are added by checking size
    public void insertCheckQadded(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CHEKQADDED, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME14, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    //It will return the list of address and throw that address we gonna excess each field in it
    public List<Questions> getAllOfTheQuestions() {

        List<Questions> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, ANSWER, ANSWER2, RANDOMANS1, RANDOMANS2, USELESSSTRING};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            Questions question = new Questions();
            question.setID(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setAnswer(cursor.getString(2));
            question.setAnswer2(cursor.getString(3));
            question.setRANDOMANS1(cursor.getString(4));
            question.setRANDOMANS2(cursor.getString(5));
            question.setUSELESSSTRING(cursor.getString(6));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }

    //It will insert the qid for which FreeHint is used
    public void insertHint(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(HINTID, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME3, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    //It will return the list of qid of which FreeHint is used
    public List getHint() {
        String coloumns[] = {HINTID};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME3, coloumns, null, null, null, null, null);
        List<Integer> list = new ArrayList<>();

        while (cursor.moveToNext()) {
            int hintId = cursor.getInt(0);
            list.add(hintId);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list;
    }

    public void insertRandomNumbers(int id,int one , int two ,int three , int four , int five) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(ONE, one);
        contentValues.put(TWO, two);
        contentValues.put(THREE, three);
        contentValues.put(FOUR, four);
        contentValues.put(FIVE, five);

        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME4, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }
    //It will insert the qid of solved questions
    public void InsertQid(int id) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CORRECTNO, id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.insert(TABLE_NAME2, null, contentValues);
        db.setTransactionSuccessful();
        db.endTransaction();
        /* Toast.makeText(context,"the answer was correct"+id+"was added",Toast.LENGTH_SHORT).show();*/
        db.close();
    }

    public List<FreeHint> getRandomNumbers() {
        String coloumns[] = {ID,ONE,TWO,THREE,FOUR,FIVE};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME4, coloumns, null, null, null, null, null);
        List<FreeHint> FreeHintNoList = new ArrayList<>();

        while (cursor.moveToNext()) {
            FreeHint freeHint = new FreeHint();
            freeHint.setFreeHintUsedId(cursor.getInt(0));
            freeHint.setRandomNoOne(cursor.getInt(1));
            freeHint.setRandomNoTwo(cursor.getInt(2));
            freeHint.setRandomNoThree(cursor.getInt(3));
            freeHint.setRandomNoFour(cursor.getInt(4));
            freeHint.setRandomNoFive(cursor.getInt(5));
            FreeHintNoList.add(freeHint);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return FreeHintNoList;
    }

    //It will return the list. if list size is even dialog_sound is on or else off
    public List getSound() {
        String coloumns[] = {SOUND};
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        Cursor cursor = db.query(TABLE_NAME13, coloumns, null, null, null, null, null);
        List<Integer> list2 = new ArrayList<>();

        while (cursor.moveToNext()) {
            int questionId = cursor.getInt(0);
            list2.add(questionId);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return list2;
    }

}
