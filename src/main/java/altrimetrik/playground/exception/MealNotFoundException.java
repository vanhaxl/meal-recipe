package altrimetrik.playground.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The meal not found")
public class MealNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -694354952032299587L;

    private String mealName;

    public MealNotFoundException(String mealName) {
        super();
        this.mealName = mealName;
    }


}
