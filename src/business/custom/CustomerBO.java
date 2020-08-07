package business.custom;

import business.SuperBO;
import entity.Customer;

import java.sql.ResultSet;
import java.util.List;

public interface CustomerBO extends SuperBO {
    public String getNewCustomerId()throws Exception;

    public List<Customer> getAllCustomers()throws Exception;

    public boolean saveCustomer(String id, String name, String address,String contact,String nic,String carNumber,String carModel)throws Exception;

    public boolean deleteCustomer(String customerId)throws Exception;

    public boolean updateCustomer( String name, String address,String contact,String nic,String carNumber,String carModel, String customerId)throws Exception;

    public ResultSet getCustomerIdList() throws Exception;
}
