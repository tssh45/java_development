package com.sox.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import com.sox.exceptions.NotFoundException;

import com.sox.models.Account;

/**
 * Account Data Access Object (DAO).
 * This class contains all database handling that is needed to
 * permanently store and retrieve Account object instances.
 */


public interface AccountDAOImpl implements AccountDAO {

    public static int getLastInsertedRow(Connection conn) throws SQLException {
        String sql = "SELECT * from account ORDER BY account_id DESC LIMIT 1";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            return resultSet.getInt("account_id");
        }
        return 0;
    }

    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */

    public static Account createValueObject() {
        return new Account();
    }

    public Account getObject(Connection conn, int accountId) throws NotFoundException, SQLException {
        Account valueObject = createValueObject();
        valueObject.setAccount_id(accountId);
        load(conn, valueObject);
        return valueObject;
    }

    /**
     * load-method. This will load valueObject contents from database using
     * Primary-Key as identifier. Upper layer should use this so that valueObject
     * instance is created and only primary-key should be specified. Then call
     * this method to complete other persistent information. This method will
     * overwrite all other fields except primary-key and possible runtime variables.
     * If load can not find matching row, NotFoundException will be thrown.
     *  @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be loaded.
     */

    public static void load(Connection conn, Account valueObject) throws NotFoundException, SQLException {
        String sql = "SELECT * FROM account WHERE (account_id = ? ) ";
        PreparedStatement stmnt = null;

        try {
            stmnt = conn.prepareStatement(sql);
            stmnt.setInt(1,valueObject.getAccount_id();
            singleQuery(conn, stmnt, valueObject);
        } finally {
            if (stmnt != null)
                stmnt.close();
        }
    }


    /**
     * LoadAll-method. This will read all contents from database table and
     * build a List containing valueObjects. Please note, that this method
     * will consume huge amounts of resources if table has lot's of rows.
     * This should only be used when target tables have only small amounts
     * of data.
     *
     * @param conn         This method requires working database connection.
     */

    public static List loadAll(Connection conn) throws SQLException {
        String sql = "SELECT * from account order by accountID ASC";
        List searchResults = listQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }

    /**
     * create-method. This will create new row in database according to supplied
     * valueObject contents. Make sure that values for all NOT NULL columns are
     * correctly specified. Also, if this table does not use automatic surrogate-keys
     * the primary-key must be specified. After INSERT command this method will
     * read the generated primary-key back to valueObject if automatic surrogate-keys
     * were used.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be created.
     *                     If automatic surrogate-keys are not used the Primary-key
     *                     field must be set for this to work properly.
     */

    public synchronized void create(Connection conn, Account valueObject) throws SQLException {

        String sql = "";
        PreparedStatement stmnt = null;
        ResultSet resultSet = null;

        try {
            sql = "INSERT INTO account ( account_id, pin, amount, "
                    + "account_type, bank_branch_id) VALUES (?, ?, ?, ?, ?) ";
            stmnt = conn.prepareStatement(sql);

            stmnt.setInt(1, valueObject.getAccount_id());
            stmnt.setInt(2, valueObject.getPin());
            stmnt.setDouble(3, valueObject.getAmount());
            stmnt.setInt(4, valueObject.getAccountType());
            stmnt.setInt(5, valueObject.getBankBranchId());

            int rowCount = databaseUpdate(conn, stmnt);
            if (rowCount != 1) {
                throw new SQLException("PrimaryKey error when updating the database");
            }
        } finally {
            if (stmnt != null)
                stmnt.close();
            }

        }

    /**
     * save-method. This method will save the current state of valueObject to database.
     * Save can not be used to create new instances in database, so upper layer must
     * make sure that the primary-key is correctly specified. Primary-key will indicate
     * which instance is going to be updated in database. If save can not find matching
     * row, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be saved.
     *                     Primary-key field must be set for this to work properly.
     */

    public static void save(Connection conn, Account valueObject) throws NotFoundException, SQLException{
        String sql = "\"UPDATE account SET pin = ?, amount = ?, account_type = ?, \"\n" +
                "               + \"bank_branch_id = ? WHERE (account_id = ? ) \";";
        PreparedStatement stmnt = null;

        try {
            stmnt = conn.prepareStatement(sql);
            stmnt.setInt(1, valueObject.getPin());
            stmnt.setDouble(2, valueObject.getAmount());
            stmnt.setInt(3, valueObject.getAccountType());
            stmnt.setInt(4, valueObject.getBankBranchId());
            stmnt.setInt(5, valueObject.getAccountType());

            int rowCount = AccountDAO.databaseUpdate(conn, stmnt);
            if (rowCount == 0) {
                throw new NotFoundException("Object not saved. PrimaryKey not found.");
            }
            if (rowCount > 1) {
                throw new SQLException("PrimaryKey Error when updating the database. (Many items were selected)");

            }
        } finally {
            if (stmnt != null)
                stmnt.close();
        }

    }

    public static void delete(Connection conn, Account valueObject) throws NotFoundException, SQLException {
        String sql = "DELETE * FROM account where (account_id = ?)";
        PreparedStatement stmnt = null;

        try {
            stmnt = conn.prepareStatement(sql);
            stmnt.setInt(1, valueObject.getAccount_id());

            int rowCount = AccountDAO.databaseUpdate(conn, stmnt);
            if (rowCount == 0) {
                throw new NotFoundException("Object could not be deleted. Primary key not found");
            }
            if (rowCount > 1) {
                throw new SQLException("Object not deleted because more than one object was selected");
            }
        } finally {
            if (stmnt != null)
                stmnt.close();
        }
    }

    /**
     * deleteAll-method. This method will remove all information from the table that matches
     * this Dao and ValueObject couple. This should be the most efficient way to clear table.
     * Once deleteAll has been called, no valueObject that has been created before can be
     * restored by calling save. Restoring can only be done using create method but if database
     * is using automatic surrogate-keys, the resulting object will have different primary-key
     * than what it was in the deleted object. (Note, the implementation of this method should
     * be different with different DB backends.)
     *
     * @param conn         This method requires working database connection.
     */

    public static void deleteAll(Connection conn, Account valueObject) throws NotFoundException, SQLException {
        String sql = "DELETE from account";
        PreparedStatement stmnt = null;

        try {
            stmnt = conn.prepareStatement(sql);
            int rowCount = AccountDAO.databaseUpdate(conn, stmnt);
        } finally {
            if (stmnt != null) {
                stmnt.close();
            }
        }
    }

    public int countAll(Connection conn) throws SQLException {
        String sql = "SELECT count(*) from account";
        PreparedStatement stmnt = null;
        ResultSet resultSet = null;
        int allRows = 0;

        try {
            stmnt = conn.prepareStatement(sql);
            resultSet = stmnt.executeQuery();

            if (resultSet.next())
                allRows = resultSet.getInt(1);
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (stmnt != null)
                stmnt.close();
        }
        return allRows;

    }

    public List searchMatching(Connection conn, Account valueObject) throws SQLException {
        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM account where 1=1");

        if (valueObject.getAccount_id() != 0) {
            if (first) {
                first = false
            }
            sql.append("AND accountID = ").append(valueObject.getAccount_id()).append(" ");
        }

        if (valueObject.getPin() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND pin = ").append(valueObject.getPin()).append(" ");
        }

        if (valueObject.getAmount() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND amount = ").append(valueObject.getAmount()).append(" ");
        }

        if (valueObject.getAccountType() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND accountType = ").append(valueObject.getAccountType()).append(" ");
        }

        if (valueObject.getBankBranchId() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND bankBranchId = ").append(valueObject.getBankBranchId()).append(" ");
        }
        sql.append("ORDER by accountID ASC");

        // Prevent accidential full table results.
        // Use loadAll if all rows must be returned.

        if (first)
            searchResults = new ArrayList();
        else
            searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));
        return searchResults;

    }

    /**
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}
