package com.miplodder.shorify.shortify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShortifyController {

    @Autowired
    ShortifyRepository shortifyRepository;

    @GetMapping(value = "/test", produces = MediaType.ALL_VALUE)
    public @ResponseBody
    String test() {
        System.out.println("inside");
        shortifyRepository.save(new Mapper("test123", "test123"));
        return "Hellow World";
    }

    @PostMapping(value = "/test")
    public @ResponseBody
    String postMapping() {
        System.out.println("inside");
        shortifyRepository.save(new Mapper("test123", "test123"));
        return "Hellow World";
    }
}
