package com.example.ste.infowizard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressActivity extends AppCompatActivity {

    private EditText etYourAddress;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        Intent i = getIntent();
        name = i.getStringExtra(Constants.NAME_KEY);
        Log.i(Constants.TAG, "AddressActivity onCreate");
        etYourAddress = (EditText)findViewById(R.id.myEditText);

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

    private void redirectToNextActivity(){
        if(!TextUtils.isEmpty(etYourAddress.getText())) {
            Intent intent = new Intent(this, DateOfBirthActivity.class);
            intent.putExtra(Constants.ADDRESS_KEY, etYourAddress.getText().toString());
            intent.putExtra(Constants.NAME_KEY, name);
            startActivity(intent);
        }
    }

    private void finishActivity(){
        finish();
    }
}
