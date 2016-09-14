package ua.lviv.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.shop.DTO.Cart;
import ua.lviv.shop.entity.User;
import ua.lviv.shop.services.UserService;
import ua.lviv.shop.validators.UserValidator;

/**
 * Created by wild_bo on 28.07.16.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value = "/registration/{regVar}", method = RequestMethod.GET)
    public String singup(@PathVariable String regVar){

        User user = new User();

        regVar = regVar.replace("-",".");

        String[] userProperty = regVar.split("&");

        user.setFirstName(userProperty[0]);
        user.setLastName(userProperty[1]);

        String password = userProperty[2];

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));

        System.out.println(userProperty[3]);

        user.setEmail(userProperty[3]);

        userService.add(user);

        return "redirect:/";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String singup(Model model){
        model.addAttribute("user", new User());
        return "views-base-registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String singup(@ModelAttribute User user, BindingResult bindingResult){

        userValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors()){
            return "views-base-registration";
        }else{
            String registrationVar = user.getFirstName() + "&" + user.getLastName() + "&" + user.getPassword() + "&" + user.getEmail();
            userService.sendEmail(user.getId(), user.getEmail(), user.getFirstName(), user.getPassword(), registrationVar);
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/cart/remove/all")
    public String removeAll(){
       Cart.getInstance().getProductList().clear();
        return "redirect:/";
    }

}
