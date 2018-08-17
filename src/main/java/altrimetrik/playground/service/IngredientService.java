package altrimetrik.playground.service;

import altrimetrik.playground.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

}
