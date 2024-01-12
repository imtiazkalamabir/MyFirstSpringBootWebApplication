package com.in28mintues.springboot.myfirstwebapp.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginFormController {

    /*private AuthenticationService authenticationService;


    //@Autowired - not necessary for constructor injection
    public LoginFormController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }*/

    /*@RequestMapping(value = "loginform", method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login_form";
    }*/

    /*@RequestMapping(value = "loginform", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

        // Authentication
        // name - in28minutes
        // password - dummy
        if(authenticationService.authenticate(name, password)) {
            model.put("name", name);
            return "welcome";
        }

        model.put("errorMessage", "Invalid Credentials! Please try again.");
        return "login_form";

    }*/
}
