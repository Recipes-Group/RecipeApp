package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Scanner;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private String recipeName;
    private String url;
    private ArrayList<String> steps = new ArrayList<String>();
    private ArrayList<String> ingredients = new ArrayList<String>();
    private int numUserInput;
    private boolean microphoneOn = false;
    private int step = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }





}