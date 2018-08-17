package altrimetrik.playground.service;

import altrimetrik.playground.domain.Meal;
import altrimetrik.playground.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    @Autowired
    MealRepository mealRepository;

    public Meal findByName(String name) {
        return mealRepository.findByName(name);
    }

    public Meal findById(Long id) {
        return mealRepository.findOne(id);
    }

}
