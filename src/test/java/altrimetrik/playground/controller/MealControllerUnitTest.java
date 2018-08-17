package altrimetrik.playground.controller;

import altrimetrik.playground.domain.Ingredient;
import altrimetrik.playground.domain.Meal;
import altrimetrik.playground.service.MealService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MealController.class)
public class MealControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MealService mealService;

    @InjectMocks
    private MealController mealController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenMealNameExist_whenGetMeal_thenReturnMealWithIngredients() throws Exception {
        // setup mock Meal returned the mock service component
        Meal mockMeal = new Meal();
        mockMeal.setName("Dinner");
        Ingredient a = new Ingredient("Corn", 20);
        Ingredient b = new Ingredient("Beef", 30);
        Set<Ingredient> ingredientSet = new HashSet<>();
        ingredientSet.add(a);
        ingredientSet.add(b);
        mockMeal.setIngredients(ingredientSet);

        when(mealService.findByName(any(String.class)))
                .thenReturn(mockMeal);

        // simulate the form bean that would GET from the web page
        Meal meal = new Meal();
        meal.setName("Dinner");

        // simulate the form submit (GET)
        mockMvc
                .perform(get("/api/v1/meal/{name}", meal.getName()))
                .andExpect(status().isOk())
                .andReturn();
    }


}
