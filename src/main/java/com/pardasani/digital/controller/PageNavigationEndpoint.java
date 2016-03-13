package com.pardasani.digital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pankajpardasani on 15/02/2016.
 */

@Controller
@RequestMapping("/")
public class PageNavigationEndpoint {
    @RequestMapping(method = RequestMethod.GET, path = {"/", "/home"})
    public String getHomePage(Model model) {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/subscription"})
    public String getSubscriptionPage() {
        return "subscription";
    }
}
