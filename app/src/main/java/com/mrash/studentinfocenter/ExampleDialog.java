package com.mrash.studentinfocenter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment
{

    EditText etStudentID;
    private ExampleDialougeLisner lisner;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_box,null);

        builder.setView(view).setTitle("Get Student Id").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String studentID = etStudentID.getText().toString().trim();
                lisner.applyText(studentID);

            }
        });

        etStudentID = view.findViewById(R.id.etStudentID);


        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            lisner = (ExampleDialougeLisner) context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString() + "Must Implemet Example Dialouge Lisner");
        }
    }

    public  interface ExampleDialougeLisner
    {
        void applyText(String studentId);
    }
}
