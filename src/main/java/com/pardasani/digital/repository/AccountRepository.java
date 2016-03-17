package com.pardasani.digital.repository;

import com.pardasani.digital.domain.DropletUser;
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

    public DropletUser updateAccount(DropletUser changedDropletUser) {
        return operations.findAndModify(
                query(where("userNameEmail").is(changedDropletUser.getUserNameEmail())),
                update("firstName", changedDropletUser.getFirstName())
                        .set("lastName", changedDropletUser.getLastName())
                        .set("userPassword", changedDropletUser.getUserPassword()),
                new FindAndModifyOptions().returnNew(true), DropletUser.class);
    }

    public DropletUser findByUserNameEmail(String userNameEmail) {
        return operations.findOne(query(where("userNameEmail").is(userNameEmail.toLowerCase())), DropletUser.class);
    }

    public DropletUser save(DropletUser dropletUser) {
        this.operations.save(dropletUser);
        return findByUserNameEmail(dropletUser.getUserNameEmail().toLowerCase());
    }

    public List<DropletUser> findAllAccounts() {
        return this.operations.findAll(DropletUser.class);
    }

}
