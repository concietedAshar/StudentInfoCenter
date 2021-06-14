package com.mrash.studentinfocenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudent extends AppCompatActivity {

    EditText etStudentID, etStudentName, etFatherName,
            etStudentSemester, etStudentEmail, etStudentDOB, etStudentAddress;
    Button btnSubmit, btnBack;
    Context context = AddStudent.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        init();
        setBtnSubmit();
        setBtnBack();


    }

    /**
     * button for Submit Student Data
     */
    private void setBtnSubmit() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validation()) {

                    int stdId = Integer.parseInt(etStudentID.getText().toString().trim());
                    String stdName = etStudentName.getText().toString().trim();
                    String fatherName = etFatherName.getText().toString().trim();
                    int stdSemester = Integer.parseInt(etStudentSemester.getText().toString().trim());
                    String stdEmail = etStudentEmail.getText().toString().trim();
                    String stdDob = etStudentDOB.getText().toString().trim();
                    String stdAddress = etStudentAddress.getText().toString().trim();


                    // Adding Records into dataBase
                    DBHandler dbHandler = new DBHandler(context);
                    Student student = new Student(stdId, stdName, fatherName, stdSemester, stdEmail, stdDob, stdAddress);
                    dbHandler.AddRecord(student);
                    dbHandler.close();
                    startActivity(new Intent(AddStudent.this, com.mrash.studentinfocenter.MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(AddStudent.this, "Fill Correct & Full Form For Submission", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * button for Back to Main Activity
     */
    private void setBtnBack() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddStudent.this, com.mrash.studentinfocenter.MainActivity.class));
                finish();
            }
        });
    }

    /**
     * init method
     */
    private void init() {
        etStudentID = findViewById(R.id.etStudentID);

        etStudentName = findViewById(R.id.etStudentName);
        etFatherName = findViewById(R.id.etFatherName);
        etStudentSemester = findViewById(R.id.etStudentSemester);
        etStudentEmail = findViewById(R.id.etStudentEmail);
        etStudentDOB = findViewById(R.id.etStudentDOB);
        etStudentAddress = findViewById(R.id.etStudentAddress);
        btnSubmit = findViewById(R.id.btnDelete);
        btnBack = findViewById(R.id.btnBackDel);

    }

    /**
     * validation for Edit Text that user don't submit empty data
     *
     * @return
     */
    private boolean validation() {
        boolean flag = true;
        if (etStudentID.getText().toString().isEmpty()) {
            flag = false;
            etStudentDOB.setError("Enter Student Roll No");
        }
        if (etStudentName.getText().toString().trim().isEmpty()) {
            flag = false;
            etStudentDOB.setError("Enter Student Name");
        }
        if (etFatherName.getText().toString().trim().isEmpty()) {
            flag = false;
            etStudentDOB.setError("Enter Father Name");
        }
        if (etStudentSemester.getText().toString().isEmpty() || Integer.parseInt(etStudentSemester.getText().toString()) <= 0
                || Integer.parseInt(etStudentSemester.getText().toString()) > 12) {
            flag = false;
            Toast.makeText(this, "Enter Valid Semester between 1 to 12", Toast.LENGTH_SHORT).show();
            etStudentDOB.setError("Enter Correct Semester");
        }
        if (etStudentEmail.getText().toString().isEmpty() || !etStudentEmail.getText().toString().trim().contains("@")) {
            flag = false;
            etStudentDOB.setError("Enter Valid Email");
        }
        if (etStudentDOB.getText().toString().trim().isEmpty()) {
            flag = false;
            etStudentDOB.setError("Please Enter DOB");
        }
        if (etStudentAddress.getText().toString().trim().isEmpty()) {
            flag = false;
            etStudentAddress.setError("Enter Address");
        }

        return flag;
    }


}