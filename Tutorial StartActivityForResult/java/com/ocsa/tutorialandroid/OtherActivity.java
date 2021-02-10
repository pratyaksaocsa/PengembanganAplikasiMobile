package com.ocsa.tutorialandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OtherActivity extends AppCompatActivity {

    private EditText txtFullname, txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        txtFullname = findViewById(R.id.txtfullname);
        txtName = findViewById(R.id.txtname);
    }

    public void done(View v) {
        String fullname = txtFullname.getText().toString();
        String name = txtName.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("fullname", fullname);
        intent.putExtra("name", name);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}