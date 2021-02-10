package com.ocsa.tutorialandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private final int REQUEST_CODE_OTHERACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.txtResult);
    }

    public void startOtherActivity(View v) {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivityForResult(intent, REQUEST_CODE_OTHERACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_OTHERACTIVITY) {
            if(resultCode == Activity.RESULT_OK) {
                String fullname = data.getStringExtra("fullname");
                String name = data.getStringExtra("name");
                String result = "Fullname: "+ fullname + "\n" + "Name: " + name;
                txtResult.setText(result);
            } else {
                Toast.makeText(this, "Error when receiving data from OtherActivity",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}