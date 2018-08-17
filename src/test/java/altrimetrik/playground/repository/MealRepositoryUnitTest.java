package altrimetrik.playground.repository;


import altrimetrik.playground.domain.Meal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MealRepositoryUnitTest {


    @Autowired
    private MealRepository mealRepository;

    @Test
    public void givenMealNameExist_whenGetMeal_thenReturnMealWithIngredients() {
        // Given
        String name = "Meal1";
        // When
        Meal newMeal = mealRepository.findByName(name);
        // Then
        assertEquals("Meal1", newMeal.getName());

    }


}
