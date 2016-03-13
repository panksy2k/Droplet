package com.pardasani.digital.business.implementation;

import com.pardasani.digital.business.AccountService;
import com.pardasani.digital.domain.Account;
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
    public Integer registerUserAccountDetails(Account account) {
        Account existingAccount = accountRepository.findByUserNameEmail(account.getUserNameEmail());
        if(null != existingAccount) throw new MediaManagementException("Account / Email is already registered");

        existingAccount = accountRepository.save(account);
        return existingAccount.getId();
    }

    @Override
    public Account changeAccountRegistrationDetails(Account oldAccount) {
        return accountRepository.updateAccount(oldAccount);
    }

    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAllAccounts();
    }


}
