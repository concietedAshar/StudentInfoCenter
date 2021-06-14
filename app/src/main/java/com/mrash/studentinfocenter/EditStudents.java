package com.mrash.studentinfocenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditStudents extends AppCompatActivity {

    String studentId;
    EditText etStudentID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_students);

        init();
        Intent intent = getIntent();
        studentId = intent.getStringExtra("StdId");
        etStudentID.setText(studentId);



    }

    private void init()
    {
        etStudentID = findViewById(R.id.etStudentID);

    }
}