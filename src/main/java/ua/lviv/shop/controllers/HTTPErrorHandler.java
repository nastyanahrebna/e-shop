package ua.lviv.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wild_bo on 14.09.16.
 */

@Controller
public class HTTPErrorHandler {

    @RequestMapping(value = "/400")
    public String error400(){
        return "views-error-400";
    }

    @RequestMapping(value = "/404")
    public String error404(){
        return "views-error-404";
    }

    @RequestMapping(value = "/500")
    public String error500(){
        return "views-error-500";
    }

}
