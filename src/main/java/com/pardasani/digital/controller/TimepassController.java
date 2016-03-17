package com.pardasani.digital.controller;

import com.pardasani.digital.business.AccountService;
import com.pardasani.digital.domain.DropletUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pankajpardasani on 05/03/2016.
 */
@RestController
@RequestMapping("/accounting")
public class TimepassController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public List<DropletUser> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    @RequestMapping(value = "/register/amend", method = RequestMethod.POST)
    public void changeAccountRegistration(@RequestBody DropletUser userDropletUser) {
        accountService.changeAccountRegistrationDetails(userDropletUser);
    }
}
