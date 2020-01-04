package com.sox.models;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Cloneable, Serializable {
    private int customerId;
    private String username;
    private String password;
    private String gender;
    private String nationality;
    private Timestamp dateOfBirth;
    private Timestamp joinedDate;

    private ArrayList<Account> accounts;

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = (ArrayList<Account>) accounts;
    }

    public Customer() {
        accounts = new ArrayList<Account>();
    }

    //Constructor

    public Customer(int customerIdIn) {
        this.customerId = customerIdIn;
    }

    //Getter & Setters
    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerIdIn) {
        this.customerId = customerIdIn;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String usernameIn) {
        this.username = usernameIn;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String passwordIn) {
        this.password = passwordIn;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String genderIn) {
        this.gender = genderIn;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationalityIn) {
        this.nationality = nationalityIn;
    }

    public Timestamp getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirthIn) {
        this.dateOfBirth = dateOfBirthIn;
    }

    public Timestamp getJoinedDate() {
        return this.joinedDate;
    }

    public void setJoinedDate(Timestamp joinedDateIn) {
        this.joinedDate = joinedDateIn;
    }

    /**
     * setAll allows to set all persistent variables in one method call. This is
     * useful, when all data is available and it is needed to set the initial
     * state of this object. Note that this method will directly modify instance
     * variales, without going trough the individual set-methods.
     */

    public void setAll(
            int customerIdIn,
            String usernameIn,
            String passwordIn,
            String genderIn,
            String nationalityIn,
            Timestamp dateOfBirthIn,
            Timestamp joinedDateIn) {

            this.customerId = customerIdIn;
            this.username = usernameIn;
            this.password = passwordIn;
            this.gender = genderIn;
            this.nationality = nationalityIn;
            this.dateOfBirth = dateOfBirthIn;
            this.joinedDate = joinedDateIn;
    }

    /**
     * hasEqualMapping-method will compare two Customer instances and return
     * true if they contain same values in all persistent instance variables. If
     * hasEqualMapping returns true, it does not mean the objects are the same
     * instance. However it does mean that in that moment, they are mapped to
     * the same row in database.
     */

    public boolean hasEqualMapping(Customer valueObject) {

        if (valueObject.getCustomerId() != this.customerId) {
            return false;
        }
        if (valueObject.getUsername() != this.username) {
            return false;
        }

        if (valueObject.getPassword() != this.password) {
            return false;
        }

        if (valueObject.getGender() != this.gender) {
            return false;
        }

        if (valueObject.getNationality() != this.nationality) {
            return false;
        }

        if (valueObject.getDateOfBirth() != this.dateOfBirth) {
            return false;
        }

        if (valueObject.getJoinedDate() != this.dateOfBirth) {
            return false;
        }

        return true;
    }


}
