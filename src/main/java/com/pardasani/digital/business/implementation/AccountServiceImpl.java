package com.pardasani.digital.business.implementation;

import com.pardasani.digital.business.AccountService;
import com.pardasani.digital.domain.DropletUser;
import com.pardasani.digital.exception.MediaManagementException;
import com.pardasani.digital.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Integer registerUserAccountDetails(DropletUser dropletUser) {
        DropletUser existingDropletUser = accountRepository.findByUserNameEmail(dropletUser.getUserNameEmail());
        if(null != existingDropletUser) throw new MediaManagementException("DropletUser / Email is already registered");

        existingDropletUser = accountRepository.save(dropletUser);
        return existingDropletUser.getId();
    }

    @Override
    public DropletUser changeAccountRegistrationDetails(DropletUser oldDropletUser) {
        return accountRepository.updateAccount(oldDropletUser);
    }

    @Override
    public List<DropletUser> findAllAccounts() {
        return accountRepository.findAllAccounts();
    }


}
