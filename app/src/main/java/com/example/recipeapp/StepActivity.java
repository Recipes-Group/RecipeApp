package com.example.recipeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StepActivity extends AppCompatActivity {
    TextView oldStep;
    TextView oldTitle;
    Toast toast1;
    Toast toast2;
    Toast toast3;
    Toast toast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        final Controller aController = (Controller) getApplicationContext();
        Log.d("in next method", "currentStep = " + aController.getCurrentStep());
        displayStep();
    }

    public void getInfo(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "You pressed the INFO Button", Toast.LENGTH_LONG);
        toast.makeText(getApplicationContext(), "Commands Info", Toast.LENGTH_LONG);

        toast.show();

        Intent intent = new Intent(this, InfoButtonActivity.class);
        startActivity(intent);
    }

    public void next(View v) {
        final Controller aController = (Controller) getApplicationContext();
        aController.setCurrentStep(aController.getCurrentStep() + 1);

        if(aController.getCurrentStep() > aController.getRecipe().getNumberSteps()) {
            toast1 = Toast.makeText(getApplicationContext(), "This is the last step. Say 'Quit' if you are finished.", Toast.LENGTH_LONG);
            toast1.show();
            aController.setCurrentStep(aController.getCurrentStep() - 1);
            return;
        }

        displayStep();

        toast2 = Toast.makeText(getApplicationContext(), "currentStep = ", Toast.LENGTH_LONG);

        Log.d("in next method", aController.getCurrentStep() + "current step");

        Button mButton = (Button) findViewById(R.id.nextButton);

    }

    public void back(View v) {
        final Controller aController = (Controller) getApplicationContext();
        aController.setCurrentStep(aController.getCurrentStep() - 1);

        if(aController.getCurrentStep() < 0) {
            toast1 = Toast.makeText(getApplicationContext(), "This is the first step. Say or press 'NEXT' to continue.", Toast.LENGTH_LONG);
            toast1.show();
            aController.setCurrentStep(aController.getCurrentStep() + 1);;
            return;
        }

        Toast toast = Toast.makeText(getApplicationContext(), "currentStep = ", Toast.LENGTH_LONG);

        displayStep();

        Button mButton = (Button) findViewById(R.id.nextButton);
    }

    public void repeat(View v) {
        //reads current text on the screen --> recipe.getStepIndexOf(currentStep - 1);
    }

    public void skip(View v) {
        //popup --> asks "Which step would you like to skip to?"
        final Controller aController = (Controller) getApplicationContext();

        toast3 = Toast.makeText(getApplicationContext(), "You pressed the SKIP button", Toast.LENGTH_LONG);
        toast3.show();

        Intent intent2 = new Intent(this, SkipPopup.class);
        startActivity(intent2);

        EditText step = findViewById(R.id.skipPromptNum);
        String currentStep = step.getText().toString();
        aController.setCurrentStep(Integer.parseInt(currentStep));

        //Set newStep as the new step
       displayStep();
    }

    public void quit(View v) {
        //popup --> asks "are you sure you want to quit?"
        //returns to the home page

        //popup --> asks "Which step would you like to skip to?"

        toast4 = Toast.makeText(getApplicationContext(), "You pressed the QUIT button", Toast.LENGTH_LONG);
        toast4.show();

        Intent intent3 = new Intent(this, QuitPopup.class);
        startActivity(intent3);
    }

    public void displayStep() {
        final Controller aController = (Controller) getApplicationContext();
        oldStep = (TextView) findViewById(R.id.stepDescriptionText);
        oldTitle = (TextView) findViewById(R.id.stepTitle);
        if(aController.getCurrentStep() == 0) {
            oldStep.setText(ingredientsToString());
            oldTitle.setText("Ingredients");
        }
        else {
            oldStep.setText(aController.getRecipe().getSteps().get(aController.getCurrentStep() - 1));
            oldTitle.setText("Step #" + (aController.getCurrentStep()));
        }
    }

    private String ingredientsToString() {
        final Controller aController = (Controller) getApplicationContext();



        String toPrint = "";
        for(int i = 0; i < aController.getRecipe().getNumberIngredients(); i++) {
            toPrint = toPrint.concat(aController.getRecipe().getIngredients().get(i) + "\n");
        }

        return toPrint;
    }
}