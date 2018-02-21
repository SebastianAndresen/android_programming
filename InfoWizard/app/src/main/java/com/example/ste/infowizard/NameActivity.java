package com.example.ste.infowizard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    private EditText etYourName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        Log.i(Constants.TAG, "NameActivity onCreate");
        etYourName = (EditText)findViewById(R.id.myEditText);

        ((Button) findViewById(R.id.btnNext)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectToNextActivity();
            }
        });
    }

    private void redirectToNextActivity(){
        if(!TextUtils.isEmpty(etYourName.getText())) {
            Intent intent = new Intent(this, AddressActivity.class);
            intent.putExtra(Constants.NAME_KEY, etYourName.getText().toString());
            startActivity(intent);
        }
    }
}
