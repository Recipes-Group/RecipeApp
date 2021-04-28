package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        
        readQuestionData();
    }

    private void readQuestionData() {
        InputStream is = getResources().openRawResource(R.raw.)
    }

    public void cookRecipe(View v) {
        Intent intent = new Intent(this, StepActivity.class);
        startActivity(intent);
    }



}