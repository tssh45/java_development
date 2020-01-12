package com.sox.dao;
import com.sox.models.Account;

public class DAOFactory {

    private DAOFactory() {}

    public static AccountDAO getAccountDAO() {
        return AccountDAOImpl();
    }


}
