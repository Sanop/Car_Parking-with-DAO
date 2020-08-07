package dao.custom;

import dao.CrudDAO;
import entity.Customer;

import java.sql.ResultSet;

public interface CustomerDAO extends CrudDAO<Customer , String> {

    public String getLastCustomerID()throws Exception;

    public ResultSet getCustomerIDList()throws Exception;
}
