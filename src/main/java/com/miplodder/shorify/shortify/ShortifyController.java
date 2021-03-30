package com.miplodder.shorify.shortify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ShortifyController {

    @Autowired
    ShortifyServiceImpl shortifyServiceImpl;

    @GetMapping(value = "k/{value}", produces = MediaType.ALL_VALUE)
    public void getActualUrl(@PathVariable("value") String value, HttpServletResponse httpServletResponse) throws IOException {
        System.out.println("Executing /k/{value} endpoint");
        shortifyServiceImpl.getActualUrl(value, httpServletResponse);
    }

    @PostMapping(value = "/shortify")
    public @ResponseBody
    ShortifyResponse shortifyUrl(@RequestBody ShortifyRequest shortifyRequest, HttpServletRequest httpServletRequest) {
        System.out.println("Executing /shortify endpoint");
        return shortifyServiceImpl.shortifyUrl(shortifyRequest, httpServletRequest);
    }
    //https://www.geeksforgeeks.org/how-to-create-a-link-in-javascript/
    //https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku
    //https://stackabuse.com/how-to-test-a-spring-boot-application/

}
