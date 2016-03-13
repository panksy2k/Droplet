package com.pardasani.digital.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by pankajpardasani on 15/02/2016.
 */

@Document
public class Account {
    @Id
    private int id;

    @Email(message = "Email should be a valid value")
    private String userNameEmail;

    @NotEmpty(message = "Password cannot be empty")
    private String userPassword;

    @NotEmpty(message = "Firstname cannot be empty")
    private String firstName;

    @NotEmpty(message = "Lastname cannot be empty")
    private String lastName;

    private LocalDateTime creationDate;

    private boolean agreeToTermsAndConditions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserNameEmail() {
        return userNameEmail;
    }

    public void setUserNameEmail(String userNameEmail) {
        this.userNameEmail = userNameEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isAgreeToTermsAndConditions() {
        return agreeToTermsAndConditions;
    }

    public void setAgreeToTermsAndConditions(boolean agreeToTermsAndConditions) {
        this.agreeToTermsAndConditions = agreeToTermsAndConditions;
    }
}
