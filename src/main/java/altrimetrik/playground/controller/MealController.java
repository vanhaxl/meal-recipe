package altrimetrik.playground.controller;

import altrimetrik.playground.domain.Meal;
import altrimetrik.playground.exception.MealNotFoundException;
import altrimetrik.playground.service.MealService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
@RequestMapping("/api/v1")
public class MealController {

    @Autowired
    MealService mealService;

    private String instance = "instance 0";


    @GetMapping("")
    public String message() {
        return "Hello from " + instance;
    }

    //addd comment here

    @GetMapping(value = "/meal/{name}", produces={"application/json"})
    public Meal findByName(@PathVariable String name) throws NotFoundException {
        Meal meal = mealService.findByName(name);
        if (meal == null) {
            throw new MealNotFoundException(name);
        }
        meal.calcOverallNutritionalValue();
        return meal;

    }


}



