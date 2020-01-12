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

        if (this.username == null) {
            if (valueObject.getUsername() != null)
                return (false);
        } else if(!this.username.equals(valueObject.getUsername())) {
            return false;
        }

        if (this.password == null) {
            if (valueObject.getUsername() != null)
                return false;
        }
        else if (!this.password.equals(valueObject.getPassword())) {
            return false;
        }

        if (this.gender == null) {
            if (valueObject.getPassword() != null)
                return false;
        }
        else if (!this.gender.equals(valueObject.getGender())) {
            return false;
        }

        if (this.nationality == null) {
            if (valueObject.getNationality() != null)
                return false;
        }
        else if(!this.nationality.equals(valueObject.getNationality())) {
            return false;
        }

        if (this.dateOfBirth == null) {
            if (valueObject.getDateOfBirth() != null)
                return false;
        }
        else if (!this.dateOfBirth.equals(valueObject.getDateOfBirth())) {
            return false;
        }

        if (this.joinedDate == null) {
            if (valueObject.getJoinedDate() != null)
                return false;
        }
        else if (!this.joinedDate.equals(valueObject.getJoinedDate())) {
            return false;
        }
        return true;
    }

    /**
     * toString will return String object representing the state of this
     * valueObject. This is useful during application development, and possibly
     * when application is writing object states in textlog.
     */

    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Customer, mapping to table customer\n");
        out.append("Persistent attributes: \n");
        out.append("customer_id = " + this.customerId + "\n");
        out.append("username = " + this.username + "\n");
        out.append("password = " + this.password + "\n");
        out.append("gender = " + this.gender + "\n");
        out.append("nationality = " + this.nationality + "\n");
        out.append("date_of_birth = " + this.dateOfBirth + "\n");
        out.append("date_of_join = " + this.joinedDate + "\n");
        return out.toString();
    }

    /**
     * Clone will return identical deep copy of this valueObject. Note, that
     * this method is different than the clone() which is defined in
     * java.lang.Object. Here, the retuned cloned object will also have all its
     * attributes cloned.
     */

    public Object clone() {
        Customer cloned = new Customer();

        cloned.setCustomerId(this.customerId);
        if (this.username != null)
            cloned.setUsername(new String(this.username));
        if (this.password != null)
            cloned.setPassword(new String(this.password));
        if (this.gender != null)
            cloned.setGender(new String(this.gender));
        if (this.nationality != null)
            cloned.setNationality(new String(this.password));
        if (this.dateOfBirth != null)
            cloned.setDateOfBirth((Timestamp) this.dateOfBirth );
        if (this.joinedDate != null)
            cloned.setJoinedDate((Timestamp) this.joinedDate);
        return cloned;
    }

    /**
     * getDaogenVersion will return information about generator which created
     * these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }



}


