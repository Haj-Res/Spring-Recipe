package com.hajres.recipeapp.services;

import com.hajres.recipeapp.domain.Recipe;
import com.hajres.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipesServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipesServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Getting recipes");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findByOrderByIdAsc().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
