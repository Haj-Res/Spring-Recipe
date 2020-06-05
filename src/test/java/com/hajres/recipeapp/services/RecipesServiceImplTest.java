package com.hajres.recipeapp.services;

import com.hajres.recipeapp.domain.Recipe;
import com.hajres.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipesServiceImplTest {

    RecipesServiceImpl recipesService;
    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipesService = new RecipesServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        List<Recipe> recipeSet = new ArrayList<>();
        recipeSet.add(recipe);
        when(recipeRepository.findByOrderByIdAsc()).thenReturn(recipeSet);
        Set<Recipe> recipes = recipesService.getRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findByOrderByIdAsc();
    }
}