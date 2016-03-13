package com.pardasani.digital.business;

import com.pardasani.digital.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pankajpardasani on 27/02/2016.
 */

@Service(value = "accountService")
public interface AccountService {
    Integer registerUserAccountDetails(Account account);
    Account changeAccountRegistrationDetails(Account oldAccount);
    List<Account> findAllAccounts();
}
