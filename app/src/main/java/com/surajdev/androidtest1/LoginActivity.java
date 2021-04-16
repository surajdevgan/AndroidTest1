package com.surajdev.androidtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText StudentName, UserName, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StudentName = findViewById(R.id.studentname);
        UserName = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        //startActivity(new Intent(this, CourseSelectionActivity.class));
    }

    public void Login(View view) {


if(StudentName.getText().toString().isEmpty())
{
    Toast.makeText(this, "Name Required", Toast.LENGTH_SHORT).show();

}

      else   if(UserName.getText().toString().equals("student1") && Password.getText().toString().equals("123456")&& !StudentName.getText().toString().isEmpty())
        {

//Create the bundle
            Bundle bundle = new Bundle();
//Add your data from getFactualResults method to bundle
            bundle.putString("UserName", StudentName.getText().toString());
//Add the bundle to the intent

            Intent i = new Intent(this, CourseSelectionActivity.class);
            i.putExtras(bundle);
            startActivity(i);
        }

        else
        {

            Toast.makeText(this, "Invalid UserName OR Password", Toast.LENGTH_SHORT).show();

        }


    }
}