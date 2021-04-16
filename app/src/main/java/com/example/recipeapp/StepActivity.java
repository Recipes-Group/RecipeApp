package com.example.recipeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class StepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
    }

    public void getInfo(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "You pressed the INFO Button", Toast.LENGTH_LONG);
        toast.makeText(getApplicationContext(), "Commands Info", Toast.LENGTH_LONG);

        toast.show();

        Intent intent = new Intent(this, InfoButtonActivity.class);
        startActivity(intent);
    }

    public void cookRecipe(View v) {


        System.out.println("\nCommands Info:");
        System.out.println("1. Next    ==> Advances to the next step.");
        System.out.println("2. Repeat  ==> Reads the most recent step again.");
        System.out.println("3. Back    ==> Reads the previous step.");
        System.out.println("4. Skip    ==> Skips to the step you are choosing. Steps entered must be between 1 and last step");
        System.out.println("5. Quit    ==> Stops making the recipe and returns you to the home screen.");
        System.out.println("6. Finish  ==> Displays these commands.");
    }

    public void displayInfo() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View INFOPOPUPVIEW = getLayoutInflater().inflate(R.layout.info_popup, null);

        dialogBuilder.setView(INFOPOPUPVIEW);

    }



}