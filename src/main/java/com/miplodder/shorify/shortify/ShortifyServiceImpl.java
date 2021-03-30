package com.miplodder.shorify.shortify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class ShortifyServiceImpl implements ShortifyService {

    @Autowired
    private ShortifyRepository shortifyRepository;

    @Override
    public void getActualUrl(final String value, final HttpServletResponse httpServletResponse) throws IOException {
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

    @Override
    public ShortifyResponse shortifyUrl(final ShortifyRequest shortifyRequest, final HttpServletRequest httpServletRequest) {
        String value = Utility.encoding(shortifyRepository.getMaxTransactionId() + 1);
        Mapper mapper = shortifyRepository.save(new Mapper(shortifyRequest.getKey(), value, (new Date()).toString()));
        ShortifyResponse shortifyResponse = new ShortifyResponse();
        shortifyResponse.setValue(httpServletRequest.getRequestURL().toString().split(httpServletRequest.getRequestURI())[0] + "/k/" + mapper.getValue());
        return shortifyResponse;
    }
}
