package com.embr.mediapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@RestController
@RequestMapping("/utils")
public class UtilController {

    @Autowired
    private LocaleResolver localeResolver;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @GetMapping("/locale/{loc}")
    public ResponseEntity<Void> changeLocale(@PathVariable("loc") String loc){
        Locale userLocale = null;

        switch (loc){
            case "en":
                userLocale = Locale.ENGLISH;
                break;
            case "fr":
                userLocale = Locale.FRANCE;
            break;
            default:
                userLocale = Locale.ROOT;
                break;
        }
       localeResolver.setLocale(httpServletRequest, httpServletResponse, userLocale);
    return null;
    }

}
