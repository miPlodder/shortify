package com.miplodder.shorify.shortify;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ShortifyService {

    void getActualUrl(String value, HttpServletResponse httpServletResponse) throws IOException;

    ShortifyResponse shortifyUrl(ShortifyRequest shortifyRequest, HttpServletRequest httpServletRequest);
}
