package com.pardasani.digital.controller;

import com.pardasani.digital.business.AccountService;
import com.pardasani.digital.domain.DropletUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by pankajpardasani on 17/02/2016.
 */

@Controller
@RequestMapping("/account")
public class AccountRegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(AccountRegistrationController.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/registration/form", method = RequestMethod.GET)
    public String initRegistrationForm(Model model) {
        model.addAttribute("ddUser", new DropletUser());
        return "/registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doAccountRegistration(HttpServletRequest request,
                                      @Valid @ModelAttribute DropletUser dropletUser,
                                      BindingResult bindingResult,
                                      Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("ddUser", dropletUser);
            logger.info("Error occurred whilst saving details");
            return "/registration";
        }
        else {
            accountService.registerUserAccountDetails(dropletUser);
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/register/amend", method = RequestMethod.POST)
    public void changeAccountRegistration(@Valid DropletUser userDropletUser) {
        accountService.changeAccountRegistrationDetails(userDropletUser);
    }

}
