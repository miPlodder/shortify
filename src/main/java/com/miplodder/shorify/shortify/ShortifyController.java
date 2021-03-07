package com.miplodder.shorify.shortify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ShortifyController {

    @Autowired
    ShortifyRepository shortifyRepository;

    @GetMapping(value = "k/{key}", produces = MediaType.ALL_VALUE)
    public @ResponseBody
    String test(@PathVariable("key") String key) {
        System.out.println("key");
        return shortifyRepository.findByKey(key).getValue();
    }

    @PostMapping(value = "/shorten")
    public @ResponseBody
    String postMapping() {
        System.out.println("inside");
        shortifyRepository.save(new Mapper("test123", "test123", (new Date()).toString()));
        return "Hellow World";
    }
}
