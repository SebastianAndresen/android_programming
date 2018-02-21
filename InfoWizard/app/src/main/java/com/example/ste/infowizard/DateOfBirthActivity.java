package com.example.ste.infowizard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateOfBirthActivity extends AppCompatActivity {

    private DatePicker dpDateOfBirth;
    private String name;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_of_birth);
        Intent i = getIntent();
        name = i.getStringExtra(Constants.NAME_KEY);
        address = i.getStringExtra(Constants.ADDRESS_KEY);

        dpDateOfBirth = (DatePicker) findViewById(R.id.datePicker);
        dpDateOfBirth.updateDate(1996, 0, 1);
        Log.i(Constants.TAG, "DateOfBirthActivity onCreate");

        ((Button) findViewById(R.id.btnNext)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToNextActivity();
            }
        });
        ((Button) findViewById(R.id.btnBack)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });
    }

    private void redirectToNextActivity() {
        Intent intent = new Intent(this, SummaryActivity.class);
        intent.putExtra(Constants.ADDRESS_KEY, address);
        intent.putExtra(Constants.NAME_KEY, name);

        int   day  = dpDateOfBirth.getDayOfMonth();
        int   month= dpDateOfBirth.getMonth();
        int   year = dpDateOfBirth.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formatedDate = sdf.format(calendar.getTime());
        intent.putExtra(Constants.DATE_OF_BIRTH_KEY, formatedDate);
        startActivity(intent);
    }

    private void finishActivity() {
        finish();
    }
}
