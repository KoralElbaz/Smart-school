package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class menuStudent extends AppCompatActivity implements View.OnClickListener{


    private LinearLayout Grades ,  Presence , Profile;
    Button LogoutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_student);


        Grades=findViewById(R.id.Grades) ;
        Grades.setOnClickListener(this);

        Presence=findViewById(R.id.Presence);
        Presence.setOnClickListener(this);

        Profile= findViewById(R.id.Profile);
        Profile.setOnClickListener(this);

        Profile= findViewById(R.id.Lessons);
        Profile.setOnClickListener(this);

        LogoutBtn = findViewById(R.id.LogoutBtn);
        LogoutBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.Grades:
                startActivity(new Intent(getApplicationContext(),gradesStudent.class));
                break;
            case R.id.Presence:
                startActivity(new Intent(getApplicationContext(),presenceStudent.class));
                break;
            case R.id.Profile:
                startActivity(new Intent(this, profileStudent.class));
                break;
            case  R.id.Lessons:
                startActivity(new Intent(this, studentLessonsList.class));
                break;
            case R.id.LogoutBtn:
                AlertDialog.Builder builder=new AlertDialog.Builder(menuStudent.this); //Home is name of the activity
                builder.setMessage("Do you want to exit?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        finish();
                        Intent i=new Intent();
                        i.putExtra("finish", true);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                        //startActivity(i);
                        finish();

                    }
                });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert=builder.create();
                alert.show();


                break;

        }

    }


}