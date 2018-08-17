package altrimetrik.playground.controller;

import altrimetrik.playground.domain.Meal;
import altrimetrik.playground.exception.MealNotFoundException;
import altrimetrik.playground.service.MealService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/meal")
public class MealController {

    @Autowired
    MealService mealService;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Meal findByName(@PathVariable String name) throws NotFoundException {
        Meal meal = mealService.findByName(name);
        if (meal == null) {
            throw new MealNotFoundException(name);
        }
        meal.calcOverallNutritionalValue();
        return meal;

    }


}



