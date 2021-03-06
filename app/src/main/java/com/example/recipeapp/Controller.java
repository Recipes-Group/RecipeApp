package com.example.recipeapp;

import android.app.Application;

import java.util.ArrayList;

public class Controller extends Application {
    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    private int recipeNum;
    private int currentStep;

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe r) {
        recipes.add(r);
    }

    public int getRecipeNum() {

        return recipeNum;
    }

    public void setRecipeInformation(int buttonNum) {
        recipeNum = buttonNum;
        currentStep = 0;
    }

    public Recipe getRecipe() {
        return recipes.get(recipeNum);
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(int i) {

        currentStep = i;
    }

    public int getNumberIngredients(int ingredientIndex) {

        return recipes.get(ingredientIndex).getNumberIngredients();
    }

}
