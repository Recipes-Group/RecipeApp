package com.example.recipeapp;

import android.app.Application;

import java.util.ArrayList;

public class Controller extends Application {
    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    private int recipeNum;
    private Recipe recipe;

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe r) {
        recipes.add(r);
    }

    public int getRecipeNum() {
        return recipeNum;
    }

    public void setRecipeNum(int buttonNum) {
        recipeNum = buttonNum;
        recipe = recipes.get(recipeNum);
    }

    public Recipe getRecipe() {

        return recipe;
    }
}
