package com.example.recipeapp;

import java.util.ArrayList;

public class Recipe {

    private String recipeName;
    private String url;
    private ArrayList<String> steps = new ArrayList<String>();
    private ArrayList<String> ingredients = new ArrayList<String>();
    private int numUserInput;
    private boolean microphoneOn = false;
    private int step = 0;

    Recipe(String name, String link) {
        recipeName = name;
        url = link;
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

    public String stepIndexOf(int index) {
        return steps.get(index);
    }

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

    public void ingredientsToString() {
        System.out.println("\nINGREDIENTS");

        for(int i = 0; i<this.getNumberIngredients(); i++) {
            System.out.println(this.ingredientIndexOf(i));
        }
    }

    public String getURL() {
        return url;
    }

    public void changeMicStatus() {
        microphoneOn = !microphoneOn;
    }

    // ========================================================================================================================================

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
    public String back() {
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

    // =============================================================================================================================================

}
