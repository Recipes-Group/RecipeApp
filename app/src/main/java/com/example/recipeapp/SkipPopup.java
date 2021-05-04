package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SkipPopup extends AppCompatActivity {
    int newStep;
    TextView oldStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        double width = dm.widthPixels * 0.8;
        double height = dm.heightPixels * 0.6;

        getWindow().setLayout((int) width,(int) height);

    }

    private int getStepInput() {
        EditText step = findViewById(R.id.skipPromptNum);
        String currentStep = step.getText().toString();
        int newStep = Integer.parseInt(currentStep);
        return newStep;
    }

    public void doneButton(View v) {
        Toast toast1 = Toast.makeText(getApplicationContext(), "You pressed the DONE Button", Toast.LENGTH_LONG);
        toast1.show();

        /* Intent intent = new Intent(this, StepActivity.class);
        startActivity(intent); */ //commented out to test other things without it
    }

}