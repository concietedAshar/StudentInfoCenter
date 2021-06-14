package com.mrash.studentinfocenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteStudents extends AppCompatActivity {


    EditText etStudentID;
    Button btnDelete;
    Button btnBackDel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_students);
        etStudentID = findViewById(R.id.etStudentID);
        btnDelete = findViewById(R.id.btnDelete);
        btnBackDel =findViewById(R.id.btnBackDel);


        setBtnBackDel();
        setBtnDelete();


    }
    private void setBtnBackDel()
    {
        btnBackDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteStudents.this,com.mrash.studentinfocenter.MainActivity.class));
                finish();
            }
        });
    }

    private void setBtnDelete()
    {
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(validate())
                    {
                        DBHandler dbHandler = new DBHandler(DeleteStudents.this);
                        dbHandler.deleteStudent(Integer.parseInt(etStudentID.getText().toString().trim()));
                        dbHandler.close();

                    }
                }
            });
    }

    private boolean validate()
    {
        boolean flag = true;
        if(etStudentID.getText().toString().trim().isEmpty())
        {
            flag = false;
            etStudentID.setError("Enter Student Id to Delete Record");

        }
        return flag;
    }
}
