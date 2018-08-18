package altrimetrik.playground.service;

import altrimetrik.playground.domain.Meal;
import altrimetrik.playground.repository.MealRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MealServiceUnitTest {

    @Mock
    private MealRepository mealRepository;

    @InjectMocks
    private MealService mealService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenMealNameExist_whenGetMeal_thenReturnMealWithIngredients() {
        // Given
        String name = "Meal1";
        Meal meal = new Meal();
        meal.setId(5L);
        meal.setName("Dinner");
        when(mealRepository.findByName(any(String.class))).thenReturn(meal);
        // When
        Meal newMeal = mealService.findByName(name);
        // Then
        assertEquals("Dinner", newMeal.getName());
    }

}
