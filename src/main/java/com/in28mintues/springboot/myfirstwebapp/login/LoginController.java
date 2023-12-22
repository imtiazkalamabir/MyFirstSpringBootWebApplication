package com.in28mintues.springboot.myfirstwebapp.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp

    // http://localhost:8080/login?name=Abir
    // Mdoel
    @RequestMapping("login")
    public String gotoLoginPage(@RequestParam String name, ModelMap model) {
        model.put("name",name);
        logger.debug("Request param is {}", name);
        logger.info("Request param is {}", name);
        logger.warn("Request param is {}", name);
        // System.out.println("Request param is" + name); // not recommended for production code
        return "login";
    }

}
