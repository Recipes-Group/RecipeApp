package com.example.recipeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StepActivity extends AppCompatActivity {

    private ArrayList<String> steps = new ArrayList<String>();
    private Recipe recipe;
    private int currentStep = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        recipe = new Recipe("Chocolate Chip Cookies", "https://www.allrecipes.com/recipe/10813/best-chocolate-chip-cookies/");

        recipe.addIngredient("1 cup butter, softened");
        recipe.addIngredient("1 cup white sugar");
        recipe.addIngredient("1 cup packed brown sugar");
        recipe.addIngredient("2 eggs");
        recipe.addIngredient("1 teaspoon baking soda");
        recipe.addIngredient("2 teaspoons hot water");
        recipe.addIngredient("½ teaspoon salt");
        recipe.addIngredient("3 cups all-purpose flour");
        recipe.addIngredient("2 cups semisweet chocolate chips");
        recipe.addIngredient("1 cup chopped walnuts");

        recipe.addStep("Preheat oven to 350 degrees F (175 degrees C).");
        recipe.addStep("Cream together the butter, white sugar, and brown sugar until smooth. Beat in the eggs one at a time, then stir in the vanilla. Dissolve baking soda in hot water. Add to batter along with salt. Stir in flour, chocolate chips, and nuts. Drop by large spoonfuls onto ungreased pans.");
        recipe.addStep("Bake for about 10 minutes in the preheated oven, or until edges are nicely browned.");

    }

    public void getInfo(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "You pressed the INFO Button", Toast.LENGTH_LONG);
        toast.makeText(getApplicationContext(), "Commands Info", Toast.LENGTH_LONG);

        toast.show();

        Intent intent = new Intent(this, InfoButtonActivity.class);
        startActivity(intent);
    }

    public void displayInfo() {
        Intent intent = new Intent(this, InfoButtonActivity.class);
        startActivity(intent);

    }

    public void next(View v) {

        TextView oldStep;
        TextView oldTitle;

        oldStep = (TextView) findViewById(R.id.stepDescriptionText);
        oldStep.setText("hi");

        oldTitle = (TextView) findViewById(R.id.stepTitle);
        oldTitle.setText("Step #" + (currentStep+1));

        Button mButton = (Button) findViewById(R.id.nextButton);

    }

}