package com.pardasani.digital.business;

import com.pardasani.digital.domain.DropletUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pankajpardasani on 27/02/2016.
 */

@Service(value = "accountService")
public interface AccountService {
    Integer registerUserAccountDetails(DropletUser dropletUser);
    DropletUser changeAccountRegistrationDetails(DropletUser oldDropletUser);
    List<DropletUser> findAllAccounts();
}
