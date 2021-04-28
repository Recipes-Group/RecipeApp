package com.example.recipeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StepActivity extends AppCompatActivity {

    private ArrayList<String> steps = new ArrayList<String>();
    private Recipe recipe;
    private int currentStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        Log.d("in next method", "currentStep = " + currentStep);

        currentStep = 1;

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
        Toast toast1;
        Toast toast2;

        currentStep = currentStep + 1;

        if(currentStep>recipe.getNumberSteps()) {
            toast1 = Toast.makeText(getApplicationContext(), "This is the last step. Say 'Quit' if you are finished.", Toast.LENGTH_LONG);
            toast1.show();
            currentStep--;
            return;
        }

        oldStep = (TextView) findViewById(R.id.stepDescriptionText);
        oldStep.setText(recipe.getNextStep());

        oldTitle = (TextView) findViewById(R.id.stepTitle);
        oldTitle.setText("Step #" + (currentStep));


        toast2 = Toast.makeText(getApplicationContext(), "currentStep = ", Toast.LENGTH_LONG);

        Log.d("in next method", currentStep + "current step");

        Button mButton = (Button) findViewById(R.id.nextButton);

    }

    public void back(View v) {

        TextView oldStep;
        TextView oldTitle;
        Toast toast1;

        currentStep--;

        if(currentStep<=0) {
            toast1 = Toast.makeText(getApplicationContext(), "This is the first step. Say or press 'NEXT' to continue.", Toast.LENGTH_LONG);
            toast1.show();
            currentStep++;
            return;
        }

        Toast toast = Toast.makeText(getApplicationContext(), "currentStep = ", Toast.LENGTH_LONG);

        oldStep = (TextView) findViewById(R.id.stepDescriptionText);
        oldStep.setText(recipe.getPreviousStep());

        oldTitle = (TextView) findViewById(R.id.stepTitle);
        oldTitle.setText("Step #" + (currentStep));

        Button mButton = (Button) findViewById(R.id.nextButton);

    }

    public void repeat(View v) {
        //reads current text on the screen --> recipe.getStepIndexOf(currentStep - 1);

    }

    public void skip(View v) {
        //popup --> asks "Which step would you like to skip to?"

        Intent intent = new Intent(this, SkipPopup.class);
        startActivity(intent);

    }

    public void quit(View v) {
        //popup --> asks "are you sure you want to quit?"
        //returns to the home page
    }

    public void printIngredients(View v) {
        String toPrint = recipe.ingredientsToString();
        TextView ingredients = v.findViewById(R.id.IngredientsList);
        ingredients.setText(toPrint);
    }
}