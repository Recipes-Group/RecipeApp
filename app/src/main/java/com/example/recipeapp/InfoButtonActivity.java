package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class InfoButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_button);
    }

    public void doneButton(View v) {
        Toast toast1 = Toast.makeText(getApplicationContext(), "You pressed the DONE Button", Toast.LENGTH_LONG);
        toast1.show();

        Intent intent = new Intent(this, StepActivity.class);
        startActivity(intent); //originally commented out to test other things without it
    }

}