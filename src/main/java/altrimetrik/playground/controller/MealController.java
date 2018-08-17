package altrimetrik.playground.controller;

import altrimetrik.playground.domain.Meal;
import altrimetrik.playground.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/meal")
public class MealController {

    @Autowired
    MealService mealService;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Meal finalByName(@PathVariable String name) {
        Meal meal = mealService.findByName(name);
        meal.calcOverallNutritionalValue();
        return meal;

    }


}



