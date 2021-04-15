package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Scanner;
import android.view.View;

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

    public void getInfo() {
        System.out.println("\nCommands Info:");
        System.out.println("1. Next   ==> Advances to the next step.");
        System.out.println("2. Repeat ==> Reads the most recent step again.");
        System.out.println("3. Back   ==> Reads the previous step.");
        System.out.println("4. Skip   ==> Skips to the step you are choosing. Steps entered must be between 1 and last step");
        System.out.println("5. Quit   ==> Stops making the recipe and returns you to the home screen.");
        System.out.println("6. Finish  ==> Displays these commands.");
    }





}