package com.hajres.recipeapp.repositories;

import com.hajres.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findByOrderByIdAsc();
}
