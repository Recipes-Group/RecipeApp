package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IngredientsActivity extends AppCompatActivity {
    TextView ingredientsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        ingredientsList = (TextView) findViewById(R.id.IngredientsList);

        ingredientsList.setText(ingredientsToString());
    }

    public void openStepsPage(View v) {
        Intent intent = new Intent(this, StepActivity.class);
        startActivity(intent);
    }

    private String ingredientsToString() {
        final Controller aController = (Controller) getApplicationContext();

        String toPrint = "";
        for(int i = 0; i < aController.getRecipe().getNumberIngredients(); i++) {
            toPrint = toPrint.concat(aController.getRecipe().getIngredients().get(i));
        }

        return toPrint;
    }

}