package com.hajres.recipeapp.services;

import com.hajres.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
