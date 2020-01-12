package com.sox.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.sox.exceptions.NotFoundException;
import com.sox.models.Account;

public interface AccountDAO {
    public int getLastInsertedRowID(Connection conn) throws SQLException;
    private static Account createValueObject();
    public Account getObject(Connection conn, int account_id) throws NotFoundException, SQLException;
    public void load(Connection conn, Account valueObject) throws NotFoundException, SQLException;
    public static List loadAll(Connection conn) throws SQLException;
    public void create(Connection conn, Account valueObject) throws SQLException;
    public static void save(Connection conn, Account valueObject) throws NotFoundException, SQLException;
    public static void delete(Connection conn, Account valueObject) throws NotFoundException, SQLException;
    public static void deleteAll(Connection conn, Account valueObject) throws NotFoundException, SQLException;
    public int countAll(Connection conn) throws SQLException;
    public List searchMatching(Connection conn, Account valueObject) throws SQLException;
    public static int databaseUpdate(Connection conn, PreparedStatement stmnt) throws SQLException;
    public void singleQuery(Connection conn, PreparedStatement stmnt, Account valueObject) throws NotFoundException, SQLException;
    public List listQuery(Connection conn, PreparedStatement stmnt) throws SQLException;


}
