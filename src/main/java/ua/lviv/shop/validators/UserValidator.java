package ua.lviv.shop.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.lviv.shop.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wild_bo on 06.08.16.
 */

@Component
public class UserValidator implements Validator {

    private Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","firstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName","lastName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"passwordConfirm","password.empty");

        if(!user.getPassword().equals(user.getPasswordConfirm())){
            errors.rejectValue("passwordConfirm","passwordConfirm.error");
        }

        Matcher matcher;
        if(!(matcher = pattern.matcher(user.getEmail())).matches()){
            errors.rejectValue("email", "bad.email");
        }
    }
}
