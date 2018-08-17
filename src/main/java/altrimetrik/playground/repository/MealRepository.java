package altrimetrik.playground.repository;

import altrimetrik.playground.domain.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {

    public Meal findByName(String name);
}
