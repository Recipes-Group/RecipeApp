package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import android.content.Intent;
import android.util.Log;
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
        readRecipeData();

        //Get Global Controller Class Object
        final Controller aController = (Controller) getApplicationContext();

        for(Recipe r : aController.getRecipes()){
            Log.v("MainActivity", "Recipe Name: " + r.getRecipeName());
        }
    }

    private void readRecipeData() {
        InputStream is = getResources().openRawResource(R.raw.recipe_database);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        //Get Global Controller Class Object
        final Controller aController = (Controller) getApplicationContext();

        String line = "";
        int numIngredientsFields = 13;
        int numStepsFields = 10;
        try {
            while ((line = reader.readLine()) != null){
                //Split by comma
                String[] fields = line.split("@");
                System.out.println(fields.length);
                Recipe recipe = new Recipe(fields[0], fields[1]);
                for(int i = 0; i < numIngredientsFields; i++){
                    recipe.addIngredient(fields[i+2]);
                }
                for(int i = 0; i < numStepsFields; i++){
                    recipe.addStep(fields[i+15]);
                }
                aController.addRecipe(recipe);
            }
        }
        catch (IOException e) {
            Log.wtf("MainActivity", "Error reading data on line: " + line);
        }
    }

    public void openIngredientsPage(View v) {
        Intent intent = new Intent(this, IngredientsActivity.class);
        startActivity(intent);
    }

}