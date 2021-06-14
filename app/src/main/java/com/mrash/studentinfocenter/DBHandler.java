package com.mrash.studentinfocenter;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;


public class DBHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "StudentDB";
    private static final String CONTACTS_TABLE = "students";

    private static final String ID = "id";
    private static final String STU_ID = "stdId";                           // #01
    private static final String STUDENT_NAME = "stdName";               // #02
    private static final String FATHER_NAME = "fatherName";             // #03
    private static final String STUDENT_SEMESTER = "stdSemester";       // #04
    private static final String STUDENT_EMAIL = "stdEmail";             // #05
    private static final String DATE = "stdDob";                        // #06
    private static final String ADDRESS = "stdAddress";                 // #07

    private static final String TAG = "DBHandler";

    private final Context ourContext;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        ourContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + CONTACTS_TABLE +
                "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + STU_ID + " INTEGER NOT NULL, "
                + STUDENT_NAME + " TEXT, "
                + FATHER_NAME + " TEXT, "
                + STUDENT_SEMESTER + " INTEGER, "
                + STUDENT_EMAIL + " TEXT, "
                + DATE + " TEXT, "
                + ADDRESS + " TEXT )";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + CONTACTS_TABLE);
        onCreate(db);
    }

    /**
     * Add data to Database
     *
     * @return
     */
    public void AddRecord(Student student) {

        SQLiteDatabase ourDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STU_ID, student.getStdId()); //Student Id
        contentValues.put(STUDENT_NAME, student.getStdName()); //Student Name
        contentValues.put(FATHER_NAME, student.getFatherName()); //Student Father Name
        contentValues.put(STUDENT_SEMESTER, student.getStdSemester()); //Student Semester
        contentValues.put(STUDENT_EMAIL, student.getStdEmail()); //Student Email
        contentValues.put(DATE, student.getStdDob()); //Student DOB
        contentValues.put(ADDRESS, student.getStdAddress()); //Student Address

        long sucess = ourDatabase.insert(CONTACTS_TABLE, null, contentValues); // return total records
        if(sucess == -1)
        {
            Toast.makeText(ourContext, "Failed", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(ourContext, "SuccessFul Inserted", Toast.LENGTH_SHORT).show();
        ourDatabase.close();
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+CONTACTS_TABLE,null);
        return res;
    }


    public Student getSingleData(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor ;
        String query = "SELECT * FROM " + CONTACTS_TABLE + " WHERE " + ID + " = '" + id+ "'" ;
        cursor = sqLiteDatabase.rawQuery(query,null);

        // Gives Columns Id
      //  int _id = cursor.getColumnIndex(ID);
      //  int studentKeyID = cursor.getColumnIndex(STU_ID); //1
      //  int studentNameID = cursor.getColumnIndex(STUDENT_NAME); //2
     //   int fatherNameID = cursor.getColumnIndex(FATHER_NAME); //3
      //  int semesterID = cursor.getColumnIndex(STUDENT_SEMESTER); //4
     //   int emailID = cursor.getColumnIndex(STUDENT_EMAIL); //5
      //  int dateID = cursor.getColumnIndex(DATE); //6
       // int addressID = cursor.getColumnIndex(ADDRESS); //7

        Student student;
        if (cursor != null) {
            student = new Student();
            cursor.getInt(0);
            student.setStdId(cursor.getInt(1));
            student.setStdName(cursor.getString(2));
            student.setFatherName(cursor.getString(3));
            student.setStdSemester(cursor.getInt(4));
            student.setStdEmail(cursor.getString(5));
            student.setStdDob(cursor.getString(6));
            student.setStdAddress(cursor.getString(7));

            cursor.close();

            return student;
        } else
            return null;

    }
    public int getContactCount() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + CONTACTS_TABLE;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor.getCount();
    }

    public  void deleteStudent(int id)
    {

        SQLiteDatabase database = this.getWritableDatabase();
        long success = database.delete(CONTACTS_TABLE,STU_ID+" = ?",new String[]{""+id});

        if (success != 0)
        {
            Toast.makeText(ourContext, "Deleted Successfully", Toast.LENGTH_SHORT).show();

        }
        else
            Toast.makeText(ourContext, "Not Deleted Successfully", Toast.LENGTH_SHORT).show();

    }


}