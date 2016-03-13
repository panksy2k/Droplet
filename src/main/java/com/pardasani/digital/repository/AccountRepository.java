package com.pardasani.digital.repository;

import com.pardasani.digital.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Update.*;

import static org.springframework.data.mongodb.core.query.Criteria.*;

import static org.springframework.data.mongodb.core.query.Query.*;

/**
 * Created by pankajpardasani on 03/03/2016.
 */
@Repository
public class AccountRepository {

    private final MongoOperations operations;

    @Autowired
    public AccountRepository(MongoOperations operations) {
        this.operations = operations;
    }

    public Account updateAccount(Account changedAccount) {
        return operations.findAndModify(
                query(where("userNameEmail").is(changedAccount.getUserNameEmail())),
                update("firstName", changedAccount.getFirstName())
                        .set("lastName", changedAccount.getLastName())
                        .set("userPassword", changedAccount.getUserPassword()),
                new FindAndModifyOptions().returnNew(true), Account.class);
    }

    public Account findByUserNameEmail(String userNameEmail) {
        return operations.findOne(query(where("userNameEmail").is(userNameEmail)), Account.class);
    }

    public Account save(Account account) {
        this.operations.save(account);
        return findByUserNameEmail(account.getUserNameEmail());
    }

    public List<Account> findAllAccounts() {
        return this.operations.findAll(Account.class);
    }

}
