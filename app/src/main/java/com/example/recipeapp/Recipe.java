package com.example.recipeapp;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Recipe {

    private String recipeName;
    private String url;
    private ArrayList<String> steps = new ArrayList<String>();
    private ArrayList<String> ingredients = new ArrayList<String>();
    private int numUserInput;
    private boolean microphoneOn = false;
    private int step = 0;

    public Recipe(String name, String link) {
        recipeName = name;
        url = link;
    }

    public Recipe(String name, String link, ArrayList<String> ingredients, ArrayList<String> steps) {
        recipeName = name;
        url = link;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void addStep(String stepText) {
        steps.add(stepText);
    }

    public int getNumberSteps() {
        return steps.size();
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    public String stepIndexOf(int index) { return steps.get(index); }

    public void displayStep(int index) {
        System.out.println(steps.get(index));
    }

    public void stepsToString() {
        System.out.println("INSTRUCTIONS");

        for(int i = 0; i<this.getNumberSteps(); i++) {
            System.out.println(this.stepIndexOf(i));
        }
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void addIngredient(String ingredientText) {
        ingredients.add(ingredientText);
    }

    public int getNumberIngredients() {
        return ingredients.size();
    }

    public String ingredientIndexOf(int index) {
        return ingredients.get(index);
    }

    public String ingredientsToString() {
        String toPrint = new String("");
        for(int i = 0; i < this.getNumberIngredients(); i++) {
            toPrint = toPrint.concat(ingredientIndexOf(i));
        }

        return toPrint;
    }

    public String getURL() {
        return url;
    }

    public void changeMicStatus() {
        microphoneOn = !microphoneOn;
    }

    //1. Next
    public String getNextStep() {
        step++;
        return this.stepIndexOf(step);
    }

    //2. Repeat
    public String repeatStep() {
        return this.stepIndexOf(step);
    }

    //3. Back
    public String getPreviousStep() {
        step--;
        return this.stepIndexOf(step);
    }

    //4. Skip
    public String skipTo(int newStep) {
        step = newStep - 1;
        return this.stepIndexOf(step);
    }

    //5. Finish
    public void finish() {

    }
}
