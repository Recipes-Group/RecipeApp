package com.example.recipeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StepActivity extends AppCompatActivity {

    private ArrayList<String> steps = new ArrayList<String>();
    private Recipe cookies = new Recipe("Chocolate Chip Cookies", "https://www.allrecipes.com/recipe/10813/best-chocolate-chip-cookies/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        cookies.addIngredient("1 cup butter, softened");
        cookies.addIngredient("1 cup white sugar");
        cookies.addIngredient("1 cup packed brown sugar");
        cookies.addIngredient("2 eggs");
        cookies.addIngredient("1 teaspoon baking soda");
        cookies.addIngredient("2 teaspoons hot water");
        cookies.addIngredient("½ teaspoon salt");
        cookies.addIngredient("3 cups all-purpose flour");
        cookies.addIngredient("2 cups semisweet chocolate chips");
        cookies.addIngredient("1 cup chopped walnuts");

        cookies.addStep("Preheat oven to 350 degrees F (175 degrees C).");
        cookies.addStep("Cream together the butter, white sugar, and brown sugar until smooth. Beat in the eggs one at a time, then stir in the vanilla. Dissolve baking soda in hot water. Add to batter along with salt. Stir in flour, chocolate chips, and nuts. Drop by large spoonfuls onto ungreased pans.");
        cookies.addStep("Bake for about 10 minutes in the preheated oven, or until edges are nicely browned.");

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

    public void next() {
        /*TextView tv1 = (TextView)findViewById(R.id.stepDescriptionText);
        tv1.setText(cookies.stepIndexOf(0));
        setContentView(tv1);

        String string = getString(R.string.stepDirectionsText);
        string = cookies.stepIndexOf(0); */

        final TextView textViewToChange = (TextView) findViewById(R.id.stepDescriptionText);
        textViewToChange.setText("The new text that I'd like to display now that the user has pushed a button.");
    }

}