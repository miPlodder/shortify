package com.miplodder.shorify.shortify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Controller
public class ShortifyController {

    @Autowired
    ShortifyRepository shortifyRepository;

    @GetMapping(value = "k/{value}", produces = MediaType.ALL_VALUE)
    public @ResponseBody
    void test(@PathVariable("value") String value, HttpServletResponse httpServletResponse) throws IOException {
        System.out.println("Executing /k/{value} endpoint");
        List<Mapper> mapper = shortifyRepository.findByValue(value);
        if (mapper == null || mapper.size() == 0) {
            // TODO -> Add fallback page for errors
            httpServletResponse.sendRedirect("/");
            return;
        }
        String key = mapper.get(0).getKey();
        System.out.println("Redirecting to url: " + key);
        httpServletResponse.sendRedirect(key);
    }

    @PostMapping(value = "/shortify")
    public @ResponseBody
    ShortifyResponse postMapping(@RequestBody ShortifyRequest shortifyRequest, HttpServletRequest httpServletRequest) {
        System.out.println("Executing /shortify endpoint");
        // Todo -> Change encoding
        String value = Base64.getEncoder().encodeToString(shortifyRequest.getKey().getBytes());
        Mapper mapper = shortifyRepository.save(new Mapper(shortifyRequest.getKey(), value, (new Date()).toString()));
        ShortifyResponse shortifyResponse = new ShortifyResponse();
        shortifyResponse.setValue(httpServletRequest.getRequestURL().toString().split(httpServletRequest.getRequestURI())[0] + "/k/" + mapper.getValue());
        return shortifyResponse;
    }
}
