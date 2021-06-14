package com.mrash.studentinfocenter;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialougeLisner {


    // **** Variable Button Declaration ****
    Button btnAddStudent, btnEditStudent, btnViewStudents, btnDeleteStudent;
    String StudentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // **** Init Views Function Call ****
        init();

        // **** Students Function Call ****
        setBtnAddStudent();
        setBtnEditStudent();
        setBtnViewStudents();
        setBtnDeleteStudent();



    }

    // **** Connect with Layout ****
    private void init() {
        btnAddStudent = findViewById(R.id.btnAddStudent);
        btnEditStudent = findViewById(R.id.btnEditStudent);
        btnViewStudents = findViewById(R.id.btnViewStudents);
        btnDeleteStudent = findViewById(R.id.btnDeleteStudent);
    }

    /**
     * Button Add Student
     */
    private void setBtnAddStudent() {
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.mrash.studentinfocenter.AddStudent.class));
                finish();

            }
        });

    }

    /**
     * Button Edit Student
     */
    private void setBtnEditStudent() {
        btnEditStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialogBox();
                Intent intent = new Intent(MainActivity.this, com.mrash.studentinfocenter.EditStudents.class);
               intent.putExtra("StdId",StudentID);
                startActivity(intent);
                finish();

            }
        });
    }

    public void showDialogBox() {

        ExampleDialog exampleDialog=  new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"Example Dialouge");
    }

    /**
     * Button View All Students
     */
    private void setBtnViewStudents() {

        btnViewStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShowAllContacts();

            }
        });
    }

    /**
     * Button Delete Student
     */
    private void setBtnDeleteStudent() {
        btnDeleteStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.mrash.studentinfocenter.DeleteStudents.class));
                finish();
            }
        });
    }

    public void showMessage(String title,String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    private void ShowAllContacts()
    {
        DBHandler dbHandler = new DBHandler(this);
        Cursor res =dbHandler.getAllData();

        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }



        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            res.getString(0);
            buffer.append("Student ID :"+ res.getString(1)+"\n");
            buffer.append("Student Name :"+ res.getString(2)+"\n");
            buffer.append("Father Name :"+ res.getString(3)+"\n");
            buffer.append("Semester :"+ res.getString(4)+"\n");
            buffer.append("Email :"+ res.getString(5)+"\n");
            buffer.append("Date of Birth :"+ res.getString(6)+"\n");
            buffer.append("Address :"+ res.getString(7)+"\n\n");
        }

        // Show all data
        showMessage("Data",buffer.toString());

    }


    @Override
    public void applyText(String studentId) {

        StudentID = studentId;

    }
}