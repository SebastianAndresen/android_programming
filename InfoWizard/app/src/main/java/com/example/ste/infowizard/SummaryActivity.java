package com.example.ste.infowizard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvAddress;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvName = findViewById(R.id.tvName);
        tvAddress = findViewById(R.id.tvAddress);
        tvDate = findViewById(R.id.tvDateOfBirth);

        Intent intent = getIntent();

        tvName.setText(intent.getStringExtra(Constants.NAME_KEY));
        tvAddress.setText(intent.getStringExtra(Constants.ADDRESS_KEY));
        tvDate.setText(intent.getStringExtra(Constants.DATE_OF_BIRTH_KEY));

        Log.i(Constants.TAG, "SummaryActivity onCreate");

        ((Button) findViewById(R.id.btnBack)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });
    }

    private void finishActivity() {
        finish();
    }
}
