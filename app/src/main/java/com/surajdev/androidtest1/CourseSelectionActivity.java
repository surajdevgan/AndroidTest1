package com.surajdev.androidtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CourseSelectionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView StudentName, FeesToDisplay, HoursToDisplay, TotalFeesToDisplay, TotalHoursToDisplay, FinalFees;
    Spinner CourseSpinner;

    public static String[] courses = {"Java", "Swift", "Android", "iOS", "Database"};
    public static int[] fees = {1300, 1500, 1400, 1350, 1000};
    public static int[] hours = {6, 5, 7, 5, 4};

    int originalFees=0;
    int originalHours=0;
    boolean grad = false;
    boolean ungrad = true;

    int totalfee = 0;
    int tmpff = 0;

    int totalhhr = 0;
    int tmphhr = 0;
    int checkhours=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_selection);
        StudentName = findViewById(R.id.StudentNAme);
        CourseSpinner = findViewById(R.id.courses);
        FeesToDisplay = findViewById(R.id.fees);
        HoursToDisplay = findViewById(R.id.hours);
        TotalFeesToDisplay = findViewById(R.id.totalfees);
        TotalHoursToDisplay = findViewById(R.id.totalhours);
        FinalFees = findViewById(R.id.finalfees);
        CourseSpinner.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,courses);
        CourseSpinner.setAdapter(aa);



        Bundle bundle = getIntent().getExtras();

//Extracting the data…
        String venName = bundle.getString("UserName");

StudentName.setText("Welcome\n"+venName);

    }

    public void onRadioButtonClicked(View view) {


        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.grad:
                if (checked)
                {
                    grad = true;
                    ungrad = false;

                }

                else
                   // grad = false;



                break;
            case R.id.ungrad:
                if (checked)
                {
                    ungrad = true;
                    grad = false;

                }

                else
                 //   ungrad = false;

                break;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      //  parent.getItemAtPosition(position);

        FeesToDisplay.setText("This Course cost $ "+String.valueOf(fees[position]));
        tmpff = (fees[position]);
        originalFees=fees[0];
        HoursToDisplay.setText("This Course is of "+String.valueOf(hours[position])+" hours");
        tmphhr = (hours[position]);
        originalHours=hours[0];




    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        FeesToDisplay.setText(String.valueOf(fees[0]));
        HoursToDisplay.setText(String.valueOf(hours[0]));

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    public void AddCourse(View view) {

        checkhours+= tmphhr;


        if(grad && checkhours<=21)
        {
            totalfee += tmpff;
            totalhhr += tmphhr;

            TotalFeesToDisplay.setText("Your Total Fees is $ "+totalfee);
            TotalHoursToDisplay.setText("Your Total hours "+totalhhr);

        }


         if(ungrad && checkhours<=19)
        {

            totalfee += tmpff;
            totalhhr += tmphhr;

            TotalFeesToDisplay.setText("Your Total Fees is $ "+totalfee);
            TotalHoursToDisplay.setText("Your Total hours "+totalhhr);

        }

        else {

            Toast.makeText(this, "You can’t add this course", Toast.LENGTH_SHORT).show();
            checkhours = totalhhr;
        }






    }

    public void onCheckboxClicked(View view) {

        // Is the view now checked?

        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.accom:
                if (checked)
                {
                    FinalFees.setVisibility(View.VISIBLE);
                    totalfee+=1000;

                }

                else
            {
                totalfee-=1000;
                FinalFees.setVisibility(View.GONE);

            }


                break;
            case R.id.medical:
                if (checked)
                {
                    FinalFees.setVisibility(View.VISIBLE);
                    totalfee+=700;

                }

                else
            {
                totalfee-=700;
                FinalFees.setVisibility(View.GONE);

            }

                break;



        }

       // FinalFees.setVisibility(View.VISIBLE);
       // TotalFeesToDisplay.setText(""+totalfee);
        FinalFees.setText("Your Fees after Add-dns is "+totalfee);

    }
}